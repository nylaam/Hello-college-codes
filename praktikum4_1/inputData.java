package praktikum4_1;

import java.util.Scanner;

public class inputData {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] data = new int[50];
        int jumlahData = 0;
        int pilihan;

        do {
            System.out.println("\n==== Daftar Pilihan Menu ====");
            System.out.println("1. Input Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Average");
            System.out.println("4. Sum");
            System.out.println("5. Max");
            System.out.println("6. Min");   
            System.out.println("7. Keluar");
            System.out.println("0. Terimakasih");
            System.out.print("Masukkan nilai: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Berapa data yang diinputkan? : ");
                    int angka = input.nextInt();

                    if (jumlahData + angka > data.length) {
                    System.out.println("Kapasitas array nya tidak cukup frend");
                    } else {
                    for (int i = 0; i < angka; i++) {
                    System.out.print("Masukkan data ke-" + (i + 1) + ": ");
                    data[jumlahData] = input.nextInt();
                    jumlahData++;
                    }
                    System.out.println("\nData yang diinputkan: ");
                    for (int i = 0; i < jumlahData; i++) {
                    System.out.println("Data ke-" + (i + 1) + ": " + data[i]);
                    }
                    }

                    for (int i = 0; i < angka; i++) {
                    System.out.print("Masukkan data ke-" + (i + 1) + ": ");
                    data[jumlahData] = input.nextInt();
                    jumlahData++;
                    }

                    //* Percobaan Analisa */
                    // if (jumlahData + angka > data.length) {
                    //     System.out.println("Kapasitas array tidak cukup.");
                    // } else {
                    //     for (int i = 0; i < angka; i++) {
                    //         System.out.print("Masukkan data ke-" + (i + 1) + ": ");
                    //         data[jumlahData] = input.nextInt();
                    //     }

                    //     System.out.println("\nData yang diinputkan: ");
                    //     for (int i = 0; i < angka; i++) {
                    //         System.out.println("Data ke-" + (i + 1) + ": " + data[i]);
                    //     }
                    // }

                    break;
                case 2:
                    if (jumlahData == 0) {
                        System.out.println("Data belum terisi");
                    } else {
                        System.out.println("\n==== Data yang tersimpan ====");
                        for (int i = 0; i < jumlahData; i++) {
                            System.out.println("Data ke-" + (i + 1) + ": " + data[i]);
                        }
                    }
                    System.out.println("Total data: " + jumlahData);
                    break;
                case 3:
                    if (jumlahData == 0) {
                        System.out.println("Data belum terisi");
                    } else {
                        int totalAvg = 0;
                        for (int i = 0; i < jumlahData; i++) {
                            totalAvg += data[i];
                        }
                        double avg = (double) totalAvg / jumlahData;
                        System.out.println("Rata-rata data: " + avg);
                    }
                    break;
                case 4:
                    if (jumlahData == 0) {
                        System.out.println("Data belum terisi");
                    } else {
                        int totalSum = 0;
                        for (int i = 0; i < jumlahData; i++) {
                            totalSum += data[i];
                        }
                        System.out.println("Jumlah Sum: " + totalSum);
                    }
                    break;
                case 5:
                    if (jumlahData == 0) {
                    System.out.println("Data belum terisi");
                    } else {
                    int totalMax = data[0];
                    for (int i = 0; i < jumlahData; i++) {
                    if (data[i] > totalMax) {
                    totalMax = data[i];
                    }
                    }
                    System.out.println("Total Maksimal: " + totalMax);
                    }

                    //* Percobaan Analisa */
                    // int max = data[0];
                    // for (int i = 1; i < jumlahData; i++) {
                    //     if (data[i] > max)
                    //         max = data[i];
                    // }
                    // System.out.println("Nilai Maksimum: " + max);

                    break;
                case 6:
                    if (jumlahData == 0) {
                        System.out.println("Data belum terisi");
                    } else {
                        int totalMin = data[0];
                        for (int i = 0; i < jumlahData; i++) {
                            if (data[i] < totalMin) {
                                totalMin = data[i];
                            }
                        }
                        System.out.println("Total Minimal: " + totalMin);
                    }
                    break;
                case 7:
                    System.out.println("Program dihentikan");
                    break;
                case 0:
                    System.out.println("Terima kasih sudah menggunakan program pengolahan data");
                    break;
                default:
                    System.out.println("Pilihan tidak valid !!");
                    break;
            }
        } while (pilihan != 7);
    }
}
