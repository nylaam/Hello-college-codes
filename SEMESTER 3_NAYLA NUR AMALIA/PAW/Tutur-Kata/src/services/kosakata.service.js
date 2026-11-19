const repository = require('../repositories/kosakata.repository');
const { validateWord } = require('../validators/kosakata.validator');

const clamp = (value, min, max) => Math.min(max, Math.max(min, value));
const shuffle = (items) => {
  const result = [...items];
  for (let index = result.length - 1; index > 0; index -= 1) {
    const target = Math.floor(Math.random() * (index + 1));
    [result[index], result[target]] = [result[target], result[index]];
  }
  return result;
};
function parseFilters(query = {}) {
  const filters = {};
  if (query.q) filters.q = String(query.q).trim().slice(0, 100);
  if (query.bahasa) filters.bahasa = String(query.bahasa).trim().slice(0, 40);
  if (query.tingkat !== undefined && query.tingkat !== '') {
    const level = Number(query.tingkat);
    if (!Number.isInteger(level) || level < 1 || level > 5) throw Object.assign(new Error('Filter tingkat harus bernilai 1 sampai 5.'), { status: 400 });
    filters.tingkat = level;
  }
  if (query.maks_tingkat !== undefined && query.maks_tingkat !== '') {
    const level = Number(query.maks_tingkat);
    if (!Number.isInteger(level) || level < 1 || level > 5) throw Object.assign(new Error('Maksimal tingkat harus bernilai 1 sampai 5.'), { status: 400 });
    filters.maks_tingkat = level;
  }
  return filters;
}
function list(query) {
  const filters = parseFilters(query);
  const limit = clamp(Number.parseInt(query.limit, 10) || 500, 1, 1000);
  return repository.findAll(filters, limit);
}
function getById(id) {
  const word = repository.findById(id);
  if (!word) throw Object.assign(new Error('Kata tidak ditemukan.'), { status: 404 });
  return word;
}
function create(body) {
  const { data, errors } = validateWord(body);
  if (errors.length) throw Object.assign(new Error('Data kosakata belum valid.'), { status: 400, details: errors });
  return repository.create(data);
}
function update(id, body) {
  getById(id);
  const { data, errors } = validateWord(body);
  if (errors.length) throw Object.assign(new Error('Data kosakata belum valid.'), { status: 400, details: errors });
  return repository.update(id, data);
}
function remove(id) {
  if (!repository.remove(id)) throw Object.assign(new Error('Kata tidak ditemukan.'), { status: 404 });
}
function random(query) {
  const word = repository.findRandom(parseFilters(query));
  if (!word) throw Object.assign(new Error('Belum ada kata yang cocok.'), { status: 404 });
  return word;
}
function quiz(query) {
  const filters = parseFilters(query);
  const amount = clamp(Number.parseInt(query.jumlah, 10) || 10, 1, 50);
  const words = repository.findQuizWords(filters, amount);
  const questions = words.map((word) => {
    const options = shuffle([word.arti, ...word.distractors]);
    return {
      id: word.id, kata: word.kata, bahasa: word.bahasa, arti: word.arti,
      contoh_kalimat: word.contoh_kalimat, tingkat_hafal: word.tingkat_hafal,
      pilihan: options, jawaban_index: options.indexOf(word.arti),
    };
  });
  return { jumlah: questions.length, soal: questions };
}
function answer(id, body) {
  if (typeof body?.benar !== 'boolean') {
    throw Object.assign(new Error('Body harus berisi { "benar": true | false }.'), { status: 400 });
  }
  const updated = repository.recordAnswer(id, body.benar);
  if (!updated) throw Object.assign(new Error('Kata tidak ditemukan.'), { status: 404 });
  return updated;
}

module.exports = { list, getById, create, update, remove, random, quiz, statistics: repository.getStatistics, answer };
