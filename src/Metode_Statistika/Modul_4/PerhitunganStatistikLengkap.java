package Metode_Statistika.Modul_4;

public class PerhitunganStatistikLengkap {
    public static void main(String[] args) {
        // Menambahkan variabel statis x sesuai permintaan
        int[] x = { 30, 27, 25, 28, 29, 32, 25 };
        int n = x.length;

        // Inisialisasi variabel untuk menampung jumlah
        double sumXi = 0;
        double sumXiSquare = 0;

        // Loop untuk menghitung Sigma xi dan Sigma xi^2 secara dinamis
        for (int nilai : x) {
            sumXi += nilai;
            sumXiSquare += Math.pow(nilai, 2);
        }

        System.out.println("=== Perhitungan Berdasarkan Data Array x ===");

        // a) Σxi
        System.out.printf("a) Σxi = %.0f%n", sumXi);

        // b) Σxi^2
        System.out.printf("b) Σxi^2 = %.0f%n", sumXiSquare);

        // c) Mean (x̄)
        double mean = sumXi / n;
        System.out.printf("c) x̄ = %.1f / %d = %.1f%n", sumXi, n, mean);

        // d) Sxx
        double sxx = sumXiSquare - (Math.pow(sumXi, 2) / n);
        System.out.printf("d) Sxx = %.1f - (%.1f^2 / %d) = %.1f%n", sumXiSquare, sumXi, n, sxx);

        // e) S^2 (Variansi Sampel)
        double variance = sxx / (n - 1);
        System.out.printf("e) S^2 = %.1f / ( %d - 1 ) = %.1f%n", sxx, n, variance);

        // f) Σ(4xi + 6)
        // Rumus: 4*Σxi + (n * 6)
        double sigmaF = (4 * sumXi) + (n * 6);
        System.out.printf("f) Σ(4xi + 6) = 4(%.0f) + %d(6) = %.0f%n", sumXi, n, sigmaF);

        // g) Σ(5xi + 6)(2xi - 3) -> VERSI PERBAIKAN
        // Ekspansi: Σ(10xi^2 - 15xi + 12xi - 18) = Σ(10xi^2 - 3xi - 18)
        // Rumus: 10*Σxi^2 - 3*Σxi - (n * 18)
        double sigmaG = (10 * sumXiSquare) - (3 * sumXi) - (n * 18);

        System.out.println("g) Σ(5xi + 6)(2xi - 3) [Perbaikan Aljabar]:");
        System.out.printf("   = 10(%.0f) - 3(%.0f) - (%d * 18)%n", sumXiSquare, sumXi, n);
        System.out.printf("   = 790 - 51 - 90%n");
        System.out.printf("   = %.0f%n", sigmaG);
    }
}