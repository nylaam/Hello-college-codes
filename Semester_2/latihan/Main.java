package Semester_2.latihan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AkunBank akun = new AkunBank(
                "Nayla Nur Amalia",
                "255150707111065",
                "Tempat_tabungan",
                500000
        );

        int pilihan;
        
        do {
            System.out.println("\n=== MENU BANK ===");
            System.out.println("1. Info Akun");
            System.out.println("2. Tambah Saldo");
            System.out.println("3. Tarik Saldo");
            System.out.println("4. Selesai");
            System.out.print("Pilih: ");

            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    akun.displayMessage();
                    break;
                case 2:
                    input.nextLine();
                    System.out.print("Masukkan Password: ");
                    String passTambah = input.nextLine();
                    if (akun.cekPassword(passTambah)) {
                        System.out.print("Jumlah saldo yang ditambah: ");
                        double jumlah = input.nextDouble();

                        akun.tambahSaldo(jumlah);
                    } else {
                        System.out.println("Password salah! Transaksi dibatalkan");
                    }
                    break;
                case 3:
                    input.nextLine();
                    System.out.print("Masukkan Password Anda: ");
                    String passTarik = input.nextLine();
                    if (akun.cekPassword(passTarik)) {

                        System.out.print("Jumlah yang ditarik: ");
                        double jumlah = input.nextDouble();

                        akun.tarikSaldo(jumlah);
                    } else {
                        System.out.println("Password salah! Transaksi dibatalkan");
                    }
                    break;
                case 4:
                    System.out.println("Terima kasih");
                    break;
                default:
                    System.out.println("Pilihan tidak ada di menu!");
            }
        } while (pilihan != 4);
    }
}