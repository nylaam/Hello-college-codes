import java.util.Scanner;

public class ParkirKendaraan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double menit = input.nextDouble();

        if (menit <= 0) {
            System.out.println("Misiiii input ga valid nihh!!");
            return;
        }

        input.nextLine();
        String jenisKendaraan = input.nextLine().toLowerCase();

        double biaya;
        double jam = menit / 60.0;

        if (menit <= 5) {
            biaya = 3000;
            System.out.printf("Biaya parkir %s hanya Rp%,.2f karena hanya %.1f menit", jenisKendaraan, biaya, menit);
            return;
        } else if (jenisKendaraan.equalsIgnoreCase("motor") || jenisKendaraan.equalsIgnoreCase("mobil")) {
            biaya = 5000;

            if (menit > 120) {
                double extraMenit = menit - 120;
                int biayaTambahan = (int) Math.ceil(extraMenit / 10.0);

                if (jenisKendaraan.equalsIgnoreCase("motor")) {
                    biaya += biayaTambahan * 1000;
                } else if (jenisKendaraan.equalsIgnoreCase("mobil")) {
                    biaya += biayaTambahan * 2000;
                }
                System.out.printf("Biaya parkir %s selama %.1f jam adalah Rp%,.2f", jenisKendaraan, jam, biaya);
            } else {
                System.out.printf("Biaya parkir %s selama %.1f jam adalah Rp %,.2f", jenisKendaraan, jam, biaya);
            }
            return;
        } else {
            System.out.printf("Jalan kaki tidak perlu bayar parkir");
            return;
        }
    }
}