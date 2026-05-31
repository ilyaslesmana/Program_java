package Struktur_data.Tugas.Tugas_3;

import java.util.Stack;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class latihanGraph {
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

    public static void main(String[] args) {

        int totalNode = 10;
        Graph graf = new Graph(totalNode);

        graf.buatEdge(0, 1);
        graf.buatEdge(0, 2);
        graf.buatEdge(1, 3);
        graf.buatEdge(1, 4);
        graf.buatEdge(2, 5);
        graf.buatEdge(2, 6);
        graf.buatEdge(3, 7);
        graf.buatEdge(4, 8);
        graf.buatEdge(5, 9);

        int startNode = 0;
        int targetNode = 8;

        System.out.println("===============================================");
        System.out.println("1. Algoritma Pencarian DEPTH-FIRST SEARCH");
        System.out.println("===============================================");
        algoritmaDFS(graf, startNode, targetNode);

        System.out.println("===============================================");
        System.out.println("1. Algoritma Pencarian BREATH-FIRST SEARCH");
        System.out.println("===============================================");
        algoritmaBFS(graf, startNode, targetNode);

    }

    public static void algoritmaDFS(Graph graf, int start, int target) {
        boolean[] visited = new boolean[graf.jumlahNode];
        Stack<Integer> stackLifo = new Stack<>();
        stackLifo.push(start);
        System.err.println("\nPUSH root node a" + start + " kedalama Stack");

        while (!stackLifo.isEmpty()) {
            int nodeSekarang = stackLifo.pop();
            System.out.println("\n-> POP node a" + nodeSekarang + " dari atas stack");

            if (!visited[nodeSekarang]) {
                visited[nodeSekarang] = true;
                System.out.println("\n[DFS} Scaning a " + nodeSekarang);

                if (nodeSekarang == target) {
                    System.out.println(">>> DATA DI TEMUKAN node a" + target + " Menggunakan metode DFS <<<");
                    return;
                }

                List<Integer> child = graf.adjencyList.get(nodeSekarang);
                for (int i = child.size() - 1; i >= 0; i--) {
                    int nodechild = child.get(i);
                    if (!visited[nodechild]) {
                        stackLifo.push(nodechild);
                        System.out.println("------> push node child " + nodechild + " kedalam stack");
                    }

                }
            }
        }
    }

    public static void algoritmaBFS(Graph graf, int start, int target) {
        boolean[] visited = new boolean[graf.jumlahNode];
        Queue<Integer> queueFifo = new LinkedList<>();

        queueFifo.add(start);
        visited[start] = true;

        while (!queueFifo.isEmpty()) {
            int nodeSekarang = queueFifo.remove();
            System.out.println("\n-> REMOVE Node a" + nodeSekarang + " dari depan antrean");
            System.out.println("\n[BFS] Scanning node a" + nodeSekarang);

            if (nodeSekarang == target) {
                System.out.println(">>> DATA DITEMUKAN! Node a" + target + " menggunakan metode BFS");
                return;
            }

            // Lo pakai For-Each loop di sini. Smart move!
            for (int nodeChild : graf.adjencyList.get(nodeSekarang)) {
                if (!visited[nodeChild]) {
                    visited[nodeChild] = true;
                    queueFifo.add(nodeChild);
                    System.out.println("----> ADD Node a" + nodeChild + " ke dalam antrean");
                }
            }
        }
    }
}