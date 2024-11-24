import java.util.*;

public class Q141_BFS_In_Graph {
    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj) {
        // List to store the BFS traversal result
        List<Integer> bfsResult = new ArrayList<>();

        // Boolean array to track visited nodes
        boolean[] visited = new boolean[n];

        // Queue for BFS traversal
        Queue<Integer> queue = new LinkedList<>();

        // Start BFS from node 0
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            bfsResult.add(currentNode);

            // Traverse all neighbors of the current node
            for (int neighbor : adj.get(currentNode)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return bfsResult;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of vertices
        System.out.println("Enter the number of vertices:");
        int n = sc.nextInt();

        // Input adjacency list
        System.out.println("Enter the adjacency list:");
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int size = sc.nextInt(); // Number of neighbors for this vertex
            List<Integer> neighbors = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                neighbors.add(sc.nextInt());
            }
            adj.add(neighbors);
        }

        // Perform BFS traversal
        List<Integer> result = bfsTraversal(n, adj);

        // Output the BFS traversal result
        System.out.println("BFS Traversal:");
        for (int node : result) {
            System.out.print(node + " ");
        }

        sc.close();
    }
}
