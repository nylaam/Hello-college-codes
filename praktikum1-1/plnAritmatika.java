import java.util.Scanner;

public class plnAritmatika {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String namaPelanggan, kelurahan;
        int kwhawal, kwhakhir, biayaBeban, pajak, akhirPPJ, tarifListrik, pemakaian, totalBayar;

        System.out.print("Masukkan Nama : ");
        namaPelanggan = input.nextLine();

        System.out.print("Kelurahan : ");
        kelurahan = input.nextLine();

        System.out.print("Masukkan posisi awal Kwh meter : ");
        kwhawal = input.nextInt();

        System.out.print("Masukkan posisi akhir Kwh meter : ");
        kwhakhir = input.nextInt();

        System.out.print("Masukkan biaya beban saat ini : ");
        biayaBeban = input.nextInt();

        System.out.print("Masukkan PPJ (dalam persen) : ");
        pajak = input.nextInt();

        // perhitungan aritmatika
        pemakaian = (kwhawal - kwhakhir);
        tarifListrik = (pemakaian * biayaBeban) / 100;
        akhirPPJ = (tarifListrik * pajak) / 100;
        totalBayar = tarifListrik + akhirPPJ;

        // Output
        System.out.println("\n================== PLN " + kelurahan + " ==================");
        System.out.printf("%-20s : %s%n", "Nama", namaPelanggan);
        System.out.printf("%-20s : %s%n", "Kelurahan", kelurahan);
        System.out.printf("%-20s : %d Kwh Meter%n", "Pemakaian bulan ini", pemakaian);
        System.out.printf("%-20s : Rp%d,-%n", "Tarif Listrik", tarifListrik);
        System.out.printf("PPJ %-16s : Rp%d,-%n", pajak + "%", akhirPPJ);
        System.out.printf("%-20s : Rp%d,-%n", "Total Bayar", totalBayar);
        System.out.println("============================================================");
    }
}