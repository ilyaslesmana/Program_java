package Tuton.Tugas_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class latihan {
    public static void main(String[] args) {
        int[] dataAwal = { 12, 10, 13, 16, 18, 19, 17, 21, 24, 25, 30 };

        System.out.println("========================================");
        System.out.println("1 Stack LIFO (Last In First Out)");
        System.out.println("========================================");

        Stack<Integer> stackdata = new Stack<>();
        for (int data : dataAwal) {
            stackdata.push(data);
        }

        System.out.println("isi stack sebelum di pop" + stackdata);
        for (int i = 0; i < 3; i++) {
            int stackpop = stackdata.pop();

            System.out.println("-> isi data : " + stackpop + "\t|sisa data [bawah ... atas] : " + stackdata);

        }
        System.out.println("isi stack sesudah di pop : " + stackdata);

        System.out.println("========================================");
        System.out.println("2 QUEUE FIFO (First In First Out)");
        System.out.println("========================================");

        Queue<Integer> queueData = new LinkedList<>();
        for (int data : dataAwal) {
            queueData.add(data);
        }

    }
}
