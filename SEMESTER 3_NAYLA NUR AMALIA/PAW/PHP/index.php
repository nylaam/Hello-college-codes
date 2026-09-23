<?php
include 'koneksi.php';

if (isset($_POST['submit'])) {
    $nama_tanaman = $_POST['nama_tanaman'];
    $jenis        = $_POST['jenis'];
    $harga        = $_POST['harga'];
    $stok         = $_POST['stok'];

    mysqli_query($koneksi, "INSERT INTO tanaman (nama_tanaman, jenis, harga, stok) VALUES ('$nama_tanaman', '$jenis', '$harga', '$stok')");
    
    header("Location: index.php");
    exit();
}

$result = mysqli_query($koneksi, "SELECT * FROM tanaman");
?>

<!DOCTYPE html>
<html>
<head>
    <title>Katalog Tanaman</title>
</head>
<body>

    <h2>Koleksi Tanaman Hias</h2>

    <h3>Tambah Tanaman Baru</h3>
    <form method="POST" action="">
        Nama Tanaman: <br>
        <input type="text" name="nama_tanaman" required><br><br>

        Jenis: <br>
        <input type="text" name="jenis" required><br><br>

        Harga: <br>
        <input type="number" name="harga" required><br><br>

        Stok: <br>
        <input type="number" name="stok" required><br><br>

        <button type="submit" name="submit">Simpan</button>
    </form>

    <hr>

    <h3>Daftar Tanaman</h3>
    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>No</th>
            <th>Nama Tanaman</th>
            <th>Jenis</th>
            <th>Harga</th>
            <th>Stok</th>
            <th>Aksi</th>
        </tr>
        <?php 
        $no = 1;
        while ($row = mysqli_fetch_assoc($result)) : 
        ?>
        <tr>
            <td><?= $no++; ?></td>
            <td><?= $row['nama_tanaman']; ?></td>
            <td><?= $row['jenis']; ?></td>
            <td>Rp <?= $row['harga']; ?></td>
            <td><?= $row['stok']; ?></td>
            <td>
                <a href="edit.php?id=<?= $row['id']; ?>">Edit</a> | 
                <a href="hapus.php?id=<?= $row['id']; ?>" onclick="return confirm('Hapus data ini?')">Hapus</a>
            </td>
        </tr>
        <?php endwhile; ?>
    </table>

</body>
</html>