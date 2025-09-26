package teori;

import java.util.Scanner;

public class casebased {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean lanjutkan = true;

        while (lanjutkan) {
            int totalBelanja = 0;
            boolean isAyamBakarMadu = false;
            int jumlahMakanan = 0;

            System.out.printf("%34s\n", "WARUNG MAKAN NUSANTARA");
            System.out.println("===================================================");
            System.out.printf("%40s%n", "***Menu Warung Makan Nusantara***");
            System.out.println("===================================================");
            System.out.printf("%-4s | %-30s | %-10s%n", "Kode", "Menu", "Harga");
            System.out.printf("%-4d | %-30s | Rp %,8d%n", 1, "Nasi Goreng Spesial", 15000); 
            System.out.printf("%-4d | %-30s | Rp %,8d%n", 2, "Ayam Bakar Madu", 25000);
            System.out.printf("%-4d | %-30s | Rp %,8d%n", 3, "Soto Ayam Lamongan", 12000);
            System.out.printf("%-4d | %-30s | Rp %,8d%n", 4, "Es Teh Manis", 5000);
            System.out.printf("%-4d | %-30s | Rp %,8d%n", 5, "Es Jeruk", 7000);
            System.out.println("---------------------------------------------------");

            while (true) {
                System.out.print("Pilih Kode Menu: ");
                int kode = input.nextInt();
                input.nextLine();

                int jumlah = 0;

                if (kode == 1) {
                    System.out.print("Masukkan Jumlah Porsi: ");
                    jumlah = input.nextInt();
                    input.nextLine();
                    totalBelanja += 15000 * jumlah;
                    jumlahMakanan++;
                } else if (kode == 2) {
                    System.out.print("Masukkan Jumlah Porsi: ");
                    jumlah = input.nextInt();
                    input.nextLine();
                    isAyamBakarMadu = true;
                    totalBelanja += 25000 * jumlah;
                    jumlahMakanan++;
                } else if (kode == 3) {
                    System.out.print("Masukkan Jumlah Porsi: ");
                    jumlah = input.nextInt();
                    input.nextLine();
                    totalBelanja += 12000 * jumlah;
                    jumlahMakanan++;
                } else if (kode == 4) {
                    System.out.print("Masukkan Jumlah Porsi: ");
                    jumlah = input.nextInt();
                    input.nextLine();
                    totalBelanja += 5000 * jumlah;
                    jumlahMakanan++;
                } else if (kode == 5) {
                    System.out.print("Masukkan Jumlah Porsi: ");
                    jumlah = input.nextInt();
                    input.nextLine();
                    totalBelanja += 7000 * jumlah;
                    jumlahMakanan++;
                } else {
                    System.out.println("Menu belum launching");
                }

                System.out.print("Apakah ingin menambah menu lain? (y/n): ");
                String tambah = input.nextLine();
                if (tambah.equalsIgnoreCase("n")) {
                    break;
                }
            }

            // section diskon belanja
            int diskon = 0;
            if (totalBelanja > 100000) {
                diskon = (int) (totalBelanja * 0.15);
            } else if (totalBelanja > 50000) {
                diskon = (int) (totalBelanja * 0.10);
            }

            // section diskon hari jumat
            System.out.print("Hari transaksi: ");
            String hari = input.nextLine();
            int diskonJumat = 0;
            if (hari.equalsIgnoreCase("jumat") && isAyamBakarMadu) {
                diskonJumat = 5000;
            }

            // section takeaway
            System.out.print("Apakah makanan dibungkus? (y/n): ");
            String bungkus = input.nextLine();
            int biayaTakeaway = 0;
            if (bungkus.equals("y")) {
                biayaTakeaway = jumlahMakanan * 2000;
            }

            int subtotal = totalBelanja - diskon - diskonJumat + biayaTakeaway;

            System.out.println("Total bayarmu: " + subtotal);

            System.out.print("Mau lanjut ngga? (y/n): ");
            String next = input.nextLine();
            if (!next.equals("y")) {
                lanjutkan = false;
                System.out.println("Warungnya tutup yaa");
            }
        }
    }
}
