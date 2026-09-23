<?php
$koneksi = mysqli_connect("localhost", "root", "passworddataabase", "db_tanaman");

if (!$koneksi) {
    die("Koneksi gagal: " . mysqli_connect_error());
}
?>