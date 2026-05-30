package BMP.Modul_3;

import java.util.ArrayList;
import java.util.List;

public class latihanlist2 {
    public static void main(String[] args) {
        List<String> Q = new ArrayList<>();
        Q.add("D");
        Q.add("O");
        Q.add("N");
        Q.add("E");
        System.out.println("list java ");
        for (Object queuelist : Q) {
            System.out.print(queuelist + "->");

        }
    }
}
