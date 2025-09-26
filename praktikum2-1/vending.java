import java.util.Scanner;

public class vending {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int kopi = 5000;
        int teh = 4000;
        int airMineral = 3500;

        System.out.println("===== Vending Machine =====");
        System.out.printf("%-14s: %s%n", "1. Kopi", kopi);
        System.out.printf("%-14s: %s%n", "2. Teh", teh);
        System.out.printf("%-14s: %s%n", "3. Air Mineral", airMineral);

        System.out.print("Masukkan pilihan: ");
        int pilihan = input.nextInt();

        int uang, kembalian;

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan uang anda: ");
                uang = input.nextInt();
                System.out.println("Anda membeli Kopi");
                if (uang == kopi) {
                    System.out.println("Anda membeli Kopi. Uang pas, tidak ada kembalian");
                } else if (uang > kopi) {
                    kembalian = (uang - kopi);
                    System.out.printf("%-14s: Rp%d%n", "Anda membeli Kopi. Kembalian", kembalian);
                } else {
                    System.out.println("Uang anda kurang");
                }
                break;

            case 2:
                System.out.print("Masukkan uang anda: ");
                uang = input.nextInt();
                System.out.println("Anda membeli Teh");
                if (uang == teh) {
                    System.out.println("Anda membeli teh. Uang pas, tidak ada kembalian");
                } else if (uang > teh) {
                    kembalian = (uang - teh);
                    System.out.printf("%-14s: Rp%d%n", "Anda membeli teh. Kembalian", kembalian);
                } else {
                    System.out.println("Uang anda kurang");
                }
                break;

            case 3:
                System.out.print("Masukkan uang anda: ");
                uang = input.nextInt();
                System.out.println("Anda membeli Air Mineral");
                if (uang == airMineral) {
                    System.out.println("Anda membeli air mineral. Uang pas, tidak ada kembalian");
                } else if (uang > airMineral) {
                    kembalian = (uang - airMineral);
                    System.out.printf("%-14s: Rp%d%n", "Anda membeli teh. Kembalian", kembalian);
                } else {
                    System.out.println("Uang anda kurang");
                }
                break;
            default:
                System.out.println("Pilihan tidak tersedia");
                break;
        }
    }
}
