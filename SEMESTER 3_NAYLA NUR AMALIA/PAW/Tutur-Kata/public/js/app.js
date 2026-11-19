const $ = (sel, root = document) => root.querySelector(sel);

function h(tag, props = {}, ...kids) {
  const el = document.createElement(tag);
  for (const [k, v] of Object.entries(props)) {
    if (k === 'class') el.className = v;
    else if (k.startsWith('on')) el.addEventListener(k.slice(2), v);
    else if (v !== false && v != null) el.setAttribute(k, v === true ? '' : v);
  }
  for (const kid of kids.flat()) {
    if (kid == null || kid === false) continue;
    el.append(kid.nodeType ? kid : document.createTextNode(kid));
  }
  return el;
}

let timerToast;
function toast(pesan) {
  const el = $('#toast');
  el.textContent = pesan;
  el.classList.add('tampil');
  clearTimeout(timerToast);
  timerToast = setTimeout(() => el.classList.remove('tampil'), 2200);
}

const meter = (t) => h('span', { class: 'meter', 'data-t': t, role: 'img', 'aria-label': `Tingkat hafal ${t} dari 5` },
  h('i'), h('i'), h('i'), h('i'), h('i'));

/* Navigasi */
document.querySelectorAll('.tab button').forEach((btn) => {
  btn.addEventListener('click', () => {
    document.querySelectorAll('.tab button').forEach((b) => b.removeAttribute('aria-current'));
    btn.setAttribute('aria-current', 'page');
    $('#view-belajar').hidden = btn.dataset.view !== 'belajar';
    $('#view-daftar').hidden = btn.dataset.view !== 'daftar';
    if (btn.dataset.view === 'daftar') muatDaftar();
  });
});

/* Statistik */
const WARNA_TINGKAT = ['var(--t1)', 'var(--t2)', 'var(--t3)', 'var(--t4)', 'var(--t5)'];

let statistikPertama = true;
async function muatStatistik() {
  const s = await api('/statistik');
  const box = $('#statistik');
  box.replaceChildren();

  if (s.total === 0) {
    box.append(h('p', {}, 'Belum ada kata. Tambahkan kata pertamamu di Koleksi.'));
  } else {
    box.append(
      h('p', {},
        h('strong', {}, `${s.hafal} kata`), ' sudah hafal, ',
        h('strong', {}, `${s.dipelajari} kata`), ' masih dipelajari.'),
      h('div', { class: statistikPertama ? 'bar masuk' : 'bar', role: 'img', 'aria-label': 'Sebaran tingkat hafal' },
        [1, 2, 3, 4, 5].map((t) =>
          h('span', {
            style: `flex: ${s.per_tingkat[t]} 1 0; background: ${WARNA_TINGKAT[t - 1]}`,
            title: `Tingkat ${t}: ${s.per_tingkat[t]} kata`,
          })))
    );
  }

  statistikPertama = false;
  const namaBahasa = s.bahasa.map((b) => b.bahasa);
  for (const id of ['#sesi-bahasa', '#filter-bahasa']) {
    const sel = $(id);
    const lama = sel.value;
    const pertama = sel.options[0];
    sel.replaceChildren(pertama, ...namaBahasa.map((n) => h('option', { value: n }, n)));
    if (namaBahasa.includes(lama)) sel.value = lama;
  }
  $('#saran-bahasa').replaceChildren(...namaBahasa.map((n) => h('option', { value: n })));
}

/* Sesi belajar */
let sesi = null; // { mode, soal, i, benar }
const panggung = $('#panggung');

$('#form-sesi').addEventListener('submit', async (e) => {
  e.preventDefault();
  const q = new URLSearchParams({ jumlah: $('#jumlah').value });
  if ($('#sesi-bahasa').value) q.set('bahasa', $('#sesi-bahasa').value);

  try {
    const { soal } = await api('/kuis?' + q);
    if (!soal.length) {
      panggung.replaceChildren(h('p', { class: 'kosong' }, 'Belum ada kata untuk dipelajari. Tambahkan dulu di Koleksi.'));
      return;
    }
    sesi = { mode: $('#mode').value, soal, i: 0, benar: 0 };
    tampilkanSoal();
  } catch (err) {
    toast(err.message);
  }
});

async function catat(id, benar) {
  try {
    await api(`/${id}/jawab`, { method: 'PATCH', body: { benar } });
    muatStatistik();
  } catch (err) {
    toast(err.message);
  }
}

function lanjut() {
  sesi.i += 1;
  tampilkanSoal();
}

function tampilkanSoal() {
  if (!sesi) return;
  if (sesi.i >= sesi.soal.length) return tampilkanRingkasan();
  const s = sesi.soal[sesi.i];
  const progres = h('div', { class: 'progres' },
    h('span', {}, `Soal ${sesi.i + 1} dari ${sesi.soal.length}`),
    h('span', {}, s.bahasa),
    h('div', { class: 'progres-bar', role: 'presentation' }, h('i', { style: `width: ${(sesi.i / sesi.soal.length) * 100}%` })));
  requestAnimationFrame(() => requestAnimationFrame(() => {
    const bar = progres.querySelector('.progres-bar i');
    if (bar) bar.style.width = `${((sesi.i + 1) / sesi.soal.length) * 100}%`;
  }));
  panggung.replaceChildren(progres, sesi.mode === 'kuis' ? soalKuis(s) : soalFlashcard(s));
}

function soalFlashcard(s) {
  const kartu = h('button', { type: 'button', class: 'kartu', 'aria-label': `Balik kartu: ${s.kata}` },
    h('div', { class: 'sisi depan' },
      h('span', { class: 'label-bahasa' }, s.bahasa),
      h('div', { class: 'kata-besar' }, s.kata),
      meter(s.tingkat_hafal),
      h('span', { class: 'petunjuk' }, 'Klik kartu untuk melihat arti')),
    h('div', { class: 'sisi belakang' },
      h('div', { class: 'arti-besar' }, s.arti),
      s.contoh_kalimat && h('p', { class: 'contoh' }, s.contoh_kalimat)));

  const tombol = h('div', { class: 'jawab', hidden: true },
    h('button', { type: 'button', class: 'belum', onclick: () => jawabFlash(s, false) }, 'Belum hafal'),
    h('button', { type: 'button', class: 'hafal', onclick: () => jawabFlash(s, true) }, 'Hafal'));

  kartu.addEventListener('click', () => {
    kartu.classList.toggle('terbalik');
    tombol.hidden = !kartu.classList.contains('terbalik');
  });

  return h('div', { class: 'soal' }, kartu, tombol);
}

function jawabFlash(s, benar) {
  if (benar) sesi.benar += 1;
  catat(s.id, benar);
  lanjut();
}

function soalKuis(s) {
  const kotak = h('div', { class: 'pilihan' });
  const tombolLanjut = h('button', { type: 'button', class: 'utama', hidden: true, onclick: lanjut }, 'Lanjut');

  s.pilihan.forEach((teks, idx) => {
    kotak.append(h('button', {
      type: 'button',
      onclick: (e) => {
        const benar = idx === s.jawaban_index;
        [...kotak.children].forEach((b, j) => {
          b.disabled = true;
          if (j === s.jawaban_index) b.classList.add('benar');
        });
        if (!benar) e.currentTarget.classList.add('salah');
        if (benar) sesi.benar += 1;
        catat(s.id, benar);
        tombolLanjut.hidden = false;
        tombolLanjut.focus();
      },
    }, teks));
  });

  return h('div', { class: 'soal' },
    h('div', { class: 'kata-besar' }, s.kata),
    meter(s.tingkat_hafal),
    s.contoh_kalimat && h('p', { class: 'contoh' }, s.contoh_kalimat),
    kotak,
    tombolLanjut);
}

function tampilkanRingkasan() {
  const { benar, soal } = sesi;
  const angka = h('span', {}, '0');
  const cincin = h('div', { class: 'skor', role: 'img', 'aria-label': `${benar} dari ${soal.length} benar` }, angka);
  panggung.replaceChildren(h('div', { class: 'ringkasan' },
    cincin,
    h('h2', {}, `${benar} dari ${soal.length} benar`),
    h('p', {}, benar === soal.length
      ? 'Semua jawabanmu benar di sesi ini.'
      : 'Kata yang salah akan lebih sering muncul di sesi berikutnya.'),
    h('button', { type: 'button', class: 'utama', onclick: () => $('#form-sesi').requestSubmit() }, 'Belajar lagi')));
  const target = Math.round((benar / soal.length) * 100);
  requestAnimationFrame(() => cincin.style.setProperty('--p', target));
  const mulai = performance.now();
  (function hitung(t) {
    const k = Math.min((t - mulai) / 900, 1);
    angka.textContent = Math.round(k * benar);
    if (k < 1) requestAnimationFrame(hitung);
  })(mulai);
  if (benar === soal.length && !matchMedia('(prefers-reduced-motion: reduce)').matches) konfeti();
  sesi = null;
}

function konfeti() {
  const warna = ['#2f4bb3', '#f2b134', '#1f7a4d', '#8196d6'];
  for (let i = 0; i < 36; i++) {
    const el = h('span', { class: 'konfeti', 'aria-hidden': 'true',
      style: `left:${Math.random() * 100}vw;background:${warna[i % 4]};animation-delay:${Math.random() * .5}s;animation-duration:${1.8 + Math.random() * 1.2}s` });
    document.body.append(el);
    setTimeout(() => el.remove(), 3600);
  }
}

// Pintasan keyboard untuk flashcard, for spasi = balik, panah = jawab
document.addEventListener('keydown', (e) => {
  if (!sesi || sesi.mode !== 'flashcard' || $('#dialog').open || $('#view-belajar').hidden) return;
  if (['INPUT', 'SELECT', 'TEXTAREA'].includes(document.activeElement.tagName)) return;
  const kartu = $('.kartu');
  if (!kartu) return;
  const terbalik = kartu.classList.contains('terbalik');
  const s = sesi.soal[sesi.i];
  if (e.key === ' ') { e.preventDefault(); kartu.click(); }
  else if (terbalik && e.key === 'ArrowLeft') jawabFlash(s, false);
  else if (terbalik && e.key === 'ArrowRight') jawabFlash(s, true);
});

async function muatDaftar() {
  const q = new URLSearchParams();
  if ($('#cari').value.trim()) q.set('q', $('#cari').value.trim());
  if ($('#filter-bahasa').value) q.set('bahasa', $('#filter-bahasa').value);
  if ($('#filter-tingkat').value) q.set('tingkat', $('#filter-tingkat').value);

  try {
    const rows = await api('?' + q);
    const ul = $('#daftar');
    if (!rows.length) {
      ul.replaceChildren(h('li', { class: 'kosong' }, 'Tidak ada kata yang cocok. Ubah search atau filter, atau tambah kata baru.'));
      return;
    }
    ul.replaceChildren(...rows.map((k, i) => barisKata(k, i)));
  } catch (err) {
    toast(err.message);
  }
}

function barisKata(k, i = 0) {
  return h('li', { style: `--i: ${Math.min(i, 10)}` },
    h('div', { class: 'kata' }, k.kata),
    h('div', { class: 'arti' }, k.arti),
    h('div', { class: 'meta' }, k.bahasa, meter(k.tingkat_hafal)),
    h('div', { class: 'tombol' },
      h('button', { type: 'button', onclick: () => bukaDialog(k) }, 'Ubah'),
      h('button', { type: 'button', class: 'bahaya', onclick: () => hapusKata(k) }, 'Hapus')));
}

async function hapusKata(k) {
  if (!confirm(`Hapus kata "${k.kata}"?`)) return;
  try {
    await api(`/${k.id}`, { method: 'DELETE' });
    toast('Kata dihapus');
    muatDaftar();
    muatStatistik();
  } catch (err) {
    toast(err.message);
  }
}

let timerCari;
$('#cari').addEventListener('input', () => {
  clearTimeout(timerCari);
  timerCari = setTimeout(muatDaftar, 250);
});
$('#filter-bahasa').addEventListener('change', muatDaftar);
$('#filter-tingkat').addEventListener('change', muatDaftar);

const dialog = $('#dialog');
const form = $('#form-kata');
let idSunting = null;

function bukaDialog(k = null) {
  idSunting = k ? k.id : null;
  $('#judul-dialog').textContent = k ? 'Ubah kata' : 'Tambah kata';
  form.reset();
  $('#galat').hidden = true;
  form.kata.value = k ? k.kata : '';
  form.arti.value = k ? k.arti : '';
  form.bahasa.value = k ? k.bahasa : ($('#filter-bahasa').value || 'Inggris');
  form.tingkat_hafal.value = k ? k.tingkat_hafal : 1;
  form.contoh_kalimat.value = k ? k.contoh_kalimat : '';
  dialog.showModal();
  form.kata.focus();
}

$('#tambah').addEventListener('click', () => bukaDialog());
$('#batal').addEventListener('click', () => dialog.close());
$('#batal-sekunder').addEventListener('click', () => dialog.close());

form.addEventListener('submit', async (e) => {
  e.preventDefault();
  const body = Object.fromEntries(new FormData(form));
  try {
    if (idSunting) await api(`/${idSunting}`, { method: 'PUT', body });
    else await api('', { method: 'POST', body });
    dialog.close();
    toast(idSunting ? 'Perubahan disimpan' : 'Kata ditambahkan');
    muatDaftar();
    muatStatistik();
  } catch (err) {
    const g = $('#galat');
    g.textContent = err.message;
    g.hidden = false;
  }
});

muatStatistik().catch((err) => toast(err.message));
