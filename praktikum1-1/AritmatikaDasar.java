import java.util.Scanner;

public class AritmatikaDasar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("%-25s: ", "Masukkan operator pertama");
        int x = input.nextInt();
        System.out.printf("%-25s: ", "Masukkan operator kedua");
        int y = input.nextInt();
        
        //proses aritmatika
        int penjumlahan = x + y;
        int pengurangan = x - y;
        int perkalian = x * y;
        double pembagian = (double) x / y;
        
        //output
        System.out.printf("\tHasil penjumlahan  : %s%n", penjumlahan);
        System.out.printf("\tHasil pengurangan  : %s%n", pengurangan);
        System.out.printf("\tHasil perkalian    : %s%n", perkalian);
        System.out.printf("\tHasil pembagian    : %s%n", pembagian);
    }
}
