package Struktur_data.Tugas.Tugas_3;

import java.util.Iterator;
import java.util.LinkedList;

// 1. Deklarasi Class (PascalCase)
class LatihanDFS {

    // 2. Variabel Global (Private, di paling atas)
    private int jumlahNode;
    private LinkedList<Integer> adj[];

    // 3. Constructor (Inisialisasi sistem)
    LatihanDFS(int node) {
        jumlahNode = node;
        adj = new LinkedList[node];
        for (int i = 0; i < node; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // 4. Method Public / API (Fungsi yang diakses user luar)
    void addEdge(int node, int nilaiEdge) {
        adj[node].add(nilaiEdge);
        System.err.println("add node -> " + node + "\t| add edge -> " + nilaiEdge);
    }

    // Fungsi utama pencarian yang dipanggil user
    void DFS(int node) {
        boolean visited[] = new boolean[jumlahNode];
        DFSutil(node, visited);
    }

    // 5. Method Helper / Mesin Core (Disembunyikan di bawah)
    void DFSutil(int node, boolean visited[]) {
        visited[node] = true;
        System.out.println("visit node -> " + node + " ");

        Iterator<Integer> i = adj[node].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSutil(n, visited);
            }
        }
    }

    // 6. Main Method (Ruang testing, ditaruh di paling bawah)
    public static void main(String[] args) {
        LatihanDFS g = new LatihanDFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("\nDFS dengan vertex awal 2:");
        g.DFS(2);
    }
}