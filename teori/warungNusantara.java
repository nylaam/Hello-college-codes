package teori;

import java.util.Scanner;

public class warungNusantara {
    // function
    public static int hitungDiskonBelanja(int totalBelanja) {
        if (totalBelanja > 100000) {
            return (int) (totalBelanja * 0.15);
        } else if (totalBelanja > 50000) {
            return (int) (totalBelanja * 0.10);
        }
        return 0;
    }

    // function
    public static int hitungDiskonJumat(String hari, boolean isAyamBakarMadu) {
        if (hari.equalsIgnoreCase("jumat") && isAyamBakarMadu) {
            return 5000;
        }
        return 0;
    }

    // function
    public static int hitungBiayaBungkus(boolean bungkus, int jumlahJenisMakanan) {
        if (bungkus) {
            return jumlahJenisMakanan * 2000;
        }
        return 0;
    }

    // function
    public static int hitungPajak(int subtotal) {
        return (int) (subtotal * 0.10);
    }

    // procedure
    public static void tampilkanMenu() {
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
    }

    // procedure
    public static void cetakStruk(StringBuilder detailPesanan, int totalBelanja, int diskonBelanja, int diskonJumat,
                                  int biayaTakeaway, int pajak, int totalAkhir, int subtotalSebelumPajak) {
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
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean lanjutkan = true;

        while (lanjutkan) {
            int totalBelanja = 0;
            boolean isAyamBakarMadu = false;
            int jumlahJenisMakanan = 0;
            StringBuilder detailPesanan = new StringBuilder();

            tampilkanMenu();

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

            // Input hari
            System.out.print("Hari transaksi (contoh: Jumat): ");
            String hari = input.nextLine();

            // Input bungkus
            System.out.print("Apakah makanan dibungkus? (y/n): ");
            boolean bungkus = input.nextLine().equalsIgnoreCase("y");

            int diskonBelanja = hitungDiskonBelanja(totalBelanja);
            int diskonJumat = hitungDiskonJumat(hari, isAyamBakarMadu);
            int biayaTakeaway = hitungBiayaBungkus(bungkus, jumlahJenisMakanan);

            int subtotalSetelahDiskon = totalBelanja - diskonBelanja - diskonJumat;
            int subtotalSebelumPajak = subtotalSetelahDiskon + biayaTakeaway;
            int pajak = hitungPajak(subtotalSebelumPajak);
            int totalAkhir = subtotalSebelumPajak + pajak;

            cetakStruk(detailPesanan, totalBelanja, diskonBelanja, diskonJumat,
                    biayaTakeaway, pajak, totalAkhir, subtotalSebelumPajak);

            // next transaction?
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

