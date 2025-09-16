import java.util.Scanner;

public class salaryEmployee {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah jam kerja anda : ");
        int jamKerja = input.nextInt();

        int upahPerJam = 5000;
        int upahLembur = 6000;
        int dendaPerJam = 1000;

        int upah = 0;
        int lembur = 0;
        int denda = 0;

        if (jamKerja > 60) {
            upah = 60 * upahPerJam;
            lembur = (jamKerja - 60) * upahLembur;
        } else if (jamKerja < 50) {
            upah = jamKerja * upahPerJam;
            denda = (50 - jamKerja) * dendaPerJam;
        } else {
            upah = jamKerja * upahPerJam;
        }

        int total = upah + lembur - denda;

        System.out.printf("%-14s: %d\n", "Jam Kerja", jamKerja);
        System.out.printf("%-8s= Rp. %d\n", "Upah", upah);
        System.out.printf("%-8s= Rp. %d\n", "Lembur", lembur);
        System.out.printf("%-8s= Rp. %d\n", "Denda", denda);
        System.out.println("--------------------");
        System.out.printf("%-8s= Rp. %d\n", "Total", total);
    }
}
