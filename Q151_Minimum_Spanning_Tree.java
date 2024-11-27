import java.util.*;

public class Q151_Minimum_Spanning_Tree {

    // Helper class to represent edges
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        // Compare edges based on their weight
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    // Helper class for Disjoint Set Union (Union-Find)
    static class DisjointSet {
        int[] parent, rank;

        DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]); // Path compression
            }
            return parent[node];
        }

        void union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            if (rootU != rootV) {
                if (rank[rootU] < rank[rootV]) {
                    parent[rootU] = rootV;
                } else if (rank[rootU] > rank[rootV]) {
                    parent[rootV] = rootU;
                } else {
                    parent[rootV] = rootU;
                    rank[rootU]++;
                }
            }
        }
    }

    public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
        // Convert edges into a list of Edge objects
        ArrayList<Edge> edgeList = new ArrayList<>();
        for (ArrayList<Integer> edge : edges) {
            edgeList.add(new Edge(edge.get(0), edge.get(1), edge.get(2)));
        }

        // Sort edges by weight
        Collections.sort(edgeList);

        // Initialize Disjoint Set for cycle detection
        DisjointSet dsu = new DisjointSet(n);

        int mstWeight = 0;
        int mstEdges = 0;

        // Kruskal's algorithm: Iterate through sorted edges
        for (Edge edge : edgeList) {
            int u = edge.src;
            int v = edge.dest;

            // Check if adding this edge creates a cycle
            if (dsu.find(u) != dsu.find(v)) {
                dsu.union(u, v); // Merge the sets
                mstWeight += edge.weight; // Add weight to MST
                mstEdges++;
            }

            // If we have already included (n-1) edges, stop
            if (mstEdges == n - 1) break;
        }

        return mstWeight;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of vertices and edges
        System.out.println("Enter number of vertices:");
        int n = sc.nextInt();
        System.out.println("Enter number of edges:");
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

        System.out.println("Enter edges in the format: src dest weight");
        for (int i = 0; i < m; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            ArrayList<Integer> edge = new ArrayList<>();
            edge.add(src);
            edge.add(dest);
            edge.add(weight);
            edges.add(edge);
        }

        // Calculate MST weight
        int mstWeight = minimumSpanningTree(edges, n);
        System.out.println("Total weight of Minimum Spanning Tree: " + mstWeight);

        sc.close();
    }
}
