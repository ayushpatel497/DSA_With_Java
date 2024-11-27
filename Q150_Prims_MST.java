import java.util.*;

public class Q150_Prims_MST {
    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g) {
        // Step 1: Create an adjacency list to represent the graph
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Populate adjacency list
        for (ArrayList<Integer> edge : g) {
            int u = edge.get(0);
            int v = edge.get(1);
            int weight = edge.get(2);
            adjList.get(u).add(new int[]{v, weight});
            adjList.get(v).add(new int[]{u, weight});
        }

        // Step 2: Initialize data structures
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // {node, weight, parent}
        ArrayList<ArrayList<Integer>> mst = new ArrayList<>();
        
        // Start from node 1 (arbitrary choice)
        pq.offer(new int[]{1, 0, -1}); // {current node, weight, parent node}

        // Step 3: Process the graph
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int weight = curr[1];
            int parent = curr[2];

            // Skip if the node is already in the MST
            if (visited[node]) continue;
            visited[node] = true;

            // If it's not the starting node, add the edge to the MST
            if (parent != -1) {
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(parent);
                edge.add(node);
                edge.add(weight);
                mst.add(edge);
            }

            // Add all unvisited neighbors to the priority queue
            for (int[] neighbor : adjList.get(node)) {
                int neighborNode = neighbor[0];
                int edgeWeight = neighbor[1];
                if (!visited[neighborNode]) {
                    pq.offer(new int[]{neighborNode, edgeWeight, node});
                }
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: number of nodes and edges
        System.out.println("Enter the number of nodes:");
        int n = sc.nextInt();
        System.out.println("Enter the number of edges:");
        int m = sc.nextInt();

        // Input: graph edges
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        System.out.println("Enter the edges in the format: u v weight");
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            ArrayList<Integer> edge = new ArrayList<>(Arrays.asList(u, v, weight));
            g.add(edge);
        }

        // Calculate MST
        ArrayList<ArrayList<Integer>> mst = calculatePrimsMST(n, m, g);

        // Output MST
        System.out.println("Edges in the MST with weights:");
        for (ArrayList<Integer> edge : mst) {
            System.out.println(edge.get(0) + " - " + edge.get(1) + " : " + edge.get(2));
        }

        sc.close();
    }
}
