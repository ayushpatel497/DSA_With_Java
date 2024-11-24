import java.util.*;

public class Q142_DFS_Traversal {
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        // Create adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }

        // Populate the adjacency list from the edges
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int w = edge.get(1);
            adjList.get(u).add(w);
            adjList.get(w).add(u); // Since the graph is undirected
        }

        // Sort adjacency list to ensure lexicographical order
        for (int i = 0; i < v; i++) {
            Collections.sort(adjList.get(i));
        }

        // Array to keep track of visited nodes
        boolean[] visited = new boolean[v];

        // Resultant list of connected components
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // Perform DFS for each component
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                dfs(i, adjList, visited, component);
                result.add(component);
            }
        }

        return result;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, ArrayList<Integer> component) {
        visited[node] = true;
        component.add(node);

        // Traverse neighbors in lexicographical order
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited, component);
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

        // Perform DFS traversal
        ArrayList<ArrayList<Integer>> dfsResult = depthFirstSearch(v, e, edges);

        // Output the result
        System.out.println("DFS Traversal:");
        for (ArrayList<Integer> component : dfsResult) {
            for (int node : component) {
                System.out.print(node + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
