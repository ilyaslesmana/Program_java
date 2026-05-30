package Tuton.Tugas_1;

import java.util.LinkedList;

public class deklarsi {
    public static void main(String[] args) {

        float strukturBaris = 15.f;

        String susunanKataBaru = "Pemrograman Struktur Data Java";

        int[] delapanAngka = { 10, 12, 18, 23, 33, 58, 67, 82 };

        String[][] duanAngka = {
                { "2", "504", "6" },
                { "8", "10", "12" },
                { "14", "16", "18" }
        };
        LinkedList<Integer> urutanListAngka = new LinkedList<>();// 15, 28, 33, 47, 59
        urutanListAngka.add(150);
        urutanListAngka.add(28);
        urutanListAngka.add(33);
        urutanListAngka.add(47);
        urutanListAngka.add(59);
        System.out.println("soal no : " + strukturBaris);
        System.out.println("soal no 2 : " + susunanKataBaru);
        System.out.print("soal no 3 : ");
        for (int i = 0; i < duanAngka.length; i++) {
            System.out.print(delapanAngka[i] + ",");
        }
        System.out.println();
        System.out.println("soal no 4");
        for (int i = 0; i < duanAngka.length; i++) {
            for (int j = 0; j < duanAngka.length; j++) {
                System.out.print(duanAngka[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("soal no 5 : ");
        for (int angka : urutanListAngka)
            System.out.print(angka + " -> ");

    }
}
