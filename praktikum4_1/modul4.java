package praktikum4_1;
import java.util.Arrays;
import java.util.ArrayList;

public class modul4 {
    public static void main(String[] args) {
        
        // ===== Deklarasi & Instansiasi Array =====
        int[] a = new int[5];            // array int berisi 5 elemen (default 0)
        // int a[] = new int[5];
        String[] nama = new String[3];   // array String berisi 3 elemen (default null)
        
        // ===== Inisialisasi Array =====
        int[] b = {1, 2, -4, 8, 9};      // inisialisasi langsung
        a[0] = 10; a[1] = 20; a[2] = 30; a[3] = 40; a[4] = 50;
        
        // ===== Akses Elemen Array =====
        System.out.println("Elemen ke-0 array a = " + a[0]);
        System.out.println("Elemen ke-3 array b = " + b[3]);

        // ===== Loop untuk Menampilkan Elemen Array =====
        System.out.println("\nIsi array a:");
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }
        
        // ===== Operasi Dasar (Jumlahkan Isi Array) =====
        // loop for each
        int jumlah = 0;
        for (int nilai : b) jumlah += nilai;
        System.out.println("\nJumlah semua elemen array b = " + jumlah);
        // loop for
        int jumlah2 = 0;
        for (int i = 0; i < b.length; i++) {
            jumlah += b[i];
        }
        System.out.println("\nJumlah semua elemen array b = " + jumlah2);


        // ===== Array Multidimensi (2D) =====
        int[][] matriks = {
            {1, 2, 3},
            {4, 5, 6}
        };
        System.out.println("\nIsi array 2D (matriks):");
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks[i].length; j++) {
                System.out.print(matriks[i][j] + " ");
            }
            System.out.println();
        }

        // ===== Jagged Array (kolom tiap baris berbeda) =====
        int[][] jagged = new int[2][];
        jagged[0] = new int[3]; // baris pertama ada 3 kolom
        jagged[1] = new int[5]; // baris kedua ada 5 kolom
        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                jagged[i][j] = i + j;
            }
        }
        System.out.println("\nIsi jagged array:");
        for (int i = 0; i < jagged.length; i++) {
            System.out.println(Arrays.toString(jagged[i]));
        }

        // ===== Default Value Elemen Array =====
        System.out.println("\nDefault value int[0] = " + new int[1][0]);
        System.out.println("Default value String[0] = " + new String[1][0]);

        // ===== Shallow Copy vs Deep Copy =====
        int[] arr1 = {1, 2, 3};
        int[] arr2 = arr1; // shallow copy (referensi sama)
        arr2[0] = 99;
        System.out.println("\nSetelah ubah arr2[0]=99, arr1[0] = " + arr1[0]);

        int[] arr3 = Arrays.copyOf(arr1, arr1.length); // deep copy
        arr3[0] = 7;
        System.out.println("Setelah ubah arr3[0]=7, arr1[0] tetap = " + arr1[0]);

        // ===== Utility Class Arrays =====
        int[] data = {5, 3, 8, 1};
        Arrays.sort(data);
        System.out.println("\nSetelah sort: " + Arrays.toString(data));
        int pos = Arrays.binarySearch(data, 5);
        System.out.println("Posisi angka 5 setelah sort = " + pos);

        // ===== For-each Loop =====
        System.out.println("\nLooping dengan for-each:");
        for (int nilai : data) {
            System.out.print(nilai + " ");
        }
        System.out.println();

        // ===== Array 3 Dimensi =====
        int[][][] kubus = new int[2][2][2];
        kubus[0][1][1] = 10;
        System.out.println("\nNilai kubus[0][1][1] = " + kubus[0][1][1]);
    }
}