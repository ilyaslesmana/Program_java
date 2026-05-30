package Tuton.Tugas_2;

import java.util.Stack;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Queue;

public class sorting_V2 {

    static int[] masterData = { 80, 70, 90, 40, 50, 60, 10, 20, 30 };

    public static void main(String[] args) {

        System.out.println("\n=== TUGAS 1 : STACK (LIFO) ====");
        jalanakanStack();
        System.out.println("\n=== TUGAS 2 : QUEUE (FIFO) ====");
        jalankanQueue();
        System.out.println("\n=== TUGAS 3 : QUICK SORT ===");
        jalankanQuickSort();
    }

    public static void jalanakanStack() {

        Stack<Integer> stackData = new Stack<>();

        System.out.println("proses push data");
        int[] dataMasuk = masterData.clone();
        for (int data : dataMasuk) {
            stackData.push(data);
            System.out.println("Push data -> " + data);
        }
        System.out.println("isi data sebelum di pop : " + stackData);
        int stackPop = stackData.pop();
        for (int i = 0; i < 3; i++) {
            System.out.println("proses pop -> " + stackPop + "\t|sisa data : " + stackData);

        }
    }

    public static void jalankanQueue() {
        Queue<Integer> queueData = new LinkedList<>();
        System.out.println("proses enqueue (memasukan data)");
        int[] queuedData = masterData.clone();

        for (int data : queuedData) {
            queueData.add(data);
            System.out.println("add -> " + queueData);
        }
        System.out.println("================================================");
        System.out.println("isi data sebelum Dequeue : " + queueData);
        int dequeue = queueData.remove();
        for (int i = 0; i < 3; i++) {
            System.out.println(" proses Dequeue -> " + dequeue + " \t|sisa data : " + queueData);
        }
        System.out.println("================================================");

        System.out.println("isi Queue setelah Dequeu : " + queueData);
    }

    public static void jalankanQuickSort() {
        System.out.println("proses Quick Sort");
        int[] sortData = masterData.clone();

        System.out.println("Data sebelum Quick Sort : " + Arrays.toString(sortData));
        quickSort(sortData, 0, sortData.length - 1);
        System.out.println("Data sebelum Quick Sort : " + Arrays.toString(sortData));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndeks = partisi(arr, low, high);

            quickSort(arr, low, pivotIndeks - 1);
            quickSort(arr, pivotIndeks + 1, high);
        }
    }

    public static int partisi(int[] arr, int low, int high) {
        int pivotindeks = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {

            if (arr[j] < pivotindeks) {
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