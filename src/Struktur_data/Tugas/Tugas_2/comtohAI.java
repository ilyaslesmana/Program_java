package Tuton.Tugas_2;

import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class comtohAI {

    public static void main(String[] args) {
        System.out.println("=== TUGAS 1: STACK (LIFO) ===");
        jalankanStack();

        System.out.println("\n=== TUGAS 2: QUEUE (FIFO) ===");
        jalankanQueue();

        System.out.println("\n=== TUGAS 3: QUICK SORT ===");
        jalankanQuickSort();
    }

    // ==========================================
    // 1. METODE UNTUK STACK (LIFO)
    // ==========================================
    public static void jalankanStack() {
        // Membuat objek Stack yang menyimpan tipe data Integer
        Stack<Integer> tumpukanData = new Stack<>();

        // Proses PUSH: Memasukkan 8 data integer ke dalam Stack
        System.out.println("Proses Push (Memasukkan data):");
        int[] dataMasuk = { 10, 20, 30, 40, 50, 60, 70, 80 };
        for (int data : dataMasuk) {
            tumpukanData.push(data); // Fungsi push() untuk menambah data di posisi paling atas
            System.out.println("Push: " + data);
        }

        // Menampilkan isi Stack SEBELUM proses Pop
        System.out.println("\nIsi Stack sebelum Pop: " + tumpukanData);

        // Proses POP: Mengeluarkan 3 data teratas dari Stack
        System.out.println("\nProses Pop (Mengeluarkan data teratas):");
        System.out.println("Pop 1: " + tumpukanData.pop()); // pop() mengambil dan menghapus elemen teratas
        System.out.println("Pop 2: " + tumpukanData.pop());
        System.out.println("Pop 3: " + tumpukanData.pop());

        // Menampilkan isi Stack SESUDAH proses Pop
        System.out.println("\nIsi Stack sesudah Pop: " + tumpukanData);
    }

    // ==========================================
    // 2. METODE UNTUK QUEUE (FIFO)
    // ==========================================
    public static void jalankanQueue() {
        // Membuat objek Queue menggunakan LinkedList (karena Queue adalah interface di
        // Java)
        Queue<Integer> antreanData = new LinkedList<>();

        // Proses ENQUEUE: Memasukkan 8 data integer ke dalam Queue
        System.out.println("Proses Enqueue (Memasukkan data ke antrean):");
        int[] dataAntre = { 11, 22, 33, 44, 55, 66, 77, 88 };
        for (int data : dataAntre) {
            antreanData.add(data); // Fungsi add() untuk menambah data di posisi paling belakang antrean
            System.out.println("Enqueue: " + data);
        }

        // Menampilkan isi Queue SEBELUM proses Dequeue
        System.out.println("\nIsi Queue sebelum Dequeue: " + antreanData);

        // Proses DEQUEUE: Mengeluarkan 3 data terdepan dari Queue
        System.out.println("\nProses Dequeue (Mengeluarkan data terdepan):");
        System.out.println("Dequeue 1: " + antreanData.poll()); // poll() mengambil dan menghapus elemen paling depan
        System.out.println("Dequeue 2: " + antreanData.poll());
        System.out.println("Dequeue 3: " + antreanData.poll());

        // Menampilkan isi Queue SESUDAH proses Dequeue
        System.out.println("\nIsi Queue sesudah Dequeue: " + antreanData);
    }

    // ==========================================
    // 3. METODE UNTUK QUICK SORT
    // ==========================================
    public static void jalankanQuickSort() {
        // Inisialisasi minimal 8 data integer acak
        int[] dataAcak = { 45, 12, 78, 34, 89, 23, 56, 1 };

        // Menampilkan data SEBELUM diurutkan
        System.out.println("Data sebelum Quick Sort: " + Arrays.toString(dataAcak));

        // Memanggil fungsi quickSort, parameter: array, index awal (0), index akhir
        // (panjang array - 1)
        quickSort(dataAcak, 0, dataAcak.length - 1);

        // Menampilkan data SESUDAH diurutkan
        System.out.println("Data sesudah Quick Sort: " + Arrays.toString(dataAcak));
    }

    // Fungsi rekursif untuk algoritma Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Mencari index partisi, elemen di posisi ini sudah berada di tempat yang benar
            int pivotIndeks = partisi(arr, low, high);

            // Mengurutkan elemen di kiri partisi secara rekursif
            quickSort(arr, low, pivotIndeks - 1);
            // Mengurutkan elemen di kanan partisi secara rekursif
            quickSort(arr, pivotIndeks + 1, high);
        }
    }

    // Fungsi untuk mempartisi array berdasarkan pivot (menggunakan elemen terakhir
    // sebagai pivot)
    public static int partisi(int[] arr, int low, int high) {
        int pivot = arr[high]; // Menentukan elemen terakhir sebagai pivot
        int i = (low - 1); // Index untuk elemen yang lebih kecil

        // Looping untuk membandingkan setiap elemen dengan pivot
        for (int j = low; j < high; j++) {
            // Jika elemen saat ini lebih kecil dari pivot
            if (arr[j] < pivot) {
                i++; // Pindahkan index elemen yang lebih kecil

                // Proses Swap (Tukar posisi) arr[i] dengan arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap pivot dengan elemen pada posisi i+1 agar pivot berada di tengah
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Mengembalikan index posisi pivot yang baru
    }
}