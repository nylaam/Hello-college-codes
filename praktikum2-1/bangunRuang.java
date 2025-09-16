import java.util.Scanner;

public class bangunRuang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Menu"); 
        System.out.println("1. menghitung luas dan keliling persegi panjang");
        System.out.println("2. menghitung luas dan keliling lingkaran");
        System.out.println("3. menghitung luas dan keliling segitiga");
        System.out.print("\nPilihan anda: ");
        int pilihan = input.nextInt();

        switch (pilihan) {  
            case 1:
                System.out.println("Menghitung luas dan keliling persegi panjang");
                System.out.print("Masukkan p: ");
                int p = input.nextInt();
                System.out.print("Masukkan l: ");
                int l = input.nextInt();

                int kelilingPerPan = 2 * (p + l);
                int luasPerPan = (p * l);

                System.out.printf("%-25s: %d cm%n", "Keliling persegi panjang", kelilingPerPan);
                System.out.printf("%-25s: %d cm2%n", "Luas persegi panjang", luasPerPan);
                break;
                
            case 2:
                System.out.println("Menghitung luas dan keliling lingkaran");
                System.out.print("Masukkan r: ");
                double r = input.nextDouble();
                double phi = 3.14;

                double kelilingLingkaran = 2 * phi * r;
                double luasLingkaran = phi * r * r;

                System.out.printf("%-25s: %.0f cm%n", "Keliling lingkaran", kelilingLingkaran);
                System.out.printf("%-25s: %.0f cm2%n", "Luas lingkaran", luasLingkaran);
                break;

            case 3: 
                System.out.println("Menghitung luas dan keliling segitiga");
                System.out.print("Masukkan a: ");
                double a = input.nextDouble();
                System.out.print("Masukkan b: ");
                double b = input.nextDouble();
                System.out.println("Masukkan c: ");
                double c = input.nextDouble();

                double kelilingSegitiga = (a + b + c);
                double luasSegitiga = (a*b)/2;

                System.out.printf("%-25s: %.0f cm%n", "Keliling segitiga", kelilingSegitiga);
                System.out.printf("%-25s: %.0f cm2%n", "Luas segitiga", luasSegitiga);
                break;
        
            default:
                System.out.println("Data tak ditemukan, program dihentikan ...");
                break;
        }
    }
}
