const db = require('./db');

const contoh = [
  ['serendipity', 'keberuntungan menemukan hal baik tanpa dicari', 'Inggris', 'Meeting her was pure serendipity.'],
  ['reluctant', 'enggan', 'Inggris', 'He was reluctant to share his plan.'],
  ['thrive', 'tumbuh subur, berkembang', 'Inggris', 'Succulents thrive in dry weather.'],
  ['mitigate', 'mengurangi dampak', 'Inggris', 'Planting trees can mitigate flooding.'],
  ['ubiquitous', 'ada di mana-mana', 'Inggris', 'Smartphones are ubiquitous these days.'],
  ['木漏れ日 (komorebi)', 'sinar matahari yang menembus celah dedaunan', 'Jepang', '木漏れ日の中を歩いた。'],
  ['勉強 (benkyou)', 'belajar', 'Jepang', '毎日日本語を勉強します。'],
  ['美味しい (oishii)', 'enak', 'Jepang', 'このラーメンは美味しいです。'],
  ['감사합니다 (gamsahamnida)', 'terima kasih', 'Korea', '도와주셔서 감사합니다.'],
  ['맛있다 (masitda)', 'enak', 'Korea', '이 김치찌개 정말 맛있어요.'],
  ['Fernweh', 'kerinduan pada tempat yang jauh', 'Jerman', 'Ich habe Fernweh nach den Bergen.'],
  ['Feierabend', 'waktu selesai kerja', 'Jerman', 'Endlich Feierabend!'],
];

const hitung = db.prepare('SELECT COUNT(*) AS n FROM kosakata').get().n;
if (hitung > 0 && !process.argv.includes('--paksa')) {
  console.log(`Tabel sudah berisi ${hitung} kata. Jalankan "npm run seed -- --paksa" untuk menambah data contoh.`);
  process.exit(0);
}

const tambah = db.prepare(
  'INSERT INTO kosakata (kata, arti, bahasa, contoh_kalimat) VALUES (?, ?, ?, ?)'
);
db.transaction(() => contoh.forEach((c) => tambah.run(...c)))();
console.log(`${contoh.length} kata contoh ditambahkan.`);
