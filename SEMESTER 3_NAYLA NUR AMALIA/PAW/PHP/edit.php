<?php
include 'koneksi.php';

$id = $_GET['id'];
$data = mysqli_query($koneksi, "SELECT * FROM tanaman WHERE id='$id'");
$row = mysqli_fetch_assoc($data);

if (isset($_POST['update'])) {
    $nama_tanaman = $_POST['nama_tanaman'];
    $jenis        = $_POST['jenis'];
    $harga        = $_POST['harga'];
    $stok         = $_POST['stok'];

    mysqli_query($koneksi, "UPDATE tanaman SET nama_tanaman='$nama_tanaman', jenis='$jenis', harga='$harga', stok='$stok' WHERE id='$id'");
    
    header("Location: index.php");
    exit();
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Tanaman</title>
</head>
<body>

    <h2>Edit Tanaman</h2>

    <form method="POST" action="">
        Nama Tanaman: <br>
        <input type="text" name="nama_tanaman" value="<?= $row['nama_tanaman']; ?>" required><br><br>

        Jenis: <br>
        <input type="text" name="jenis" value="<?= $row['jenis']; ?>" required><br><br>

        Harga: <br>
        <input type="number" name="harga" value="<?= $row['harga']; ?>" required><br><br>

        Stok: <br>
        <input type="number" name="stok" value="<?= $row['stok']; ?>" required><br><br>

        <button type="submit" name="update">Update</button>
        <a href="index.php">Batal</a>
    </form>

</body>
</html>