package Struktur_data.BMP.Modul_2;

import java.util.Scanner;

public class InputNilaiMahasiswa {
    public static void main(String[] args) {
        // Persiapan Scanner untuk input keyboard
        Scanner input = new Scanner(System.in);

        // Deklarasi Array 2 Dimensi: 2 Baris (Data), 3 Kolom (No, Nama, Nilai)
        // Kita menggunakan String agar bisa menampung teks dan angka sebagai teks
        String[][] dataMahasiswa = new String[5][6];

        // Looping untuk Input Data
        for (int i = 0; i < 2; i++) {
            System.out.println("Masukkan Data ke-" + (i + 1));

            System.out.print("No: ");
            dataMahasiswa[i][0] = input.nextLine(); // Input ke Kolom 0

            System.out.print("Nama: ");
            dataMahasiswa[i][1] = input.nextLine(); // Input ke Kolom 1

            System.out.print("Nilai: ");
            dataMahasiswa[i][5] = input.nextLine(); // Input ke Kolom 2

            System.out.println("-------------------------");
        }

        // (Opsional) Menampilkan kembali data yang sudah disimpan
        System.out.println("Data yang berhasil diinput:");
        System.out.println("No \t Nama \t Nilai");
        for (int i = 0; i < 2; i++) {
            System.out.println(dataMahasiswa[i] + " \t " + dataMahasiswa[i][1] + " \t " + dataMahasiswa[i][5]);
            input.close();
        }
    }
}