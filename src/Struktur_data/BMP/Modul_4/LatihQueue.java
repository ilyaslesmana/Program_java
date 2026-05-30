package Struktur_data.BMP.Modul_4;

import java.util.ArrayList;
import java.util.List;

public class LatihQueue {
    public static void main(String[] args) {
        List<String> Q = new ArrayList<>();
        Q.add("D");
        Q.add("o");
        Q.add("n");
        Q.add("e");
        Q.remove(1);
        System.out.println("list java");
        for (Object QueueList : Q) {
            System.out.print(QueueList + "-> ");

        }

    }
}
