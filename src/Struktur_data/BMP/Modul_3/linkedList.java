package BMP.Modul_3;

import java.util.*;

class LatihList { // Nama class diubah agar tidak bentrok
    public static void main(String[] args) {
        LinkedList<String> L = new LinkedList<>(); // Memanggil cetakan asli bawaan Java (huruf L besar)
        L.add("O");
        L.add("N");
        L.add("E");

        // Perulangan untuk mengecek setiap gerbong
        for (Object stackList : L) {
            System.out.print(stackList + "->"); // Nama variabel disamakan dan pakai print (tanpa ln)
        }
    }
}