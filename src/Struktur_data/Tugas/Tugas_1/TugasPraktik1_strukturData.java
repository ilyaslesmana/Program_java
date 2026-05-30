package Struktur_data.Tugas.Tugas_1;

import java.util.LinkedList;

public class TugasPraktik1_strukturData {
    public static void main(String[] args) {

        // 1. Deklarasi variabel float 'StrukturBaris'
        float StrukturBaris = 15.6f;

        // 2. Deklarasi variabel String 'SusunanKataBaru'
        String SusunanKataBaru = "Pemrograman Struktur Data Java";

        // 3. Deklarasi array satu dimensi 'DelapanAngka'
        int[] DelapanAngka = { 10, 12, 18, 23, 33, 58, 67, 82 };

        // 4. Deklarasi array dua dimensi 'DuaAngka' (3x3)
        // Karena diminta tipe data String, angka dimasukkan sebagai literal String
        String[][] DuaAngka = {
                { "2", "4", "6" },
                { "8", "10", "12" },
                { "14", "16", "18" }
        };

        // 5. Deklarasi Linked List 'UrutanListAngka'
        LinkedList<Integer> UrutanListAngka = new LinkedList<>();
        UrutanListAngka.add(15);
        UrutanListAngka.add(28);
        UrutanListAngka.add(33);
        UrutanListAngka.add(47);
        UrutanListAngka.add(59);

        // cara akses
        System.out.println("soal no 1 : " + StrukturBaris);
        System.out.println("=======================================");
        System.out.println("String: " + SusunanKataBaru);
        System.out.println("=======================================");
        System.out.print("Array 1D : ");
        for (int i = 0; i < DelapanAngka.length; i++) {
            System.out.print(DelapanAngka[i] + ",");
        }
        System.out.println();
        System.out.println("Array 2D : ");
        for (int j = 0; j < DuaAngka.length; j++) {
            for (int j2 = 0; j2 < DuaAngka.length; j2++) {
                System.out.print(DuaAngka[j][j2] + "\t");
            }
            System.out.println();
        }
        System.out.println("=======================================");
        System.out.println("Linked List: " + UrutanListAngka);
        System.out.println("=======================================");
    }
}
