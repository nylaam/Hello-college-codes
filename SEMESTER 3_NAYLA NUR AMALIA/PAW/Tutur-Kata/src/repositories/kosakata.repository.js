const db = require('../config/database');

const REVIEW_WEIGHT = `
  (6 - tingkat_hafal) * 2.0
  + MIN(julianday('now') - julianday(COALESCE(terakhir_diulang, created_at)), 30) / 5.0
  + (RANDOM() & 127) / 128.0
`;

function buildWhere(filters = {}) {
  const clauses = [];
  const params = [];
  if (filters.q) {
    clauses.push('(kata LIKE ? OR arti LIKE ?)');
    params.push(`%${filters.q}%`, `%${filters.q}%`);
  }
  if (filters.bahasa) {
    clauses.push('bahasa = ? COLLATE NOCASE');
    params.push(filters.bahasa);
  }
  if (filters.tingkat) {
    clauses.push('tingkat_hafal = ?');
    params.push(filters.tingkat);
  }
  if (filters.maks_tingkat) {
    clauses.push('tingkat_hafal <= ?');
    params.push(filters.maks_tingkat);
  }
  return { where: clauses.length ? `WHERE ${clauses.join(' AND ')}` : '', params };
}

const findAll = (filters, limit) => {
  const { where, params } = buildWhere(filters);
  return db.prepare(`SELECT * FROM kosakata ${where} ORDER BY created_at DESC, id DESC LIMIT ?`).all(...params, limit);
};
const findById = (id) => db.prepare('SELECT * FROM kosakata WHERE id = ?').get(id);
const create = (data) => {
  const result = db.prepare(`INSERT INTO kosakata (kata, arti, bahasa, contoh_kalimat, tingkat_hafal)
    VALUES (@kata, @arti, @bahasa, @contoh_kalimat, @tingkat_hafal)`).run(data);
  return findById(Number(result.lastInsertRowid));
};
const update = (id, data) => {
  db.prepare(`UPDATE kosakata SET kata=@kata, arti=@arti, bahasa=@bahasa,
    contoh_kalimat=@contoh_kalimat, tingkat_hafal=@tingkat_hafal WHERE id=@id`).run({ ...data, id });
  return findById(id);
};
const remove = (id) => db.prepare('DELETE FROM kosakata WHERE id = ?').run(id).changes > 0;
const findRandom = (filters) => {
  const { where, params } = buildWhere(filters);
  return db.prepare(`SELECT * FROM kosakata ${where} ORDER BY ${REVIEW_WEIGHT} DESC LIMIT 1`).get(...params);
};
function findQuizWords(filters, limit) {
  const { where, params } = buildWhere(filters);
  const words = db.prepare(`SELECT * FROM kosakata ${where} ORDER BY ${REVIEW_WEIGHT} DESC LIMIT ?`).all(...params, limit);
  const distractors = db.prepare(`SELECT arti FROM kosakata WHERE id != ? AND arti != ? COLLATE NOCASE
    GROUP BY arti COLLATE NOCASE ORDER BY (bahasa = ? COLLATE NOCASE) DESC, RANDOM() LIMIT 3`);
  return words.map((word) => ({ ...word, distractors: distractors.all(word.id, word.arti, word.bahasa).map((item) => item.arti) }));
}
function getStatistics() {
  const rows = db.prepare('SELECT tingkat_hafal AS tingkat, COUNT(*) AS jumlah FROM kosakata GROUP BY tingkat_hafal').all();
  const per_tingkat = { 1: 0, 2: 0, 3: 0, 4: 0, 5: 0 };
  rows.forEach(({ tingkat, jumlah }) => { per_tingkat[tingkat] = jumlah; });
  const bahasa = db.prepare('SELECT bahasa, COUNT(*) AS jumlah FROM kosakata GROUP BY bahasa COLLATE NOCASE ORDER BY jumlah DESC').all();
  const total = Object.values(per_tingkat).reduce((sum, value) => sum + value, 0);
  return { total, hafal: per_tingkat[5], dipelajari: total - per_tingkat[5], per_tingkat, bahasa };
}
function recordAnswer(id, correct) {
  const current = findById(id);
  if (!current) return null;
  const nextLevel = Math.min(5, Math.max(1, current.tingkat_hafal + (correct ? 1 : -1)));
  db.prepare("UPDATE kosakata SET tingkat_hafal = ?, terakhir_diulang = datetime('now') WHERE id = ?").run(nextLevel, id);
  return findById(id);
}

module.exports = { findAll, findById, create, update, remove, findRandom, findQuizWords, getStatistics, recordAnswer };
