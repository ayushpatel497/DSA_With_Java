import java.util.*;

public class Q143_Cycle_Detection_In_Undirected_Graph {
    public static String cycleDetection(int[][] edges, int n, int m) {
        // Create an adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) { // Vertices are 1-indexed
            adjList.add(new ArrayList<>());
        }

        // Populate adjacency list
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u); // Since it's undirected
        }

        // Visited array
        boolean[] visited = new boolean[n + 1];

        // Check for cycles in each connected component
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (hasCycle(i, -1, visited, adjList)) {
                    return "Yes";
                }
            }
        }

        return "No";
    }

    private static boolean hasCycle(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adjList) {
        visited[node] = true;

        // Explore all neighbors
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                // Recursive DFS call
                if (hasCycle(neighbor, node, visited, adjList)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // If the neighbor is visited and not the parent, there's a cycle
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of vertices and edges
        System.out.println("Enter number of vertices and edges:");
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Input edges
        int[][] edges = new int[m][2];
        System.out.println("Enter the edges:");
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        // Perform cycle detection
        String result = cycleDetection(edges, n, m);
        System.out.println("Cycle Detection Result: " + result);

        sc.close();
    }
}
