import java.util.*;

public class Q146_Detect_Cycle_In_A_Directed_Graph {
    public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
        // Step 1: Create the adjacency list and in-degree array
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] inDegree = new int[n];
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0) - 1; // Convert to 0-based index
            int v = edge.get(1) - 1; // Convert to 0-based index
            adjList.get(u).add(v);
            inDegree[v]++;
        }

        // Step 2: Initialize queue with nodes having in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 3: Perform BFS (Kahn's Algorithm)
        int processedNodes = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            processedNodes++;

            for (int neighbor : adjList.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Step 4: Check for cycle
        return processedNodes != n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of vertices and edges
        System.out.println("Enter the number of vertices and edges:");
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Input edges
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        System.out.println("Enter the edges:");
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> edge = new ArrayList<>();
            edge.add(sc.nextInt());
            edge.add(sc.nextInt());
            edges.add(edge);
        }

        // Detect cycle
        boolean hasCycle = detectCycleInDirectedGraph(n, edges);
        System.out.println("Cycle Detected: " + hasCycle);

        sc.close();
    }
}
