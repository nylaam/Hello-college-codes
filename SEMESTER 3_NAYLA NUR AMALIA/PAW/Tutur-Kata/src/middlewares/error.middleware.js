function notFound(req, res) {
  res.status(404).json({ error: 'Endpoint tidak ditemukan.' });
}
function errorHandler(error, req, res, next) {
  if (res.headersSent) return next(error);
  if (error.type === 'entity.parse.failed') return res.status(400).json({ error: 'JSON tidak valid.' });
  const status = Number.isInteger(error.status) ? error.status : 500;
  if (status >= 500) console.error(error);
  const payload = { error: status >= 500 ? 'Terjadi kesalahan pada server.' : error.message };
  if (error.details) payload.errors = error.details;
  return res.status(status).json(payload);
}
module.exports = { notFound, errorHandler };
