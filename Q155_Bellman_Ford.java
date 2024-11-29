import java.util.*;

public class Q155_Bellman_Ford {

    public static int[] bellmanFord(int n, int m, int src, List<List<Integer>> edges) {
        // Initialize the distance array
        int [] d=new int[n + 1];

        Arrays.fill(d,100000000);


        // Distance of source to source is 0.
        d[src] = 0;

        // Apply bellmonford algorithm.
        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                int u = edges.get(j).get(0);
                int v =  edges.get(j).get(1);
                int w =  edges.get(j).get(2);

                if (d[u] != 1000000000 && d[v] > (d[u] + w)) {
                    d[v] = d[u] + w;
                }
            }
        }

        // Return the distance of destination.
        return d;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number of vertices and edges
        System.out.println("Enter number of vertices, edges, and source vertex:");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int src = sc.nextInt();

        // Input: Edges
        List<List<Integer>> edges = new ArrayList<>();
        System.out.println("Enter the edges (u, v, w):");
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            List<Integer> edge = new ArrayList<>();
            edge.add(u);
            edge.add(v);
            edge.add(w);
            edges.add(edge);
        }

        // Call Bellman-Ford algorithm
        int[] distances = bellmanFord(n, m, src, edges);

        // Output: Shortest distances
        System.out.println("Shortest distances from source vertex " + src + ":");
        for (int d : distances) {
            System.out.print(d + " ");
        }
        
        sc.close();
    }
}
