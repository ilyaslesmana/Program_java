package Tuton.Tugas_2;

import java.util.Stack; // Untuk Stack
import java.util.LinkedList; // Untuk implementasi Queue
import java.util.Queue; // Untuk Interface Queue
import java.util.Arrays; // Untuk mencetak Array

public class TugasStrukturData {

    public static void main(String[] args) {
        System.out.println("=== 1. IMPLEMENTASI STACK (LIFO) ===");
        jalankanStack();

        System.out.println("\n=== 2. IMPLEMENTASI QUEUE (FIFO) ===");
        jalankanQueue();

        System.out.println("\n=== 3. IMPLEMENTASI QUICK SORT ===");
        jalankanQuickSort();
    }

    // --- BAGIAN 1: STACK ---
    public static void jalankanStack() {
        // Menggunakan Integer (Wrapper Class), bukan int
        Stack<Integer> tumpukan = new Stack<>();
        int[] dataInput = { 10, 20, 30, 40, 50, 60, 70, 80 };

        System.out.println("Proses Push:");
        for (int nilai : dataInput) {
            tumpukan.push(nilai);
            System.out.println("Push: " + nilai);
        }

        System.out.println("Isi Stack SEBELUM Pop: " + tumpukan);

        // Pop mengambil data terakhir yang masuk (80)
        int dataKeluar = tumpukan.pop();
        System.out.println("Proses Pop: " + dataKeluar);

        System.out.println("Isi Stack SESUDAH Pop: " + tumpukan);
    }

    // --- BAGIAN 2: QUEUE ---
    public static void jalankanQueue() {
        // Menggunakan Integer, dan LinkedList sebagai implementasi Queue
        Queue<Integer> antrean = new LinkedList<>();
        int[] dataInput = { 11, 22, 33, 44, 55, 66, 77, 88 };

        System.out.println("Proses Enqueue:");
        for (int nilai : dataInput) {
            antrean.add(nilai);
            System.out.println("Enqueue: " + nilai);
        }

        System.out.println("Isi Queue SEBELUM Dequeue: " + antrean);

        // Dequeue mengambil data pertama yang masuk (11)
        int dataKeluar = antrean.poll();
        System.out.println("Proses Dequeue: " + dataKeluar);

        System.out.println("Isi Queue SESUDAH Dequeue: " + antrean);
    }

    // --- BAGIAN 3: QUICK SORT ---
    public static void jalankanQuickSort() {
        int[] angka = { 42, 15, 88, 63, 21, 57, 95, 34 };

        System.out.println("Data SEBELUM diurutkan: " + Arrays.toString(angka));

        perulanganQuickSort(angka, 0, angka.length - 1);

        System.out.println("Data SESUDAH diurutkan: " + Arrays.toString(angka));
    }

    public static void perulanganQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partisi(arr, low, high);
            perulanganQuickSort(arr, low, pi - 1);
            perulanganQuickSort(arr, pi + 1, high);
        }
    }

    public static int partisi(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
