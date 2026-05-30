package Tuton.Tugas_2; // Mendefinisikan lokasi folder (package) tempat file kode Java ini disimpan

import java.util.Stack; // Mengimpor library Java bawaan untuk menggunakan struktur data Stack (LIFO)
import java.util.Queue; // Mengimpor library antarmuka (interface) Queue (FIFO)
import java.util.LinkedList; // Mengimpor library LinkedList, yang akan digunakan sebagai fondasi struktur Queue
import java.util.Arrays; // Mengimpor library Arrays untuk mempermudah pencetakan array ke layar (console)

public class Tugas_2s { // Mendeklarasikan kelas utama bernama 'tugas2'. Nama file Java harus sama
    // dengan nama kelas ini
    // Membuat array statis bernama masterData berisi kumpulan angka acak. Ini
    // adalah sumber data utama kita
    static int[] masterData = { 50, 40, 60, 10, 20, 30, 80, 90, 70 };

    // Method main adalah titik awal (entry point) program. Program selalu mulai
    // berjalan dari sini

    public static void main(String[] args) {
        System.out.println("\n=== TUGAS 1: STACK (LIFO) ==="); // Mencetak judul untuk bagian Stack ke layar
        jalankanStack(); // Memanggil method jalankanStack() untuk mengeksekusi logika Stack

        System.out.println("\n=== TUGAS 2: QUEUE (FIFO) ==="); // Mencetak baris baru (\\n) dan judul bagian Queue
        jalankanQeueu(); // Memanggil method jalankanQeueu() untuk mengeksekusi logika Queue

        System.out.println("\n=== TUGAS 3: QUICK SORT ==="); // Mencetak baris baru (\\n) dan judul bagian Quick Sort
        jalankanQuickSort(); // Memanggil method jalankanQuickSort() untuk mengeksekusi logika pengurutan
    }

    // Method untuk mendemonstrasikan cara kerja Stack (Last In, First Out)
    public static void jalankanStack() {
        Stack<Integer> stackData = new Stack<>(); // Membuat objek Stack kosong yang hanya bisa diisi oleh angka
                                                  // (Integer)
        int[] dataAwal = masterData.clone(); // Menyalin (clone) isi masterData agar array aslinya tidak berubah/rusak
        // Melakukan perulangan (for-each) untuk mengambil setiap angka dari dataAwal
        // satu per satu
        for (int data : dataAwal) {
            stackData.push(data); // Memasukkan angka ke tumpukan paling atas (push)
            System.out.println("push data -> " + data); // Mencetak proses memasukkan data ke layar
        } // Menutup blok perulangan for

        System.out.println("--------------------------------------------------------");
        System.out.println("isi data sebelum di pop : " + stackData); // Mencetak seluruh isi Stack setelah semua data
                                                                      // masuk

        // Melakukan perulangan sebanyak 3 kali (dari i=0 sampai i=2)
        for (int i = 0; i < 3; i++) {
            int stackPoop = stackData.pop(); // Mengeluarkan data dari tumpukan PALING ATAS (pop) dan menyimpannya di
                                             // variabel stackPoop
            // Mencetak data yang baru saja dikeluarkan, dan menampilkan sisa tumpukan saat
            // ini
            System.out.println("pop data -> " + stackPoop + "\t|sisa data [bawah ... atas] : " + stackData);
        } // Menutup blok perulangan for
    } // Menutup blok method jalankanStack

    // Method untuk mendemonstrasikan cara kerja Queue (First In, First Out)
    public static void jalankanQeueu() {
        Queue<Integer> queueData = new LinkedList<>(); // Membuat objek Queue kosong menggunakan basis LinkedList
        System.out.println("--------------------------------------------------------");
        System.out.println("proses add data"); // Mencetak teks informasi ke layar
        int[] dataAwal = masterData.clone(); // Menyalin masterData lagi untuk digunakan di method ini

        // Melakukan perulangan (for-each) untuk setiap angka di dalam dataAwal
        for (int data : dataAwal) {
            queueData.add(data); // Memasukkan angka ke posisi paling belakang antrean (add)
            System.out.println("add data -> " + data); // Mencetak angka yang baru saja masuk antrean
        } // Menutup blok perulangan for

        System.out.println("--------------------------------------------------------");
        System.out.println("isi data sebelum di Dequeue : " + queueData); // Mencetak wujud antrean penuh sebelum ada
                                                                          // yang dikeluarkan

        // Melakukan perulangan sebanyak 3 kali
        for (int i = 0; i < 3; i++) {
            int dequeue = queueData.remove(); // Mengeluarkan data dari posisi PALING DEPAN antrean (remove/dequeue)
            // Mencetak data yang keluar, dan menunjukkan sisa antrean di belakangnya
            System.out.println("dequeue data -> " + dequeue + "\t|sisa data [depan ... belakang] : " + queueData);
        } // Menutup blok perulangan for

        System.out.println("--------------------------------------------------------");
        System.out.println("isi data setelah di Dequeue : " + queueData); // Mencetak kondisi akhir antrean
    } // Menutup blok method jalankanQeueu

    // Method untuk menyiapkan dan memanggil proses algoritma Quick Sort
    public static void jalankanQuickSort() {
        int[] data = masterData.clone(); // Menyalin masterData agar kita punya array acak untuk diurutkan
        // Mengubah array menjadi teks (Arrays.toString) agar bisa dicetak dan dilihat
        // kondisi acaknya
        System.out.println("--------------------------------------------------------");
        System.out.println("isi QuickSort sebelum diubah : " + Arrays.toString(data));

        // Memanggil method utama quickSort, memasukkan array-nya, index paling awal
        // (0), dan index paling akhir (panjang array dikurangi 1)
        quickSort(data, 0, data.length - 1);

        // Mencetak hasil akhir array yang sudah terurut (catatan: teks aslinya tertulis
        // 'sebelum', tapi ini menampilkan hasil 'setelah' diubah)
        System.out.println("--------------------------------------------------------");
        System.out.println("isi QuickSort sebelum diubah : " + Arrays.toString(data));
    } // Menutup blok method jalankanQuickSort

    // Fungsi rekursif (memanggil dirinya sendiri) untuk memecah array menjadi
    // bagian-bagian kecil
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) { // Syarat rekursif: selama index batas bawah masih lebih kecil dari batas atas
                          // (artinya ada lebih dari 1 elemen)

            // Memanggil method pastisi untuk menata elemen dan mendapatkan titik pisah
            // (pivot) yang posisinya sudah benar
            int pivotIndkeks = pastisi(arr, low, high);

            // Memanggil method ini sendiri (rekursif) untuk mengurutkan setengah bagian
            // KIRI dari pivot
            quickSort(arr, low, pivotIndkeks - 1);

            // Memanggil method ini sendiri (rekursif) untuk mengurutkan setengah bagian
            // KANAN dari pivot
            quickSort(arr, pivotIndkeks + 1, high);
        } // Menutup blok kondisi if
    } // Menutup blok method quickSort

    // Fungsi untuk menata ulang (mempartisi) elemen array agar yang kecil di kiri
    // pivot, dan yang besar di kanan pivot
    public static int pastisi(int[] arr, int low, int high) {
        int pivot = arr[high]; // Mengambil elemen di ujung paling kanan sebagai patokan (pivot) pembanding
        int i = (low - 1); // Membuat variabel 'i' sebagai penanda batas akhir kelompok angka yang lebih
                           // kecil dari pivot

        // Memulai perulangan dari index paling kiri (low) sampai tepat sebelum pivot
        // (high - 1)
        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) { // Mengecek apakah angka yang sedang dievaluasi (arr[j]) lebih kecil dari pivot
                i++; // Jika iya, geser batas kelompok angka kecil ke kanan satu langkah

                // PROSES TUKAR POSISI (SWAP): Menukar angka kecil yang baru ditemukan (arr[j])
                // ke dalam wilayah kelompok angka kecil (arr[i])
                int temp = arr[i]; // Menyimpan nilai arr[i] sementara ke dalam variabel temp agar tidak hilang
                arr[i] = arr[j]; // Mengisi posisi arr[i] dengan nilai arr[j] (angka yang lebih kecil)
                arr[j] = temp; // Mengisi posisi arr[j] dengan nilai asli arr[i] yang tadi disimpan di temp
            } // Menutup blok kondisi if
        } // Menutup blok perulangan for

        // SWAP FINAL: Setelah perulangan selesai, pindahkan letak pivot (arr[high]) ke
        // batas antara kelompok kecil dan kelompok besar
        int temp = arr[i + 1]; // Menyimpan elemen pertama dari kelompok angka besar ke variabel temp
        arr[i + 1] = arr[high]; // Menempatkan pivot di antara kelompok kecil dan besar (posisinya sudah akurat
                                // dan final)
        arr[high] = temp; // Meletakkan angka besar yang tadi digeser ke ujung paling kanan (tempat asal
                          // pivot)

        return i + 1; // Mengembalikan posisi index pivot yang baru agar bisa digunakan oleh method
                      // quickSort untuk membelah array lagi
    } // Menutup blok method pastisi
} // Menutup blok kelas tugas2