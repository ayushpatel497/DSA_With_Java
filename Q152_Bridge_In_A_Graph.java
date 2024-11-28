import java.util.*;

public class Q152_Bridge_In_A_Graph {

    public static List<List<Integer>> findBridges(int[][] edges, int v, int e) {
        // Result to store bridges
        List<List<Integer>> bridges = new ArrayList<>();

        // Adjacency list representation of the graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        // Building the graph
        for (int i = 0; i < e; i++) {
            int u = edges[i][0];
            int vNode = edges[i][1];
            graph.get(u).add(vNode);
            graph.get(vNode).add(u);
        }

        // Auxiliary data structures
        int[] discoveryTime = new int[v];
        int[] lowTime = new int[v];
        boolean[] visited = new boolean[v];

        Arrays.fill(discoveryTime, -1);
        Arrays.fill(lowTime, -1);

        // Timer to track discovery time
        int[] timer = {0};

        // Perform DFS for each connected component
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(i, -1, graph, discoveryTime, lowTime, visited, timer, bridges);
            }
        }

        return bridges;
    }

    private static void dfs(int node, int parent, ArrayList<ArrayList<Integer>> graph, int[] discoveryTime,
                            int[] lowTime, boolean[] visited, int[] timer, List<List<Integer>> bridges) {

        visited[node] = true;
        discoveryTime[node] = lowTime[node] = timer[0]++;
        
        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) {
                continue; // Skip the parent node
            }
            if (!visited[neighbor]) {
                // Explore this neighbor
                dfs(neighbor, node, graph, discoveryTime, lowTime, visited, timer, bridges);

                // Update the low time of the current node based on the neighbor
                lowTime[node] = Math.min(lowTime[node], lowTime[neighbor]);

                // If the condition for a bridge is satisfied
                if (lowTime[neighbor] > discoveryTime[node]) {
                    bridges.add(Arrays.asList(node, neighbor));
                }
            } else {
                // Update low time based on back edge
                lowTime[node] = Math.min(lowTime[node], discoveryTime[neighbor]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of test cases
        System.out.println("Enter number of test cases:");
        int t = sc.nextInt();

        while (t-- > 0) {
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

            // Find bridges
            List<List<Integer>> result = findBridges(edges, v, e);

            // Print the results
            System.out.println(result.size());
            for (List<Integer> bridge : result) {
                System.out.println(bridge.get(0) + " " + bridge.get(1));
            }
        }

        sc.close();
    }
}
