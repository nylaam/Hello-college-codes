import java.util.*; //wajib ada jika ingin menggunakan Scanner

//import
    //import package.name.Class = import 1 kelas
    //import java.util.Scanner; digunakan untuk mendapatkan input dari user
    //import package.name.* = import seluruh package
    //import java.util.*; merupakan sebuah built-in package dari JAVA

public class modul1{
    public static void main(String[] args) {

        //deklarasi variabel  inisialisasi variabel
        //[tipe data][nama] = [inisialisasi value];
        String nama1 = "Salsa";
       
        //atau
        //[tipe data] [nama var 1], [nama var 2], dst ;
        //deklarasi variabel tanpa inisialisasi variabel
        String nama2;
        //[nama variabel] = [inisialisasi value];
        nama2 = "Salsa"; 

        //proses
        //operasi aritmatika
        // + pertambahan
        // - pengurangan
        // / pembagian
        // * perkalian
        // % modulo (sisa pembagian)


        //Math.pow(a, b) a pangkat b
        //Math.sqrt() akar 2
        //Math.cbrt() akar 3
        //Math.abs() nilai absolut
        //dst

        //Math class     

        //Math: nama class. Memiliki banyak rumus dan fungsi berupa kode di dalamnya.
        //   .[rumus]  = rumus atau fungsi terletak setelah nama class, diawali oleh titik. Disebut dengan method.
        //[rumus]() = kurung setelah method yang mengolah data di dalam kurung sesuai kode di method, disebut dengan parameter.

        //contoh: Math.pow(a, b)    
        //Math --> kelas    
        //.pow --> method untuk mencari hasil pangkat    
        //(a, b) --> parameter.   a--> angka yang ingin dipangkat,   b--> nilai pangkat

        // list method pada kelas Math: https://www.w3schools.com/java/java_ref_math.asp

        //apa lagi Class yang sering dipakai di Java?

        //input

        //Memasukkan data ke variable secara manual dari kode
        int nilai = 90;
        float rerata = 98.78f;
        boolean mahasiswa_aktif = true;

        //Menggunakan data yang dimasukkan oleh user melalui terminal
        Scanner input = new Scanner(System.in);
        String nama = input.nextLine();
        int umur = input.nextInt();

        //jika ingin menggunakan input.nextLine(), perhatikan input yang digunakan sebelumnya
        //jika input sebelumnya adalah yang selain nextLine(), maka wajib menuliskan input.nextLine() terlebih dahulu
        //Mengapa?
        input.nextLine();
        String nim = input.nextLine();
        double gpa = input.nextDouble();
        float apaAja = input.nextFloat();
        System.out.print("Nama: "+nama+"\nNIM : "+nim+"\numur: "+umur+"\nGPA: "+gpa+"\napaAja: "+apaAja);

        //output

        //print tanpa baris baru
        System.out.print("Hello, World!"); 

        //print dengan baris baru di akhir (se akan-akan menekan enter pada akhir kalimat)
        System.out.println("Hello, World!"); 

        //menggabungkan String
        System.out.println("Praktikum "+"Pemdas");

        //menggabungkan String dengan variable
        System.out.println("Nama Saya : "+nama1); 
        System.out.println("Mahasiswa Aktif: "+mahasiswa_aktif);

        //menampilkan langsung hasil sebuah perhitungan
        System.out.println(10%3+5);
        System.out.println(Math.pow(4,2));

        //printf : digunakan untuk memberi format pada output
        //%s = string
        //%d = angka bulat
        //%f = angka desimal

        System.out.printf("Nama saya adalah %s\n", nama1);
        System.out.printf("Nilai saya adalah %d\n", nilai);
        System.out.printf("Rata-rata saya adalah %.2f\n", rerata);
        System.out.printf("Nama saya adalah %s, nilai saya %d, dan rata-rata saya %.2f\n", nama1, nilai, rerata);

        //printf lanjut (ANGKA)

        //%.[jumlah angka di belakang koma]f  
        // --> membulatkan angka berkoma ke jumlah angka setelah desimal (bagaimana kalau lebih?)
        System.out.printf("\n%.2f", 80000f);

        //%,[jumlah angka terpisah]d 
        // --> memisahkan angka bulat dengan koma berdasarkan jumlah angka yang ditentukan
        System.out.printf("\n%,.2f", 80000f);

        //%0[jumlah angka yang ditampilkan]f/d 
        // --> mengisi sisa angka yang tidak ditampilkan di depan dengan angka 0
        System.out.printf("\n%010.0f", 01003f);

        //printf lanjut (String)
        //%[jumlah karakter]s
        // --> rata kanan
        System.out.printf("\n%30s", "Ini rata kanan");

        //%-[jumlah angka yang ditampilkan]s
        // --> rata kiri
        System.out.printf("\n%-30s", "Ini rata kiri");

        //%-[jumlah kolom].[jumlah karakter]s
        System.out.printf("\nNilai saya adalah %-5.3s ini", "2452527777");
        System.out.printf("\nNilai saya adalah %10.3s", "2452527777");

        //proses
        //System.out.println(10%3+5); --> bisa langsung dengan output atau

        //[tipe data][nama] = [proses yang dilakukan]
        int hasil = 10%3+5;
    }
}