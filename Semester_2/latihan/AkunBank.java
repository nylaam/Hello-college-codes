package Semester_2.latihan;

class AkunBank {
    private String nama;
    private String noRekening;
    private String password;
    private double saldo;

    public AkunBank(String nama, String noRekening, String password, double saldo) {
        this.nama = nama;
        this.noRekening = noRekening;
        this.password = password;
        this.saldo = saldo;
    }

    public boolean cekPassword(String inputPassword) {
        return password.equals(inputPassword);
    }

    public void tambahSaldo(double jumlah) {
        saldo += jumlah;
        System.out.println("Saldo berhasil ditambahkan");
        System.out.println("Saldo sekarang: " + saldo);
    }

    public void tarikSaldo(double jumlah) {
        if (jumlah > saldo) {
            System.out.println("Saldo tidak mencukupi!");
        } else {
            saldo -= jumlah;
            System.out.println("Penarikan uang berhasil");
            System.out.println("Saldo sekarang: " + saldo);
        }
    }

    public void displayMessage() {
        System.out.println("Nama Nasabah: " + nama);
        System.out.println("No Rekening : " + noRekening);
        System.out.println("Saldo : " + saldo);
    }
}