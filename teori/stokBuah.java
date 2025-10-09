package teori;

import java.util.Scanner;

public class stokBuah {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] buah = { "Semangka", "Melon", "Sirsak", "Mangga", "Jambu" };
        int[] stock = { 5, 8, 3, 7, 10 };
        double[] harga = { 9000, 7000, 5000, 8000, 6500 };
        int menu;

        do {
            System.out.println("\nSelamat datang di manajemen stok buah");
            System.out.println("1. Lihat daftar buah");
            System.out.println("2. Update stok setelah pembelian");
            System.out.println("3. Lihat stok terkecil buah");
            System.out.println("4. Tutup dulu toko nya");
            System.out.print("Tentukan pilihanmu: ");
            menu = input.nextInt();

            if (menu == 1) {
                System.out.println("\n=========== Daftar Buah ===========");
                System.out.printf("%-4s %-10s %-10s %-10s%n", "No", "Buah", "Stok", "Harga");
                System.out.println("-----------------------------------");
                for (int i = 0; i < stock.length; i++) {
                    System.out.printf("%-4d %-10s %-10d %-10.2f%n", (i+1), buah[i], stock[i], harga[i]);
                }
            }

            else if(menu ==2){
                System.out.println("\nPilih buah yang dibeli: ");
                for (int i = 0; i < buah.length; i++){
                    System.out.printf("%-4s %-10s%n", (i+1), buah[i]);
                }
                System.out.print("Masukkan nomor buah: ");
                int pilihan = input.nextInt();

                if (pilihan >= 1 && pilihan <= buah.length){
                    System.out.print("Masukkan jumlah beli: ");
                    int jumlahBeli = input.nextInt();

                    if(jumlahBeli <= stock[pilihan-1]){
                        stock[pilihan-1] -= jumlahBeli;
                        System.out.println("Stok buah " + buah[pilihan-1] + " berhasil di update menjadi " + stock[pilihan-1]);
                    }else{
                        System.out.println("Stok tidak mencukupi jumlah pembelian");
                    }
                } else {
                    System.out.println("Pilihanmu tidak tersedia");
                }
            }

            else if(menu == 3){
                int terendah = stock[0];
                int minIndex = 0;
                for(int i = 0; i < stock.length; i++){
                    if (stock[i] < terendah) {
                        terendah = stock[i];
                        minIndex = i;
                    }
                }  
                System.out.println("Buah dengan stok terkecil: " + buah[minIndex] + " dengan stok " + stock[minIndex]);
            }
        } while (menu != 4);

        System.out.println("Program dihentikan");
    }
}
