import java.util.*;

public class Q145_Topological_Sort {
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
        // Initialize adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }

        // Build adjacency list and in-degree array
        int[] inDegree = new int[v];
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v1 = edge.get(1);
            adjList.get(u).add(v1);
            inDegree[v1]++;
        }

        // Perform Kahn's Algorithm (BFS-based Topological Sort)
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> topoSort = new ArrayList<>();

        // Add all vertices with in-degree 0 to the queue
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoSort.add(node);

            // Reduce the in-degree of neighboring nodes
            for (int neighbor : adjList.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Check for cycle in the graph
        if (topoSort.size() != v) {
            return new ArrayList<>(); // Return an empty list if the graph is not a DAG
        }

        return topoSort;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of vertices and edges
        System.out.println("Enter number of vertices and edges:");
        int v = sc.nextInt();
        int e = sc.nextInt();

        // Input edges
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        System.out.println("Enter the edges:");
        for (int i = 0; i < e; i++) {
            ArrayList<Integer> edge = new ArrayList<>();
            edge.add(sc.nextInt());
            edge.add(sc.nextInt());
            edges.add(edge);
        }

        // Perform Topological Sort
        ArrayList<Integer> result = topologicalSort(edges, v, e);
        System.out.println("Topological Sort: " + result);

        sc.close();
    }
}
