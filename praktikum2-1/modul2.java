public class modul2 {
    public static void main (String[] args) {

        //logical operator
        // && --> AND
        // || --> OR
        // == --> sama dengan
        // [variabel].equals([variabel2]) --> membandingkan 2 var beda dgn variabel
        // [variabel].equals("ini kata")  --> tanpa menggunakan var pembanding

        String hewan1 = "Ayam";
        String hewan2 = "ayam";
        System.out.println(hewan1 == hewan2); //jangan biasakan pakai ini
        System.out.println(hewan1.equals(hewan2)); //biasakan pakai ini
        System.out.println(hewan1.equals("Ayam"));
        System.out.println(hewan1.equalsIgnoreCase(hewan2));

        // != --> tidak sama dengan
        // >  --> lebih dari
        // <  --> kurang dari
        // >= --> lebih dari sama dengan
        // <= --> kurang dari sama dengan
        // !  --> NOT, mengembalikan nilai boolean

        boolean kitaMahasiswa = false;
        System.out.println("Apakah kita mahasiswa?" + (!kitaMahasiswa));

        // if else
        int nilai = 75;

        // style 1 (standart)
        if (nilai >= 75) {
            System.out.println("Anda lulus");
        } else {
            System.out.println("Anda gagal");
        }

        // style 2
        if (nilai >= 75)
        {
            System.out.println("Anda lulus");
        }
        else
        {
            System.out.println("Anda gagal");
        }

        // else if - harus memenuhi keduanya
        String pendidikanSekarang = "S1";
        int usia = 12;
        if (pendidikanSekarang.equals("S1") && usia <= 16) {
            System.out.println("Anda merupakan sarjana, dengan usia yang sangat muda yaitu " + usia + " tahun.");
        } else if (pendidikanSekarang.equals("S1") && usia >= 17) {
            System.out.println("Anda merupakan mahasiswa dengan usia " + usia + "tahun.");
        } else {
            System.out.println("Anda bukan merupakan mahasiswa");
        }

        //if else - salah satu syarat saja
        double ipk = 3.8;
        double skm = 890;
        if (ipk >= 3.5 || skm >= 900) {
            System.out.println("Anda lulus");
        } else {
            System.out.println("Anda gagal");    
        }

        // else if - salah satu syarat saja
        if (ipk >= 3.5) {
            System.out.println("Anda lulus");
        } else if (skm >= 900) {
            System.out.println("Anda lulus");
        } else {
            System.out.println("Anda gagal");
        }

        // tanpa else - tetap bisa halan tp jika kondisi
        // tidak terpenuhi tidak memerlukan output apa apa
        if (ipk >= 3.5) {
            System.out.println("Anda lulus");
        } else if (skm >= 900) {
            System.out.println("Anda lulus");
        } else if (ipk >= 4 && skm <= 500){
            System.out.println("Anda gagal");
        }

        nilai = 99;
        if (nilai == 100) {
            System.out.println("Nilai anda maksimal");
        }

        if ((nilai + 1) == 100) {
            System.out.println("Nilai anda maksimal");
        }

        System.out.println(nilai);


        // switch case
        int hari = 5;
        switch (hari) {
            case 1:
                System.out.println("Hari ini adalah hari Minggu");
                break;
            case 2:
                System.out.println("Hari ini adalah hari Senin");
                break;
            case 3:
                System.out.println("Hari ini adalah hari Selasa");
                break;
            case 4:
                System.out.println("Hari ini adalah hari Rabu");
                break;
            case 5:
                System.out.println("Hari ini adalah hari Kamis");
                break;
            case 6:
                System.out.println("Hari ini adalah hari Jumat");
                break;
            case 7:
                System.out.println("Hari ini adalah hari Sabtu");
                break;
            default:
                System.out.println("Hari tidak ditemukan");
                break;
        }

        // ternary operation
        int angkaBesar = 10;
        int angkaKecil = 20;

        if (angkaBesar > angkaKecil) {
            System.out.println("Angka lebih besar adalah " + angkaBesar);
        } else {
            System.out.println("Angka lebih besar " + angkaKecil);
        }

        // Kondisi ? [True] : [False]
        int yangLebihBesar = (angkaBesar > angkaKecil) ? angkaBesar : angkaKecil;
        System.out.println("Angka yang lebih besar adalah " + yangLebihBesar);

        // Nested if else
        String gender = "Laki-laki";
        int umur = 20;

        if (gender == "Laki-laki") {
            if (umur >= 18) {
                System.out.println("Laki-laki dewasa");
            } else if (umur >= 13) {
                System.out.println("Laki-laki remaka");
            } else {
                System.out.println("Laki-laki anak-anak");
            }

        } else if (gender == "Perempuan") {
            if (umur >= 18) {
                System.out.println("Perempuan dewasa");
            } else if (umur >= 13) {
                System.out.println("Perempuan remaka");
            } else {
                System.out.println("Perempuan anak-anak");
            }
        }


        // increment decrement
        int hey = 0;
        if (hey++ == 1) {
            System.out.println("ya nambah 1 weh");
        } else {
            System.out.println("0 lah kocak");
        }

        // Apa perbedaan antara hey++ dan ++hey?

        // CHALLENGE: POIN KEAKTIFAN 1
        // BIKIN PROGRAM AGAR ANGKA A DAN B DIBANDINGKAN NILAINYA
        // A HARUS LEBIH BESAR DARIPADA B
        // TUKAR NILAINYA JIKA B>A
        // PRINT NILAI A DAN B

        //CHALLENGE: POIN KEAKTIFAN 2
        // BIKIN PROGRAM YANG MENGHITUNG JIKA PELANGGAN MENDAPATKAN DISKON
        // JIKA PEMBELIAN > 100, PELANGGAN DAPAT DISKON 10%
        // JIKA PEMBELIAN > 200, PELANGGAN DAPAT DISKON 20%
        // JIKA PEMBELIAN > 500, PELANGGAN DAPAT DISKON 50%
        // OUTPUT LANGSUNG JUMLAH TOTAL PEMBELIAN DENGAN DISKON
        // TETAP HARUS OUTPUT TOTAL PEMBELIAN MESKIPUN TIDAK DISKON

    }
}
