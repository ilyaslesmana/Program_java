package Struktur_data.Tugas.Tugas_3;

import java.util.Iterator;
import java.util.LinkedList;

// 1. Deklarasi Class (PascalCase)
class LatihanDFS {

    // 2. Variabel Global (Private, di paling atas)
    private int jumlahNode;
    private LinkedList<Integer> adj[];

    // 3. Constructor (Inisialisasi sistem)
    LatihanDFS(int vertex) {
        jumlahNode = vertex;
        adj = new LinkedList[vertex];
        for (int i = 0; i < vertex; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // 4. Method Public / API (Fungsi yang diakses user luar)
    void addEdge(int vertex, int nilaiEdge) {
        adj[vertex].add(nilaiEdge);
        System.err.println("add vertex -> " + vertex + "\t| add edge -> " + nilaiEdge);
    }

    // Fungsi utama pencarian yang dipanggil user
    void DFS(int vertex) {
        boolean visited[] = new boolean[jumlahNode];
        DFSutil(vertex, visited);
    }

    // 5. Method Helper / Mesin Core (Disembunyikan di bawah)
    void DFSutil(int vertex, boolean visited[]) {
        visited[vertex] = true;
        System.out.println("visit vertex -> " + vertex + " ");

        Iterator<Integer> i = adj[vertex].listIterator();
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