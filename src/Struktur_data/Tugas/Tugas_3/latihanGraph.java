package Struktur_data.Tugas.Tugas_3;

// Import library struktur data yang dibutuhin dari Java Collections
import java.util.Stack;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class latihanGraph {

    // Inner class untuk mendefinisikan struktur Graph itu sendiri
    static class Graph {
        int jumlahNode; // Menyimpan total titik (node/vertex) di dalam graf
        List<List<Integer>> adjencyList; // Menggunakan Adjacency List untuk menyimpan koneksi antar node. Ini sangat
                                         // efisien secara memori dibanding Adjacency Matrix.

        // Constructor untuk inisialisasi awal saat objek Graph dibuat
        public Graph(int node) {
            this.jumlahNode = node;
            adjencyList = new ArrayList<>(node); // Bikin list utama sebesar jumlah node

            // Looping untuk bikin list kosong di setiap node, siap diisi koneksi (edge)
            for (int i = 0; i < node; i++) {
                adjencyList.add(new ArrayList<>());
            }
        }

        // Fungsi untuk menghubungkan dua node (bikin garis koneksi searah)
        public void buatEdge(int parent, int child) {
            adjencyList.get(parent).add(child); // Nambahin node 'child' ke dalam list milik node 'parent'
        }
    }

    public static void main(String[] args) {

        int totalNode = 10; // Setup total node yang mau dibikin (Node 0 sampai 9)
        Graph graf = new Graph(totalNode); // Instansiasi objek graf

        // Mapping jalur / relasi antar node (Membangun topologi graf)
        graf.buatEdge(0, 1);
        graf.buatEdge(0, 2);
        graf.buatEdge(1, 3);
        graf.buatEdge(1, 4);
        graf.buatEdge(2, 5);
        graf.buatEdge(2, 6);
        graf.buatEdge(3, 7);
        graf.buatEdge(4, 8);
        graf.buatEdge(5, 9);

        int startNode = 0; // Titik awal pencarian
        int targetNode = 8; // Data/titik yang mau dicari

        // Eksekusi dan UI Console untuk DFS
        System.out.println("===============================================");
        System.out.println("1. Algoritma Pencarian DEPTH-FIRST SEARCH");
        System.out.println("===============================================");
        algoritmaDFS(graf, startNode, targetNode);

        // Eksekusi dan UI Console untuk BFS
        System.out.println("===============================================");
        System.out.println("2. Algoritma Pencarian BREATH-FIRST SEARCH");
        System.out.println("===============================================");
        algoritmaBFS(graf, startNode, targetNode);
    }

    // ==========================================
    // FUNGSI DFS (Pencarian Mendalam)
    // ==========================================
    public static void algoritmaDFS(Graph graf, int start, int target) {
        // Array boolean untuk melacak node mana aja yang udah pernah dikunjungi biar
        // nggak looping tak hingga
        boolean[] visited = new boolean[graf.jumlahNode];

        // Stack beroperasi dengan prinsip LIFO (Last In, First Out)
        Stack<Integer> stackLifo = new Stack<>();

        stackLifo.push(start); // Masukin node awal ke tumpukan paling atas
        System.err.println("\nPUSH root node a" + start + " kedalam Stack");

        // Terus berjalan selama tumpukan (Stack) belum kosong
        while (!stackLifo.isEmpty()) {
            int nodeSekarang = stackLifo.pop(); // Ambil node paling atas dari stack
            System.out.println("\n-> POP node a" + nodeSekarang + " dari atas stack");

            // Cek apakah node ini belum pernah dikunjungi
            if (!visited[nodeSekarang]) {
                visited[nodeSekarang] = true; // Tandai node ini udah dikunjungi
                System.out.println("\n[DFS] Scanning a " + nodeSekarang);

                // Kondisi Berhenti: Kalau node saat ini adalah target yang dicari
                if (nodeSekarang == target) {
                    System.out.println(">>> DATA DITEMUKAN node a" + target + " Menggunakan metode DFS <<<");
                    return; // Langsung keluar dari fungsi, menghemat resource komputasi
                }

                // Ambil semua anak/koneksi dari node yang sedang dicek
                List<Integer> child = graf.adjencyList.get(nodeSekarang);

                // Looping mundur (dari kanan ke kiri) untuk masukin ke stack.
                // Karena sifat LIFO, yang dimasukin terakhir (anak kiri) akan diproses duluan.
                for (int i = child.size() - 1; i >= 0; i--) {
                    int nodechild = child.get(i);
                    if (!visited[nodechild]) { // Hanya masukin ke stack kalau anak ini belum pernah dikunjungi
                        stackLifo.push(nodechild);
                        System.out.println("------> push node child " + nodechild + " kedalam stack");
                    }
                }
            }
        }
    }

    // ==========================================
    // FUNGSI BFS (Pencarian Melebar)
    // ==========================================
    public static void algoritmaBFS(Graph graf, int start, int target) {
        // Tracker untuk node yang sudah diproses
        boolean[] visited = new boolean[graf.jumlahNode];

        // Queue beroperasi dengan prinsip FIFO (First In, First Out), kayak antrean di
        // kasir
        Queue<Integer> queueFifo = new LinkedList<>();

        queueFifo.add(start); // Masukin node awal ke antrean
        visited[start] = true; // Langsung tandai sebagai visited saat masuk antrean

        // Terus berjalan selama antrean belum kosong
        while (!queueFifo.isEmpty()) {
            int nodeSekarang = queueFifo.remove(); // Ambil node paling depan dari antrean
            System.out.println("\n-> REMOVE Node a" + nodeSekarang + " dari depan antrean");
            System.out.println("\n[BFS] Scanning node a" + nodeSekarang);

            // Kondisi Berhenti: Cek apakah ini targetnya
            if (nodeSekarang == target) {
                System.out.println(">>> DATA DITEMUKAN! Node a" + target + " menggunakan metode BFS");
                return;
            }

            // Lo pakai For-Each loop di sini. Smart move! Kode jadi lebih *clean*.
            // Cek semua anak/tetangga dari node saat ini
            for (int nodeChild : graf.adjencyList.get(nodeSekarang)) {
                if (!visited[nodeChild]) { // Kalau belum dikunjungi
                    visited[nodeChild] = true; // Tandai sudah dikunjungi
                    queueFifo.add(nodeChild); // Masukin ke antrean paling belakang
                    System.out.println("----> ADD Node a" + nodeChild + " ke dalam antrean");
                }
            }
        }
    }
}