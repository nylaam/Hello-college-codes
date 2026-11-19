const express = require('express');
const path = require('node:path');
const kosakataRoutes = require('./routes/kosakata.routes');
const { notFound, errorHandler } = require('./middlewares/error.middleware');

const app = express();
app.disable('x-powered-by');
app.use(express.json({ limit: '100kb' }));
app.use(express.static(path.join(__dirname, '../public')));
app.use('/api/kosakata', kosakataRoutes);
app.use('/api', notFound);
app.use(errorHandler);

module.exports = app;
