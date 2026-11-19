const express = require('express');
const controller = require('../controllers/kosakata.controller');
const router = express.Router();

router.get('/statistik', controller.statistics);
router.get('/random', controller.random);
router.get('/kuis', controller.quiz);
router.get('/', controller.list);
router.get('/:id(\\d+)', controller.getById);
router.post('/', controller.create);
router.put('/:id(\\d+)', controller.update);
router.delete('/:id(\\d+)', controller.remove);
router.patch('/:id(\\d+)/jawab', controller.answer);

module.exports = router;
