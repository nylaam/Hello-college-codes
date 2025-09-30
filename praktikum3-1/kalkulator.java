import java.util.Scanner;

public class kalkulator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double hasil = 0.0, nilaiAwal = 0.0;
        boolean kondisi = true;
        int operator;

        while (kondisi) {
            operator = input.nextInt();
            if (operator == 0) {
                System.out.println("Hasil akhir: " + hasil);
                System.out.println("Kalkulator dimatikan");
                kondisi = false;
            } else if (operator >= 1 && operator <= 4) {
                nilaiAwal = input.nextInt();
                switch (operator) {
                    case 1:
                        hasil += nilaiAwal;
                        break;
                    case 2:
                        hasil -= nilaiAwal;
                        break;
                    case 3:
                        hasil *= nilaiAwal;
                        break;
                    case 4:
                        hasil /= nilaiAwal;
                        break;
                }
            } else {
                System.out.println("Opsi tidak ditemukan");
            }
        }
    }
}