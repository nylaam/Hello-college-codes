package praktikum4_1;

import java.util.Scanner;

public class kodeRahasia {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan ID: ");
        int id = input.nextInt();

        System.out.print("Masukkan panjang kode: ");
        int n = input.nextInt();

        int[] arr = new int[n];
        System.out.println("Masukkan " + n + " angka kode:");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        StringBuilder pesan = new StringBuilder();
        int[] invalid = new int[n]; 
        int totalInvalid = 0;

        for (int i = 0; i < n; i++) {
            int angka = arr[i];

            if (angka >= id && angka <= id + 25) {
                char huruf = (char) ('A' + (angka - id));
                pesan.append(huruf);
            }
            else if (angka == id + 26) {
                pesan.append(' ');
            }
            else {
                invalid[totalInvalid] = angka;
                totalInvalid++;
            }
        }

        System.out.println("Output pesan: " + pesan.toString().toUpperCase());

        if (totalInvalid > 0) {
            System.out.print("Elemen tidak valid ditemukan: ");
            for (int i = 0; i < totalInvalid; i++) {
                System.out.print(invalid[i]);
                if (i < totalInvalid - 1) {
                    System.out.print(", ");
                }
            }
        } else {
            System.out.println("-");
        }
        System.out.println();
    }
}
