package praktikum4_1;

import java.util.Scanner;

public class tiketKereta {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] keretaApi = {
                { "Ekonomi", "50000", "2%", "Tidak Ada", "Tidak Ada" },
                { "Bisnis", "100000", "5%", "Ada", "Tidak Ada" },
                { "Eksekutif", "200000", "7%", "Ada", "Tidak Ada" },
                { "Pariwisata", "300000", "10%", "Ada", "Ada" }
        };

        String jenisPesanan = "";
        int jumlahTiket = 0;
        double hargaTiket = 0;
        double diskonPersen = 0;
        double totalHarga = 0;
        double totalDiskon = 0;
        double totalBayar = 0;

        int pilihan;
        do {
            System.out.println("\n====== STASIUN KERETA API ======");
            System.out.println("1. Melihat Daftar Kereta Api");
            System.out.println("2. Melihat Daftar Kereta Api yang ada AC");
            System.out.println("3. Melihat Daftar Kereta Api yang ada Colokan");
            System.out.println("4. Memesan Tiket Kereta Api");
            System.out.println("5. Melihat Pesanan Tiket");
            System.out.println("0. Keluar");
            System.out.print("Tentukan pilihanmu: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("\n=== Daftar Kereta Api ===");
                    System.out.printf("%-12s %-10s %-8s %-10s %-10s\n", "Jenis", "Harga", "Diskon", "AC", "Colokan");
                    for (String[] krt : keretaApi) {
                        System.out.printf("%-12s %-10s %-8s %-10s %-10s\n", krt[0], krt[1], krt[2], krt[3], krt[4]);
                    }
                    break;

                case 2:
                    System.out.println("\n=== Kereta dengan AC ===");
                    System.out.printf("%-12s %-10s %-8s %-10s %-10s\n", "Jenis", "Harga", "Diskon", "AC", "Colokan");
                    for (String[] k : keretaApi) {
                        if (k[3].equalsIgnoreCase("Ada")) {
                            System.out.printf("%-12s %-10s %-8s %-10s %-10s\n", k[0], k[1], k[2], k[3], k[4]);
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n=== Kereta dengan Colokan ===");
                    System.out.printf("%-12s %-10s %-8s %-10s %-10s\n", "Jenis", "Harga", "Diskon", "AC", "Colokan");
                    for (String[] k : keretaApi) {
                        if (k[4].equalsIgnoreCase("Ada")) {
                            System.out.printf("%-12s %-10s %-8s %-10s %-10s\n", k[0], k[1], k[2], k[3], k[4]);
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n=== Pemesanan Tiket ===");
                    for (int i = 0; i < keretaApi.length; i++) {
                        System.out.println((i + 1) + ". " + keretaApi[i][0]);
                    }
                    System.out.print("Masukkan pilihan kereta: ");
                    int pilihKereta = input.nextInt();

                    if (pilihKereta >= 1 && pilihKereta <= keretaApi.length) {
                    jenisPesanan = keretaApi[pilihKereta - 1][0];
                    hargaTiket = Double.parseDouble(keretaApi[pilihKereta - 1][1]);
                    // diskonPersen = Double.parseDouble(keretaApi[pilihKereta - 1][2].replace("%",
                    // ""));
                    diskonPersen = Double.parseDouble(keretaApi[pilihKereta - 1][2]);


                    System.out.print("Masukkan jumlah tiket yang ingin dipesan: ");
                    jumlahTiket = input.nextInt();

                    totalHarga = hargaTiket * jumlahTiket;
                    totalDiskon = totalHarga * (diskonPersen / 100);
                    totalBayar = totalHarga - totalDiskon;

                    System.out.println("\n=== Rincian Pemesanan ===");
                    System.out.println("Jenis Kereta : " + jenisPesanan);
                    System.out.println("Harga per Tiket: Rp" + hargaTiket);
                    System.out.println("Jumlah Tiket : " + jumlahTiket);
                    System.out.println("Total Harga : Rp" + totalHarga);
                    System.out.println("Diskon (" + diskonPersen + "%) : Rp" + totalDiskon);
                    System.out.println("Total Bayar : Rp" + totalBayar);
                    } else {
                    System.out.println("Pilihan tidak valid!");
                    }

                    //* Analisa Percobaan */
                    // System.out.print("Masukkan pilihan kereta: ");
                    // int pilihKereta = input.nextInt();

                    // jenisPesanan = keretaApi[pilihKereta - 1][0];
                    // hargaTiket = Double.parseDouble(keretaApi[pilihKereta - 1][1]);
                    // diskonPersen = Double.parseDouble(keretaApi[pilihKereta - 1][2].replace("%", ""));

                    break;

                case 5:
                    System.out.println("\n=== Pesanan Tiket Anda ===");
                    if (!jenisPesanan.equals("")) {
                        System.out.println("Jenis Kereta   : " + jenisPesanan);
                        System.out.println("Jumlah Tiket   : " + jumlahTiket);
                        System.out.println("Harga per Tiket: Rp" + hargaTiket);
                        System.out.println("Total Harga    : Rp" + totalHarga);
                        System.out.println("Diskon (" + diskonPersen + "%) : Rp" + totalDiskon);
                        System.out.println("Total Bayar    : Rp" + totalBayar);
                    } else {
                        System.out.println("Belum ada pesanan.");
                    }
                    break;

                case 0:
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid, coba lagi!");
            }
        } while (pilihan != 0);
    }
}
