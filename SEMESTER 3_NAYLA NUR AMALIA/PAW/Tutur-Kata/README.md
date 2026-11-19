# Tutur Kata 🌱

Tutur Kata adalah aplikasi belajar kosakata lintas bahasa yang menyediakan fitur CRUD, flashcard, kuis pilihan ganda, statistik hafalan, dan spaced repetition. Aplikasi dibuat menggunakan Express.js, SQLite (`better-sqlite3`), HTML, CSS, dan Vanilla JavaScript.

## Menjalankan aplikasi

Pastikan Node.js 18 atau lebih baru sudah terpasang.

```bash
npm install
npm run seed       # opsional: tambah 12 kosakata contoh
npm run dev        # mode pengembangan
# atau: npm start
```

Buka http://localhost:3000. Data disimpan pada `kosakata.db` di root project dan database akan dibuat otomatis saat aplikasi pertama kali dijalankan. Jika sudah memiliki database dari versi sebelumnya, letakkan file `kosakata.db` tersebut di root project yang sama.

## Teknologi

- **Backend:** Node.js, Express.js 4
- **Database:** SQLite dengan `better-sqlite3`
- **Frontend:** HTML5, CSS3, Vanilla JavaScript
- **Architecture:** layered architecture (Routes → Controllers → Services → Repositories → Database)

## Struktur folder

```text
Tutur-Kata/
├── src/
│   ├── app.js
│   ├── config/database.js
│   ├── controllers/kosakata.controller.js
│   ├── middlewares/error.middleware.js
│   ├── repositories/kosakata.repository.js
│   ├── routes/kosakata.routes.js
│   ├── services/kosakata.service.js
│   └── validators/kosakata.validator.js
├── public/
│   ├── index.html
│   ├── style.css
│   └── js/
│       ├── api.js
│       └── app.js
├── database/              # space untuk kebutuhan database 
├── db.js                  # kompatibilitas seed script
├── seed.js
├── server.js              # entry point
└── package.json
```

## Tanggung jawab setiap layer

| Layer | Tanggung jawab |
|---|---|
| Routes | Memetakan HTTP method dan URL ke controller |
| Controllers | Mengambil data request, memanggil service, dan mengirim response |
| Services | Menjalankan business logic, validasi alur, kuis, dan aturan hafalan |
| Repositories | Menjalankan query SQLite dan mengembalikan data |
| Validators | Membersihkan serta memvalidasi input kosakata |
| Middlewares | Menangani endpoint yang tidak ditemukan dan error secara konsisten |

## Struktur tabel `kosakata`

| Kolom | Tipe | Keterangan |
|---|---|---|
| `id` | INTEGER, PK | Primary key otomatis |
| `kata` | TEXT | Kata asing, wajib |
| `arti` | TEXT | Arti dalam bahasa Indonesia, wajib |
| `bahasa` | TEXT | Bahasa, default `Inggris` |
| `contoh_kalimat` | TEXT | Contoh penggunaan, opsional |
| `tingkat_hafal` | INTEGER (1–5) | Tingkat penguasaan, default 1 |
| `terakhir_diulang` | DATETIME | Waktu terakhir kata dijawab |
| `created_at` | DATETIME | Waktu data dibuat |

## Dokumentasi API

Base URL: `/api/kosakata`

| Method | Endpoint | Keterangan |
|---|---|---|
| GET | `/` | Mengambil daftar kata, mendukung `q`, `bahasa`, `tingkat`, `limit` |
| GET | `/:id` | Mengambil detail satu kata |
| POST | `/` | Menambahkan kata |
| PUT | `/:id` | Memperbarui kata |
| DELETE | `/:id` | Menghapus kata |
| GET | `/statistik` | Statistik tingkat hafalan dan bahasa |
| GET | `/random` | Mengambil kata acak berbobot; mendukung `bahasa`, `maks_tingkat` |
| GET | `/kuis` | Membuat set soal; mendukung `jumlah`, `bahasa`, `maks_tingkat` |
| PATCH | `/:id/jawab` | Mencatat jawaban dan memperbarui tingkat hafalan |

### Contoh request

Tambah kosakata:

```bash
curl -X POST http://localhost:3000/api/kosakata \
  -H "Content-Type: application/json" \
  -d '{"kata":"resilient","arti":"tangguh","bahasa":"Inggris","contoh_kalimat":"She is resilient."}'
```

Catat jawaban benar:

```bash
curl -X PATCH http://localhost:3000/api/kosakata/1/jawab \
  -H "Content-Type: application/json" \
  -d '{"benar":true}'
```

## Aturan spaced repetition

Kata dengan tingkat hafal lebih rendah dan waktu pengulangan yang lebih lama mendapat prioritas lebih tinggi. Skor dihitung langsung di query SQLite, sehingga tidak membutuhkan tabel tambahan.

## Pintasan keyboard flashcard

- `Spasi`: membalik kartu.
- `Panah kiri`: tandai belum hafal.
- `Panah kanan`: tandai hafal.

## Catatan pengembangan

- Query database menggunakan prepared statements.
- Input divalidasi sebelum masuk ke repository.
- Error API memiliki format respons terpusat.
- Frontend membangun teks melalui `textContent`/DOM API, bukan menyisipkan input pengguna sebagai HTML.
- Database tetap hanya menggunakan satu tabel utama, yaitu `kosakata`, sesuai ruang lingkup tugas.
