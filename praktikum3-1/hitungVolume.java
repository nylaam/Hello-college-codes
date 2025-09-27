import java.util.Scanner;

public class hitungVolume {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("MENU");
            System.out.println("0. KELUAR");
            System.out.println("1. HITUNG VOLUME BALOK"); 
            System.out.println("2. HITUNG VOLUME BOLA");
            System.out.println("3. HITUNG VOLUME KERUCUT");
            System.out.println("4. HITUNG VOLUME SILINDER");
            System.out.println("5. HITUNG VOLUME LIMAS SEGITIGA");
            System.out.print("MASUKKAN PILIHAN ANDA: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("Anda memilih untuk menghitung Volume Balok");
                    System.out.print("Masukkan Panjang: ");
                    double p = input.nextDouble();
                    System.out.print("Masukkan Lebar: ");
                    double l = input.nextDouble();
                    System.out.print("Masukkan Tinggi: ");
                    double t = input.nextDouble();
                    System.out.println("Volume Balok = " + (p * l * t));
                    break;
                case 2:
                    System.out.println("Anda memilih untuk menghitung Volume Bola");
                    System.out.print("Masukkan Jari-jari: ");
                    double r = input.nextDouble();
                    System.out.println("Volume Bola = " + (4.0 / 3.0 * Math.PI * Math.pow(r, 3)));
                    break;
                case 3:
                    System.out.println("Anda memilih untuk menghitung Volume Kerucut");
                    System.out.print("Masukkan Jari-jari: ");
                    r = input.nextDouble();
                    System.out.print("Masukkan Tinggi: ");
                    t = input.nextDouble();
                    System.out.println("Volume Kerucut = " + (1.0 / 3.0 * Math.PI * r * r * t));
                    break;
                case 4:
                    System.out.println("Anda memilih untuk menghitung Volume Silinder");
                    System.out.print("Masukkan Jari-jari: ");
                    r = input.nextDouble();
                    System.out.print("Masukkan Tinggi: ");
                    t = input.nextDouble();
                    System.out.println("Volume Silinder = " + (Math.PI * r * r * t));
                    break;
                case 5:
                    System.out.println("Anda memilih untuk menghitung Volume Limas Segitiga");
                    System.out.print("Masukkan Luas alas: ");
                    double a = input.nextDouble();
                    System.out.print("Masukkan Tinggi: ");
                    t = input.nextDouble();
                    System.out.println("Volume Limas Segitiga = " + (1.0 / 3.0 * a * t));
                    break;
                case 0:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
            System.out.println(); 
        } while (pilihan != 0);
    }
}
