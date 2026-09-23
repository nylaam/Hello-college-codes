CREATE DATABASE IF NOT EXISTS db_tanaman;
USE db_tanaman;

CREATE TABLE tanaman (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nama_tanaman VARCHAR(100) NOT NULL,
    jenis VARCHAR(50) NOT NULL,
    harga INT NOT NULL,
    stok INT NOT NULL
);

SELECT * FROM tanaman;