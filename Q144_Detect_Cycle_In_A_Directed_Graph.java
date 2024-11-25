import java.util.*;

public class Q144_Detect_Cycle_In_A_Directed_Graph {
    public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
        // Create adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) { // Vertices are 1-indexed
            adjList.add(new ArrayList<>());
        }

        // Populate adjacency list
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adjList.get(u).add(v);
        }

        // Visited and recursion stack arrays
        boolean[] visited = new boolean[n + 1];
        boolean[] recStack = new boolean[n + 1];

        // Check for cycles in each component
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (isCyclic(i, adjList, visited, recStack)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isCyclic(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        // Explore all neighbors
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                if (isCyclic(neighbor, adjList, visited, recStack)) {
                    return true;
                }
            } else if (recStack[neighbor]) {
                // If a neighbor is in the recursion stack, cycle detected
                return true;
            }
        }

        recStack[node] = false; // Remove the node from recursion stack
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of vertices and edges
        System.out.println("Enter number of vertices and edges:");
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

        // Perform cycle detection
        boolean result = detectCycleInDirectedGraph(n, edges);
        System.out.println("Cycle Detection Result: " + (result ? "Yes" : "No"));

        sc.close();
    }
}
