import java.util.*;

/* Definition for a binary tree node.*/
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class Q102_K_Sum_Paths {
    // Function to return count of paths that sum to K
    public int sumK(Node root, int k) {
        ArrayList<Integer> path = new ArrayList<>();
        return countKSumPaths(root, k, path);
    }

    // Helper function to count paths with sum equal to k
    private int countKSumPaths(Node node, int k, ArrayList<Integer> path) {
        // Base case
        if (node == null) {
            return 0;
        }

        // Add the current node's value to the path list
        path.add(node.data);

        // Variable to store the count of k-sum paths ending at this node
        int pathCount = 0;
        int sum = 0;

        // Traverse the path from the current node back to the root
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);

            // If we found a k-sum path, increment the count
            if (sum == k) {
                pathCount++;
            }
        }

        // Recur for the left and right children
        pathCount += countKSumPaths(node.left, k, path);
        pathCount += countKSumPaths(node.right, k, path);

        // Remove the current node from the path list to backtrack
        path.remove(path.size() - 1);

        return pathCount;
    }

    // Helper function to build a binary tree from level-order input
    public static Node buildTreeFromInput(String[] nodeValues) {
        if (nodeValues.length == 0 || nodeValues[0].equals("N")) return null;

        Node root = new Node(Integer.parseInt(nodeValues[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty() && i < nodeValues.length) {
            Node currentNode = queue.poll();

            // Left child
            if (!nodeValues[i].equals("N")) {
                currentNode.left = new Node(Integer.parseInt(nodeValues[i]));
                queue.add(currentNode.left);
            }
            i++;

            // Right child
            if (i < nodeValues.length && !nodeValues[i].equals("N")) {
                currentNode.right = new Node(Integer.parseInt(nodeValues[i]));
                queue.add(currentNode.right);
            }
            i++;
        }
        return root;
    }

    // Main function to handle multiple test cases
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int t = Integer.parseInt(scanner.nextLine());

        for (int tc = 1; tc <= t; tc++) {
            System.out.println("Enter node values for tree " + tc + " in level order (use 'N' for null):");
            String[] nodeValues = scanner.nextLine().split(" ");

            Node root = buildTreeFromInput(nodeValues);

            System.out.println("Enter the value of k:");
            int k = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            Q102_K_Sum_Paths solution = new Q102_K_Sum_Paths();
            int result = solution.sumK(root, k);

            System.out.println("Number of K-sum paths for tree " + tc + ": " + result);
        }
        scanner.close();
    }
}
