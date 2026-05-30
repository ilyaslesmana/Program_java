package Metode_Statistika.Modul_4;

import java.util.Locale;

public class Tugas3_MetodeStatistika {
    public static void main(String[] args) {
        // 1. Inisialisasi Data Sampel (60 data dari Soal 1)
        double[] data = {
                3.2, 2.8, 4.1, 3.6, 5.0, 4.4, 2.5, 3.9, 3.2, 2.8,
                4.8, 3.1, 2.2, 4.6, 3.7, 5.3, 4.0, 3.4, 4.8, 3.1,
                2.9, 3.8, 4.7, 5.1, 3.0, 2.6, 4.2, 3.5, 2.9, 3.8,
                5.4, 4.9, 3.3, 2.1, 4.5, 3.2, 5.6, 4.1, 5.4, 4.9,
                3.6, 2.7, 4.8, 5.2, 3.9, 4.3, 2.4, 3.0, 3.6, 2.7,
                3.2, 2.8, 4.1, 3.6, 5.0, 4.4, 2.5, 3.9, 3.2, 2.8
        };

        int n = data.length;
        double sum = 0;
        double sumOfSquares = 0;

        // 2. Proses Sekuensial: Menghitung Sigma X dan Sigma X^2 dalam satu loop
        for (double x : data) {
            sum += x;
            sumOfSquares += (x * x);
        }

        // 3. Implementasi Rumus Logika Statistika
        // Rumus Mean: Bar_X = Sum / n
        double mean = sum / n;

        // Rumus Deviasi Standar Sampel (s): sqrt((n*Sum_X^2 - (Sum_X)^2) / (n*(n-1)))
        double varianceNumerator = (n * sumOfSquares) - (sum * sum);
        double varianceDenominator = n * (n - 1);
        double standardDeviation = Math.sqrt(varianceNumerator / varianceDenominator);

        // Rumus Taksiran Standar Eror (s_bar): s / sqrt(n)
        double standardError = standardDeviation / Math.sqrt(n);

        // 4. Output Hasil dengan Format Berdasarkan Locale US (agar desimal menggunakan
        // titik)
        System.out.println("=== HASIL ANALISIS STATISTIKA ===");
        System.out.printf(Locale.US, "Jumlah Sampel (n)          : %d%n", n);
        System.out.printf(Locale.US, "Total Nilai Data (Sum X)   : %.2f%n", sum);
        System.out.printf(Locale.US, "Total Kuadrat (Sum X^2)    : %.2f%n", sumOfSquares);
        System.out.println("---------------------------------");
        System.out.printf(Locale.US, "a. Mean (Rata-rata)        : %.2f%n", mean);
        System.out.printf(Locale.US, "   Deviasi Standar Sampel  : %.4f%n", standardDeviation);
        System.out.printf(Locale.US, "b. Taksiran Standar Eror   : %.4f%n", standardError);
        System.out.println("=================================");
    }
}