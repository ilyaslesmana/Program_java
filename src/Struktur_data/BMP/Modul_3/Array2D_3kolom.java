package Struktur_data.BMP.Modul_3;

public class Array2D_3kolom {
    public static void main(String[] args) {
        int[][] duaDimensi = { { 150, 170, 190 }, { 151, 171, 191 } };
        System.out.println("array dengan matriks 2*2");
        for (int i = 0; i < duaDimensi.length; i++) {
            for (int j = 0; j < duaDimensi[i].length; j++) {// penambhana dimensi [i]
                System.out.print(duaDimensi[i][j] + "\t");

            }
            System.out.println();
        }

    }
}
/*
 * Solusinya menurut Modul (Halaman 3.23):
 * Untuk menghitung jumlah kamar di lantai tertentu, kita tidak boleh melihat
 * jumlah lantai. Kita harus melihat jumlah isi di dalam lantai tersebut dengan
 * cara memanggil: duaDimensi[i].length.
 * Panjang dari duaDimensi[i].length pada kasus Anda akan bernilai 3 (karena ada
 * 3 angka di dalam setiap kurung kurawal lantai).
 */