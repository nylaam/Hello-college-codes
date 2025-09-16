import java.util.Scanner;

public class ParkirKendaraan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int menit = input.nextInt();
        String jenisKendaraan = input.next().toLowerCase(); 
        double biaya;

        double jam = menit / 60.0;

        if (menit <= 0){
            System.out.println("Misiiii input ga valid nihh!!");
            return;
        } if (menit <= 5) {
            biaya = 3000;
            System.out.printf("Biaya parkir %s hanya Rp %,.2f karena hanya %d menit", jenisKendaraan, biaya, menit);
            return;
        } else if (jenisKendaraan.equals("motor") || jenisKendaraan.equals("mobil")) {
            biaya = 5000;
            if (menit > 120) {
                double extraMenit = menit - 120;
                int biayaTambahan = (int) Math.ceil(extraMenit / 10.0); 
 
                if (jenisKendaraan.equals("motor")) {
                    biaya += biayaTambahan * 1000; 
                } else { 
                    biaya += biayaTambahan * 2000;
                }
            }
            System.out.printf("Biaya parkir %s selama %.1f jam adalah Rp %, .2f%n", jenisKendaraan, jam, biaya);
            return;
        } else {
            System.out.println("Jalan kaki tidak perlu bayar parkir");
            return;
        }
    }
}
