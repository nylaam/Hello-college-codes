const service = require('../services/kosakata.service');
const asyncHandler = (handler) => (req, res, next) => Promise.resolve(handler(req, res, next)).catch(next);
const controller = {
  list: asyncHandler((req, res) => res.json(service.list(req.query))),
  getById: asyncHandler((req, res) => res.json(service.getById(req.params.id))),
  create: asyncHandler((req, res) => res.status(201).json(service.create(req.body))),
  update: asyncHandler((req, res) => res.json(service.update(req.params.id, req.body))),
  remove: asyncHandler((req, res) => { service.remove(req.params.id); res.status(204).end(); }),
  random: asyncHandler((req, res) => res.json(service.random(req.query))),
  quiz: asyncHandler((req, res) => res.json(service.quiz(req.query))),
  statistics: asyncHandler((req, res) => res.json(service.statistics())),
  answer: asyncHandler((req, res) => res.json(service.answer(req.params.id, req.body))),
};
module.exports = controller;
