package BMP.Modul_3;

import java.util.*;

public class latihansoallist {
    public static void main(String[] args) {
        LinkedList<String> L = new LinkedList<>(); // Memanggil cetakan asli bawaan Java (huruf L besar)
        L.add("A");
        L.add("B");
        L.add("C");

        // Perulangan untuk mengecek setiap gerbong
        for (Object stackList : L) {
            System.out.print(stackList + "/"); // Nama variabel disamakan dan pakai print (tanpa ln)
        }
    }
}
