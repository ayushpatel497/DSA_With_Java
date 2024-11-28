import java.util.*;

public class Q153_Articulation_Points_In_A_Graph {

    public static List<Integer> articulationPoints(int v, int e, int[][] edges) {
        // Result list to store articulation points
        List<Integer> result = new ArrayList<>();

        // Build adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int u = edges[i][0];
            int w = edges[i][1];
            graph.get(u).add(w);
            graph.get(w).add(u);
        }

        // Auxiliary data structures
        boolean[] visited = new boolean[v];
        int[] discoveryTime = new int[v];
        int[] lowTime = new int[v];
        int[] parent = new int[v];
        boolean[] isArticulationPoint = new boolean[v];

        Arrays.fill(discoveryTime, -1);
        Arrays.fill(lowTime, -1);
        Arrays.fill(parent, -1);

        // Timer for discovery time
        int[] timer = {0};

        // Call DFS for each unvisited component
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited, discoveryTime, lowTime, parent, isArticulationPoint, timer);
            }
        }

        // Collect all articulation points
        for (int i = 0; i < v; i++) {
            if (isArticulationPoint[i]) {
                result.add(i);
            }
        }

        return result;
    }

    private static void dfs(int u, ArrayList<ArrayList<Integer>> graph, boolean[] visited,
                            int[] discoveryTime, int[] lowTime, int[] parent, boolean[] isArticulationPoint, int[] timer) {

        visited[u] = true;
        discoveryTime[u] = lowTime[u] = timer[0]++;
        int children = 0;

        for (int v : graph.get(u)) {
            if (!visited[v]) {
                // Increment the child count for the root node
                children++;
                parent[v] = u;

                // Recur for the child vertex
                dfs(v, graph, visited, discoveryTime, lowTime, parent, isArticulationPoint, timer);

                // Update the low time of the current vertex based on the child
                lowTime[u] = Math.min(lowTime[u], lowTime[v]);

                // If u is a root node and has more than one child, it's an articulation point
                if (parent[u] == -1 && children > 1) {
                    isArticulationPoint[u] = true;
                }

                // If u is not a root and the low time of one of its children is greater than its discovery time
                if (parent[u] != -1 && lowTime[v] >= discoveryTime[u]) {
                    isArticulationPoint[u] = true;
                }
            } else if (v != parent[u]) {
                // Update the low time based on the back edge
                lowTime[u] = Math.min(lowTime[u], discoveryTime[v]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of vertices and edges
        System.out.println("Enter number of vertices and edges:");
        int v = sc.nextInt();
        int e = sc.nextInt();

        // Input edges
        int[][] edges = new int[e][2];
        System.out.println("Enter edges:");
        for (int i = 0; i < e; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        // Find articulation points
        List<Integer> articulationPoints = articulationPoints(v, e, edges);

        // Print results
        System.out.println("Articulation Points:");
        for (int point : articulationPoints) {
            System.out.println(point);
        }

        sc.close();
    }
}
