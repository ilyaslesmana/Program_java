package Tuton.Tugas_2;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
import java.util.Arrays;

public class sorting {
    public static void main(String[] args) {

        int[] dataAwal = { 10, 12, 16, 13, 18, 19, 20, 14, 17, 15 };

        System.out.println("============================================");
        System.out.println("1 Stack [LIFO] (Last In Firts Out) ");
        System.out.println("============================================");

        Stack<Integer> stackData = new Stack<>();
        for (int data : dataAwal) {
            stackData.push(data);
        }
        ;
        System.out.println("Isi Stack sebelum proses [POP] :" + stackData);
        for (int i = 0; i < 3; i++) {
            int stackPop = stackData.pop();
            System.out.println("-> POP data : " + stackPop + "\t| Sisa Stack [bawah ... Atas] : " + stackData);
        }
        ;
        System.out.println("Isi data setelah proses POP : " + stackData);

        System.out.println("============================================");
        System.out.println("2 Queue [FIFO] (Firts In Firts Out) ");
        System.out.println("============================================");

        Queue<Integer> queueData = new LinkedList<>();
        for (int data : dataAwal) {
            queueData.add(data);
        }
        ;
        System.out.println("Isi Queue sebelum proses [REMOVE] :" + queueData);
        for (int i = 0; i < 3; i++) {
            int queueRemove = queueData.remove();
            System.out
                    .println(" -> REMOVE Data : " + queueRemove + "\t| Sisa Queue [Depan ... Belakang] : " + queueData);
        }
        System.out.println("= Isi Queue setelah proses [REMOVE] : " + queueData);

        System.out.println("============================================");
        System.out.println("3 Quick Sort (Ascending) ");
        System.out.println("============================================");

        System.out.println(" Data sebelum di urutkan : " + Arrays.toString(dataAwal));
        quicksort(dataAwal, 0, dataAwal.length - 1);
        System.out.println(" Data sesudah di urutkan : " + Arrays.toString(dataAwal));
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
            if (arr[j] <= pivot) {
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
