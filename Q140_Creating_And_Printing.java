import java.util.*;

public class Q140_Creating_And_Printing {
    public static int[][] printAdjacency(int n, int m, int[][] edges) {
        // Initialize the adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        // Create an empty list for each node, and add the node itself
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> nodeList = new ArrayList<>();
            nodeList.add(i);
            adjList.add(nodeList);
        }

        // Add the edges to the adjacency list
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adjList.get(u).add(v); // Add v to u's list
            adjList.get(v).add(u); // Add u to v's list
        }

        // Convert the adjacency list to a 2D array for output
        int[][] result = new int[n][];
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> neighbors = adjList.get(i);
            result[i] = new int[neighbors.size()];
            for (int j = 0; j < neighbors.size(); j++) {
                result[i][j] = neighbors.get(j);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of nodes and edges
        System.out.println("Enter the number of nodes and edges:");
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Input the edges
        System.out.println("Enter the edges:");
        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        // Generate adjacency list
        int[][] adjList = printAdjacency(n, m, edges);

        // Output adjacency list
        System.out.println("Adjacency List:");
        for (int i = 0; i < adjList.length; i++) {
            for (int j = 0; j < adjList[i].length; j++) {
                System.out.print(adjList[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
