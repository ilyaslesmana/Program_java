package Modul_4;

import java.util.Scanner;

public class StatistikaDistribusi {

    // Fungsi untuk menghitung Faktorial
    public static double hitungFaktorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        double hasil = 1;
        for (int i = 2; i <= n; i++) {
            hasil *= i;
        }
        return hasil;
    }

    // Fungsi untuk menghitung Kombinasi (nCr)
    // Dioptimasi agar tidak terkena Integer Overflow untuk n yang besar
    public static double hitungKombinasi(int n, int r) {
        if (r == 0 || n == r)
            return 1;
        if (r > n / 2)
            r = n - r; // Sifat simetri kombinasi

        double pembilang = 1;
        double penyebut = 1;
        for (int i = 0; i < r; i++) {
            pembilang *= (n - i);
            penyebut *= (i + 1);
        }
        return pembilang / penyebut;
    }

    // Fungsi Distribusi Binomial
    public static double hitungBinomial(int n, int x, double p) {
        double kombinasi = hitungKombinasi(n, x);
        double peluangSukses = Math.pow(p, x);
        double peluangGagal = Math.pow(1 - p, n - x);
        return kombinasi * peluangSukses * peluangGagal;
    }

    // Fungsi Distribusi Poisson
    public static double hitungPoisson(double lambda, int x) {
        double euler = Math.E;
        return (Math.pow(euler, -lambda) * Math.pow(lambda, x)) / hitungFaktorial(x);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean jalan = true;

        System.out.println("=========================================");
        System.out.println("  Sistem Kalkulasi Distribusi Peluang");
        System.out.println("=========================================");

        while (jalan) {
            System.out.println("\nPilih Kasus yang Ingin Dihitung:");
            System.out.println("1. Distribusi Binomial (Kasus Lampu LED / Mesin Digit)");
            System.out.println("2. Distribusi Poisson (Kasus Lampu LED > 3 Cacat)");
            System.out.println("3. Keluar");
            System.out.print("Pilihan lo: ");
            int pilihan = input.nextInt();

            if (pilihan == 1) {
                System.out.println("\n--- Hitung Distribusi Binomial ---");
                System.out.print("Masukkan jumlah percobaan (n): ");
                int n = input.nextInt();
                System.out.print("Masukkan jumlah sukses yang diinginkan (x): ");
                int x = input.nextInt();
                System.out.print("Masukkan peluang sukses (p) [contoh 0.5 atau 0.00066]: ");
                double p = input.nextDouble();

                double hasil = hitungBinomial(n, x, p);
                System.out.printf("Peluang P(X = %d) adalah: %.5f\n", x, hasil);

            } else if (pilihan == 2) {
                System.out.println("\n--- Hitung Distribusi Poisson ---");
                System.out.print("Masukkan rata-rata kejadian (lambda): ");
                double lambda = input.nextDouble();
                System.out.print("Masukkan jumlah kejadian yang dicari (x): ");
                int x = input.nextInt();

                double hasil = hitungPoisson(lambda, x);
                System.out.printf("Peluang P(X = %d) adalah: %.5f\n", x, hasil);

            } else if (pilihan == 3) {
                System.out.println("Sip, program dihentikan. Semangat ngodingnya!");
                jalan = false;
            } else {
                System.out.println("Pilihan nggak valid, coba lagi bro.");
            }
        }
        input.close();
    }
}