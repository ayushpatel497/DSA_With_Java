import java.util.*;

public class Q149_Dijkstras_Shortest_Path {

    public static ArrayList<Integer> dijkstra(ArrayList<ArrayList<Integer>> vec, int vertices, int edges, int source) {
        // Step 1: Create adjacency list
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // Populate adjacency list
        for (ArrayList<Integer> edge : vec) {
            int u = edge.get(0);
            int v = edge.get(1);
            int weight = edge.get(2);
            adjList.get(u).add(new int[]{v, weight});
            adjList.get(v).add(new int[]{u, weight}); // Because it's an undirected graph
        }

        // Step 2: Initialize distances and priority queue
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{source, 0}); // {node, distance}

        // Step 3: Process nodes
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int dist = current[1];

            // Skip if the distance is outdated
            if (dist > distances[node]) {
                continue;
            }

            // Relax all neighbors
            for (int[] neighbor : adjList.get(node)) {
                int neighborNode = neighbor[0];
                int edgeWeight = neighbor[1];

                if (distances[node] + edgeWeight < distances[neighborNode]) {
                    distances[neighborNode] = distances[node] + edgeWeight;
                    pq.offer(new int[]{neighborNode, distances[neighborNode]});
                }
            }
        }

        // Step 4: Convert distances to ArrayList and return
        ArrayList<Integer> result = new ArrayList<>();
        for (int dist : distances) {
            result.add(dist);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of vertices and edges
        System.out.println("Enter number of vertices and edges:");
        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        // Input edges
        ArrayList<ArrayList<Integer>> vec = new ArrayList<>();
        System.out.println("Enter edges (u v weight):");
        for (int i = 0; i < edges; i++) {
            ArrayList<Integer> edge = new ArrayList<>();
            edge.add(sc.nextInt());
            edge.add(sc.nextInt());
            edge.add(sc.nextInt());
            vec.add(edge);
        }

        // Input source
        System.out.println("Enter source vertex:");
        int source = sc.nextInt();

        // Get shortest paths
        ArrayList<Integer> shortestPaths = dijkstra(vec, vertices, edges, source);

        // Output distances
        System.out.println("Shortest distances from source:");
        for (int dist : shortestPaths) {
            System.out.print(dist + " ");
        }

        sc.close();
    }
}
