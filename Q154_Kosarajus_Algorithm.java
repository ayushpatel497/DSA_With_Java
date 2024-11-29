import java.util.*;

public class Q154_Kosarajus_Algorithm {
    
    public static int stronglyConnectedComponents(int v, ArrayList<ArrayList<Integer>> edges) {
        // Step 1: Build the adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<ArrayList<Integer>> transposedGraph = new ArrayList<>();
        
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
            transposedGraph.add(new ArrayList<>());
        }
        
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int w = edge.get(1);
            graph.get(u).add(w);
        }

        // Step 2: Perform Topological Sort using DFS
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                topologicalSortDFS(i, graph, visited, stack);
            }
        }

        // Step 3: Transpose the graph
        for (int i = 0; i < v; i++) {
            for (int neighbor : graph.get(i)) {
                transposedGraph.get(neighbor).add(i);
            }
        }

        // Step 4: Perform DFS on the transposed graph using the topological order
        Arrays.fill(visited, false);
        int sccCount = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                // DFS to mark all nodes in the current SCC
                dfsTranspose(node, transposedGraph, visited);
                sccCount++;
            }
        }

        return sccCount;
    }

    private static void topologicalSortDFS(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                topologicalSortDFS(neighbor, graph, visited, stack);
            }
        }
        stack.push(node); // Add to stack after visiting all neighbors
    }

    private static void dfsTranspose(int node, ArrayList<ArrayList<Integer>> transposedGraph, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : transposedGraph.get(node)) {
            if (!visited[neighbor]) {
                dfsTranspose(neighbor, transposedGraph, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of vertices and edges
        System.out.println("Enter number of vertices and edges:");
        int v = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        System.out.println("Enter the edges:");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            ArrayList<Integer> edge = new ArrayList<>();
            edge.add(u);
            edge.add(w);
            edges.add(edge);
        }

        // Find and print the number of SCCs
        int sccCount = stronglyConnectedComponents(v, edges);
        System.out.println("Number of Strongly Connected Components: " + sccCount);

        sc.close();
    }
}
