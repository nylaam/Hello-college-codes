package teori;

import java.util.Scanner;

public class casebased {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean lanjutkan = true;

        while (lanjutkan) {
            int totalBelanja = 0;
            boolean isAyamBakarMadu = false;

            // Variabel untuk struk dan biaya bungkus
            int jumlahJenisMakanan = 0;
            StringBuilder detailPesanan = new StringBuilder();

            System.out.printf("%34s\n", "WARUNG MAKAN NUSANTARA");
            System.out.println("===================================================");
            System.out.printf("%40s%n", "Menu Warung Makan Nusantara");
            System.out.println("===================================================");
            System.out.printf("%-4s | %-30s | %-10s%n", "Kode", "Menu", "Harga");
            System.out.printf("%-4d | %-30s | Rp %,8d%n", 1, "Nasi Goreng Spesial", 15000);
            System.out.printf("%-4d | %-30s | Rp %,8d%n", 2, "Ayam Bakar Madu", 25000);
            System.out.printf("%-4d | %-30s | Rp %,8d%n", 3, "Soto Ayam Lamongan", 12000);
            System.out.printf("%-4d | %-30s | Rp %,8d%n", 4, "Es Teh Manis", 5000);
            System.out.printf("%-4d | %-30s | Rp %,8d%n", 5, "Es Jeruk", 7000);
            System.out.println("---------------------------------------------------");
            
            // Loop untuk memesan menu
            while (true) {
                System.out.print("Pilih Kode Menu: ");
                int kode = input.nextInt();
                input.nextLine(); 

                int jumlah = 0;

                if (kode >= 1 && kode <= 5) {
                    System.out.print("Masukkan Jumlah Porsi: ");
                    jumlah = input.nextInt();
                    input.nextLine();
                }

                if (kode == 1) {
                    totalBelanja += 15000 * jumlah;
                    jumlahJenisMakanan++;
                    detailPesanan.append(
                            String.format("%-25s x%d | Rp%,10d\n", "Nasi Goreng Spesial", jumlah, 15000 * jumlah));
                } else if (kode == 2) {
                    isAyamBakarMadu = true;
                    totalBelanja += 25000 * jumlah;
                    jumlahJenisMakanan++;
                    detailPesanan
                            .append(String.format("%-25s x%d | Rp%,10d\n", "Ayam Bakar Madu", jumlah, 25000 * jumlah));
                } else if (kode == 3) {
                    totalBelanja += 12000 * jumlah;
                    jumlahJenisMakanan++;
                    detailPesanan.append(
                            String.format("%-25s x%d | Rp%,10d\n", "Soto Ayam Lamongan", jumlah, 12000 * jumlah));
                } else if (kode == 4) {
                    totalBelanja += 5000 * jumlah;
                    detailPesanan.append(String.format("%-25s x%d | Rp%,10d\n", "Es Teh Manis", jumlah, 5000 * jumlah));
                } else if (kode == 5) {
                    totalBelanja += 7000 * jumlah;
                    detailPesanan.append(String.format("%-25s x%d | Rp%,10d\n", "Es Jeruk", jumlah, 7000 * jumlah));
                } else {
                    System.out.println("Kode menu tidak valid.");
                }

                System.out.print("Apakah ingin menambah menu lain? (y/n): ");
                String tambah = input.nextLine();
                if (tambah.equalsIgnoreCase("n")) {
                    break;
                }
            }

            // Section diskon belanja
            int diskonBelanja = 0;
            if (totalBelanja > 100000) {
                diskonBelanja = (int) (totalBelanja * 0.15);
            } else if (totalBelanja > 50000) {
                diskonBelanja = (int) (totalBelanja * 0.10);
            }

            // Section diskon hari jumat
            System.out.print("Hari transaksi (contoh: Jumat): ");
            String hari = input.nextLine();
            int diskonJumat = 0;
            if (hari.equalsIgnoreCase("jumat") && isAyamBakarMadu) {
                diskonJumat = 5000;

            }

            // Section takeaway
            System.out.print("Apakah makanan dibungkus? (y/n): ");
            String bungkus = input.nextLine();
            int biayaTakeaway = 0;
            if (bungkus.equalsIgnoreCase("y")) {
                biayaTakeaway = jumlahJenisMakanan * 2000;
            }

            // Section Perhitungan Pajak & Total Akhir
            int subtotalSetelahDiskon = totalBelanja - diskonBelanja - diskonJumat;
            int subtotalSebelumPajak = subtotalSetelahDiskon + biayaTakeaway;
            int pajak = (int) (subtotalSebelumPajak * 0.10);
            int totalAkhir = subtotalSebelumPajak + pajak;

            // Section Cetak Struk
            System.out.println("\n==============================================");
            System.out.println("               STRUK PEMBAYARAN               ");
            System.out.println("==============================================");
            System.out.println("Rincian Pesanan:");
            System.out.print(detailPesanan.toString());
            System.out.println("----------------------------------------------");
            System.out.printf("%-25s: Rp%,10d\n", "Total Belanja Awal", totalBelanja);

            System.out.println("----------------------------------------------");

            if (diskonBelanja > 0) {
                System.out.printf("%-25s: -Rp%,9d\n", "Diskon Belanja", diskonBelanja);
            }
            if (diskonJumat > 0) {
                System.out.printf("%-25s: -Rp%,9d\n", "Diskon Spesial Jumat", diskonJumat);
            }
            if (biayaTakeaway > 0) {
                System.out.printf("%-25s: Rp%,10d\n", "Biaya Bungkus", biayaTakeaway);
            }

            System.out.printf("%-25s: Rp%,10d\n", "Subtotal", subtotalSebelumPajak);
            System.out.printf("%-25s: Rp%,10d\n", "Pajak (10%)", pajak);
            System.out.println("==============================================");
            System.out.printf("%-25s: Rp%,10d\n", "TOTAL BAYAR", totalAkhir);
            System.out.println("==============================================\n");

            // Opsi untuk transaksi baru
            System.out.print("Mulai transaksi baru? (y/n): ");
            String next = input.nextLine();
            if (!next.equalsIgnoreCase("y")) {
                lanjutkan = false;
                System.out.println("Terima kasih!");
            }
        }
        input.close();
    }
}
