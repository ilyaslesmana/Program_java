package Struktur_data.BMP.Modul_4;

public class MergeSort {
    // Fungsi untuk menggabungkan dua subarray (halaman 6.22)
    void merge(int arr[], int l, int m, int r) {
        // Menghitung ukuran dua subarray yang akan digabungkan (halaman 6.23)
        int n1 = m - l + 1;
        int n2 = r - m;

        // Membuat array sementara (halaman 6.23)
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Menyalin data ke array sementara L[] dan R[] (halaman 6.23)
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Indeks awal untuk subarray pertama, kedua, dan array gabungan (halaman
        // 6.23-6.24)
        int i = 0, j = 0;
        int k = l;

        // Proses penggabungan kembali ke arr[l..r] (halaman 6.24)
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Menyalin sisa elemen L[] jika ada (halaman 6.25)
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Menyalin sisa elemen R[] jika ada (halaman 6.25)
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Fungsi utama yang menjalankan sorting secara rekursif (halaman 6.26)
    void sort(int arr[], int l, int r) {
        if (l < r) {
            // Mencari titik tengah (halaman 6.26)
            int m = (l + r) / 2;

            // Mengurutkan bagian pertama dan kedua (halaman 6.26)
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Menggabungkan bagian yang telah urut (halaman 6.26)
            merge(arr, l, m, r);
        }
    }

    // Fungsi untuk mencetak isi array (halaman 6.27)
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Main method untuk menjalankan program (halaman 6.27)
    public static void main(String args[]) {
        int arr[] = { 2, 11, 3, 5, 6, 7 };

        System.out.println("Given Array:");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array:");
        printArray(arr);
    }
}
/*
 * Penjelasan Singkat Alur Kode:
 * merge(): Bertanggung jawab menggabungkan dua potongan array yang sudah
 * terurut menjadi satu kesatuan yang utuh dan urut.
 * 
 * sort(): Menggunakan rekursi untuk terus membagi array menjadi dua bagian
 * sampai ukurannya menjadi 1 (dianggap sudah urut), kemudian memanggil fungsi
 * merge.
 * 
 * main(): Tempat kita mendefinisikan data awal (array arr) dan memanggil objek
 * MergeSort untuk melakukan pengurutan.
 */