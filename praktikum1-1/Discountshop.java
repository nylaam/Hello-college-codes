import java.util.Scanner;

public class Discountshop {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        int tanggalBeli = input.nextInt();
        int bulanBeli = input.nextInt();
        int tahunBeli = input.nextInt();
        input.nextLine();
        String belanjaBarang = input.nextLine();
        int jumlahBarang = input.nextInt();
        double hargaBarang = input.nextDouble();
        float diskon = input.nextFloat();
        boolean jenisPembayaran = input.nextBoolean();
        
        //proses hitung
        double totalHarga = jumlahBarang * hargaBarang;
        double jumlahPembayaran = totalHarga - (totalHarga*(diskon/100));
        
        //output
        System.out.println(" ========= List Barang =========");
        System.out.printf("%-17s : %d%s%d%s%d\n", "Tanggal", tanggalBeli, "-",  bulanBeli, "-",  + tahunBeli);
        System.out.printf("%-17s : %s%n", "Barang belanja", belanjaBarang);
        System.out.printf("%-17s : %d%n", "Jumlah barang", jumlahBarang);
        System.out.printf("%-17s : %,.2f%n", "Harga barang", hargaBarang);
        System.out.printf("%-17s : %.1f%% %n", "Diskon", diskon);
        System.out.println("-------------------------------");
        System.out.printf("%-17s : Rp%,.2f%n", "Total harga", totalHarga);
        System.out.printf("%-17s : Rp%,.2f%n", "Pembayaran", jumlahPembayaran);
        System.out.printf("%-17s : %s", "Pembayaran tunai", jenisPembayaran ? "true" : "false");
    }
}   