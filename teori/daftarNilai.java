package teori;
import java.util.Scanner;

public class daftarNilai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah kelas: ");
        int jumlahKelas = input.nextInt();
        System.out.print("Masukkan jumlah siswa per kelas: ");
        int jumlahSiswa = input.nextInt();

        System.out.println("\nDaftar Nilai Siswa: ");

        for (int i = 1; i <= jumlahKelas; i++) {
            System.out.println("Kelas " + i + ":");

            for (int j = 1; j <= jumlahSiswa; j++) {
                System.out.print("  Masukkan nilai siswa ke-" + j + ": ");  
                int nilai = input.nextInt();

                System.out.println("  Nilai siswa ke-" + j + " adalah " + nilai);
            }
            System.out.println();
        }
    }
}
