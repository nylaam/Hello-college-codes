function validateWord(body = {}) {
  const string = (value) => typeof value === 'string' ? value.trim() : '';
  const rawLevel = body.tingkat_hafal;
  const data = {
    kata: string(body.kata),
    arti: string(body.arti),
    bahasa: string(body.bahasa) || 'Inggris',
    contoh_kalimat: string(body.contoh_kalimat),
    tingkat_hafal: rawLevel === undefined || rawLevel === '' || rawLevel === null ? 1 : Number(rawLevel),
  };
  const errors = [];
  if (!data.kata) errors.push('Kata wajib diisi.');
  if (!data.arti) errors.push('Arti wajib diisi.');
  if (data.kata.length > 100) errors.push('Kata maksimal 100 karakter.');
  if (data.arti.length > 200) errors.push('Arti maksimal 200 karakter.');
  if (data.bahasa.length > 40) errors.push('Nama bahasa maksimal 40 karakter.');
  if (data.contoh_kalimat.length > 500) errors.push('Contoh kalimat maksimal 500 karakter.');
  if (!Number.isInteger(data.tingkat_hafal) || data.tingkat_hafal < 1 || data.tingkat_hafal > 5) errors.push('Tingkat hafal harus bilangan bulat 1 sampai 5.');
  return { data, errors };
}

module.exports = { validateWord };
