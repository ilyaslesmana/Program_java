package Struktur_data.Tugas.Tugas_3;

import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class percobaan {

    static class Graph {

        int jumlahNode;
        List<List<Integer>> adjencyList;

        public Graph(int node) {
            this.jumlahNode = node;
            adjencyList = new ArrayList<>(node);

            for (int i = 0; i < node; i++) {
                adjencyList.add(new ArrayList<>());
            }
        }

        public void buatEdge(int parent, int child) {
            adjencyList.get(parent).add(child);
        }
    }
}