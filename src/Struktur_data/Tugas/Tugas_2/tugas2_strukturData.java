package Struktur_data.Tugas.Tugas_2;

import java.util.Stack;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class tugas2_strukturData {
    static int[] masterData = { 90, 80, 50, 60, 70, 40, 30, 20, 10, };

    public static void main(String[] args) {
        System.out.println("\n=== TUGAS 1 : STACK (LIFO) ====");
        jalankanStack();
        System.out.println("\n=== TUGAS 2 : QUEUE (FIFO) ====");
        jalankanQueue();
        System.out.println("\n=== TUGAS 3 : QUICK SORT ====");
        jalankanQuickSort();
    }

    public static void jalankanStack() {
        Stack<Integer> stackdata = new Stack<>();
        int[] dataAwal = masterData.clone();
        for (int data : dataAwal) {
            stackdata.push(data);
            System.out.println("push data -> " + data);
        }
        System.out.println("-------------------------------------------------");
        System.out.println("isi data sebelum di POP : " + stackdata);
        for (int i = 0; i < 3; i++) {
            int stackPop = stackdata.pop();
            System.out.println("POP data -> " + stackPop + "\t|sisa data [BAWAH ... ATAS] : " + stackdata);

        }
        System.out.println("-------------------------------------------------");
        System.out.println("isi data setelah di POP : " + stackdata);

    }

    public static void jalankanQueue() {
        Queue<Integer> queueData = new LinkedList<>();
        int[] dataAwal = masterData.clone();
        for (int data : dataAwal) {
            queueData.add(data);
            System.out.println("ADD data -> " + queueData);
        }
        System.out.println("-------------------------------------------------");
        System.out.println("isi data sebelum di Dequeue : " + queueData);
        for (int i = 0; i < 3; i++) {
            int dequeue = queueData.remove();
            System.out.println("Dequeue data -> " + dequeue + "\t|sisa data [DEPAN ... BELAKANG] : " + queueData);
        }
        System.out.println("-------------------------------------------------");
        System.out.println("isi data setelah di Dequeue : " + queueData);

    }

    public static void jalankanQuickSort() {
        int[] data = masterData.clone();
        System.out.println("-------------------------------------------------");
        System.out.println("isi QuickSort sebelum di urutkan : " + Arrays.toString(data));
        quicksort(data, 0, data.length - 1);
        System.out.println("-------------------------------------------------");
        System.out.println("isi QuickSort sebelum di urutkan : " + Arrays.toString(data));
    }

    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndeks = partisi(arr, low, high);

            quicksort(arr, low, pivotIndeks - 1);
            quicksort(arr, pivotIndeks + 1, high);

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
