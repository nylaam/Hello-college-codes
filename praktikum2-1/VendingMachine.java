import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        String barangA = "A", jualA = "susu";
        double hargaA = 7500;
        int stokA = 3;
        
        String barangB = "B", jualB = "snack";
        double hargaB = 10000;
        int stokB = 4;
        
        String barangC = "C", jualC = "air mineral";
        double hargaC = 6500;
        int stokC = 1;
        
        String kodeBarang = input.nextLine().trim();
        int jumlahBarang = input.nextInt();
        double jumlahUang = input.nextDouble();
        
        if (jumlahBarang <= 0){
            System.out.println("Anda tidak melakukan pembelian apapun");
            return;
        }
        
        String Barang = "";
        double hargaBijian = 0;
        int stok = 0;
        
        switch(kodeBarang){
            case "A":
                Barang = jualA;
                hargaBijian = hargaA;
                stok = stokA;
                break;
            case "B":
                Barang = jualB;
                hargaBijian = hargaB;
                stok = stokB;
                break;
            case "C":
                Barang = jualC; 
                hargaBijian = hargaC;
                stok = stokC;
                break;
            default:
                System.out.print("Kode barang tidak valid");
                return;
        }
        
        if(jumlahBarang > stok){
            System.out.print("Stok tidak mencukupi");
        }
        
        double bayar = hargaBijian * jumlahBarang;
        if(jumlahUang < bayar){
            System.out.print("Uang anda tidak cukup");
        }
        
        double kembalian = jumlahUang - bayar;
        if(jumlahUang > bayar){
            System.out.printf("Kamu sudah beli %s, dan mendapat kembalian sejumlah Rp%,.2f", Barang, kembalian);
        }
    }
}