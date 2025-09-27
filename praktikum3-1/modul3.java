

import java.util.Scanner;

public class modul3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // while loop: Jumlah perulangannya tidak nentu
        // contoh: program kalkulator, program untuk menggunakan remote TV
        // perlu ada kondisi untuk bikin loop berhenti, umumnya 2 cara:

        // cara 1: KONDISI STOP LANGSUNG DINYATAKAN
        boolean isRunning = true;
        int x = 0;

        while (x < 9) { //KONDISI STOP --> X < 9
            System.out.println("Perulangan saat ini: " + (x + 1));
            x++;
        }

        // cara 2: MENGGUNAKAN IF STATEMENT/VARIABEL BOOLEAN
        
        boolean kondisiStop = false; //VARIABEL BOOLEAN SEBAGAI KONDISI
        
        while (!kondisiStop) {       //jika kondisiStop = false, maka !kondisiStop = ?
            
            System.out.println("Proses perulangan...");
            System.out.println("Apakah ingin stop (Ya/Tidak): ");
            String inginStop = in.next();

            if (inginStop.equals("Ya")) {  
                kondisiStop = true; //MENGGANTI NILAI VARIABEL BOOLEAN
            }
        }

        //BREAK
        x = 0;
        while (x<9) {
            System.out.println("Perulangan saat ini: "+(x+1));
            x++;

            if (x==7) {
                break; //LANGSUNG HENTIKAN LOOPING
            }

            System.out.println("Program lanjut");
        }

        //CONTINUE
        x = 0;
        while (x<9) {
            x++;
            System.out.println("Perulangan saat ini: "+(x+1));

            if (x==7) {
                continue; //LONCATI 1 LOOP
            }

            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("Program lanjut");
        }

        System.out.println("Program berhenti");


        //WHILE TRUE
        while (true) {
            System.out.println("Proses perulangan...");
            System.out.println("Apakah ingin stop (Tr  ue/False): ");
            kondisiStop = in.nextBoolean();

            if (kondisiStop) {
                break;
            }
        }

        System.out.println("Program berhenti");


        // INFINITE LOOP
        kondisiStop = false;
        while (!kondisiStop) {
            System.out.println("Running");
        }

        isRunning = true;
        while (isRunning) {
            System.out.println("Running");
        }


        // for loop: jumlah perulangan sudah pasti

        // FORMAT:
        // for (variabel lokal; batas; inkremen/dekremen)
        // variabel lokal WAJIB
        // inkremen/dekremen TIDAK WAJIB
        
        for (int i = 0; i < 10; i++) {
            System.out.println("i saat ini: " + i);
        }

        for (int i = 0; i <= 10; i += 10) {
            System.out.println("i saat ini: " + i);
        }

        
        // INFINITE LOOP
        for (int i = 0; i < 10;) {
            System.out.println("i saat ini: " + i);
        }


        int jam = 7;
        int jamMakan = 12;

        boolean sudahMakan = false;
        for (int i = jam; i <= jamMakan; i++) {
            System.out.println("Jam saat ini: " + (i));
        }
        System.out.println("Saatnya makan");

        for (int i = 0; i <= 3;) {
            System.out.println(i++);
        }

        // apakah perulangan ini
        System.out.println("Loop 1");
        for (int i = 4; i > 2; i--) {
            System.out.println("i saat ini: " + i);
        }

        // beda dengan
        System.out.println("Loop 2");
        for (int i = 4; i > 2;) {
            System.out.println("i saat ini: " + (--i));
        }
        
        //NESTED FOR LOOP
        for (int i = 0; i < 3; i++) {
            System.out.println("Loop i: " + i);
            for (int j = 0; j < 2; j++) {
                System.out.println("Loop j: "+ j);
            }
            System.out.println("");
        }


        x = 3;
        do {
            System.out.println(x);
        } while (x<3);

    }
}