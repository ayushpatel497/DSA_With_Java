import java.util.*;

public class Q148_DFS_Shortest_Path_In_Directed_Acyclic_Graph {
    public static int[] findShortestPathInDAG(int n, int[][] edges, int source) {
        // Step 1: Create an adjacency list
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Populate adjacency list (edge: {u, v, weight})
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new int[] { edge[1], edge[2] }); // {destination, weight}
        }

        // Step 2: Perform Topological Sort
        boolean[] visited = new boolean[n];
        Stack<Integer> topoStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsTopologicalSort(i, visited, adjList, topoStack);
            }
        }

        // Step 3: Initialize distances
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        // Step 4: Relax edges using topological order
        while (!topoStack.isEmpty()) {
            int node = topoStack.pop();

            if (distances[node] != Integer.MAX_VALUE) {
                for (int[] neighbor : adjList.get(node)) {
                    int dest = neighbor[0];
                    int weight = neighbor[1];
                    if (distances[node] + weight < distances[dest]) {
                        distances[dest] = distances[node] + weight;
                    }
                }
            }
        }

        return distances;
    }

    private static void dfsTopologicalSort(int node, boolean[] visited, ArrayList<ArrayList<int[]>> adjList, Stack<Integer> topoStack) {
        visited[node] = true;

        for (int[] neighbor : adjList.get(node)) {
            if (!visited[neighbor[0]]) {
                dfsTopologicalSort(neighbor[0], visited, adjList, topoStack);
            }
        }

        topoStack.push(node);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of nodes and edges
        System.out.println("Enter the number of nodes and edges:");
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Input edges
        int[][] edges = new int[m][3];
        System.out.println("Enter the edges (start end weight):");
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt(); // Start node
            edges[i][1] = sc.nextInt(); // End node
            edges[i][2] = sc.nextInt(); // Weight
        }

        // Input source node
        System.out.println("Enter the source node:");
        int source = sc.nextInt();

        // Find shortest paths
        int[] shortestPaths = findShortestPathInDAG(n, edges, source);

        // Print results
        System.out.println("Shortest paths from source " + source + ":");
        for (int i = 0; i < shortestPaths.length; i++) {
            System.out.println("To node " + i + ": " + (shortestPaths[i] == Integer.MAX_VALUE ? "Infinity" : shortestPaths[i]));
        }

        sc.close();
    }
}
