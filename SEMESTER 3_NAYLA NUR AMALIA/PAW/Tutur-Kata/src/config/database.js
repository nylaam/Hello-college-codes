
const Database = require('better-sqlite3');
const path = require('node:path');
const fs = require('node:fs');

const databaseDir = path.join(__dirname, '../../database');

fs.mkdirSync(databaseDir, { recursive: true });

const databasePath = path.join(databaseDir, 'kosakata.db');

const db = new Database(databasePath);

db.pragma('journal_mode = WAL');
db.pragma('foreign_keys = ON');

db.exec(`
  CREATE TABLE IF NOT EXISTS kosakata (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    kata TEXT NOT NULL,
    arti TEXT NOT NULL,
    bahasa TEXT NOT NULL DEFAULT 'Inggris',
    contoh_kalimat TEXT NOT NULL DEFAULT '',
    tingkat_hafal INTEGER NOT NULL DEFAULT 1
      CHECK (tingkat_hafal BETWEEN 1 AND 5),
    terakhir_diulang TEXT,
    created_at TEXT NOT NULL DEFAULT (datetime('now'))
  );

  CREATE INDEX IF NOT EXISTS idx_kosakata_bahasa
  ON kosakata (bahasa);

  CREATE INDEX IF NOT EXISTS idx_kosakata_tingkat
  ON kosakata (tingkat_hafal);
`);

module.exports = db;
