import java.util.*;

public class Q147_Shortest_Path_In_An_Unweighted_Graph {

    public static LinkedList<Integer> shortestPath(int[][] edges, int n, int m, int s, int t) {
        // Step 1: Create an adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Step 2: Populate adjacency list
        for (int[] edge : edges) {
            int u = edge[0] - 1; // Convert to 0-based index
            int v = edge[1] - 1; // Convert to 0-based index
            adjList.get(u).add(v);
            adjList.get(v).add(u); // Since the graph is undirected
        }

        // Step 3: Perform BFS
        int[] parent = new int[n]; // To store the parent of each node for path reconstruction
        Arrays.fill(parent, -1);
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        s--; t--; // Convert source and destination to 0-based index
        queue.add(s);
        visited[s] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // Stop BFS if we reach the target
            if (current == t) {
                break;
            }

            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = current; // Track the parent
                    queue.add(neighbor);
                }
            }
        }

        // Step 4: Reconstruct the shortest path
        LinkedList<Integer> path = new LinkedList<>();
        for (int v = t; v != -1; v = parent[v]) {
            path.addFirst(v + 1); // Convert back to 1-based index
        }

        // If the start node is not part of the path, return an empty list (no path exists)
        if (path.getFirst() != s + 1) {
            return new LinkedList<>();
        }

        return path;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of houses (nodes) and roads (edges)
        System.out.println("Enter the number of houses and roads:");
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Input edges
        int[][] edges = new int[m][2];
        System.out.println("Enter the roads (pairs of connected houses):");
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        // Input source and destination
        System.out.println("Enter the source and destination houses:");
        int s = sc.nextInt();
        int t = sc.nextInt();

        // Find and print the shortest path
        LinkedList<Integer> shortestPath = shortestPath(edges, n, m, s, t);
        System.out.println("Shortest Path:");
        for (int house : shortestPath) {
            System.out.print(house + " ");
        }

        sc.close();
    }
}
