package BMP.Modul_3;

public class Array2D {
    public static void main(String[] args) {
        int[][] duaDimensi = { { 10, 12 }, { 11, 14 } };
        System.out.println("array dengan matriks 2*2");
        for (int i = 0; i < duaDimensi.length; i++) {
            for (int j = 0; j < duaDimensi.length; j++) {
                System.out.print(duaDimensi[i][j] + "\t");

            }
            System.out.println();
        }

    }
}
