package Struktur_data.BMP.Modul_3;

public class Array1D {
    public static void main(String[] args) {
        int[] jumlah = new int[10];
        System.out.println("nilai isi array");
        int x = 1;
        for (int i = 0; i < jumlah.length; i++) {
            jumlah[i] = x;
            x++;
            System.out.println(jumlah[i]);
        }
        int total = 0;
        for (int i = 0; i < jumlah.length; i++) {
            total += jumlah[i];
        }
        System.out.println("=====================");
        System.out.println("hasil penjulahana " + total);
    }
}
