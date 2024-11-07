import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

/* */
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
        left = right = null;
    }
}


class Q103_Kth_Ancestor_In_A_Tree {
    private int ancestor = -1;      // Store the result

    // Function to find the k-th ancestor of the given node in binary tree
    public int kthAncestor(Node root, int k, int node) {
        findKthAncestor(root, k, node);
        return ancestor;
    }

    // Helper function to perform DFS and find the kth ancestor
    private int findKthAncestor(Node root, int k, int node) {
        // Base case: If the root is null, return 0 as we found no ancestors
        if (root == null) return 0;

        // If we have found the target node
        if (root.data == node) {
            return 1;
        }

        // Search in left subtree
        int leftDistance = findKthAncestor(root.left, k, node);

        // Search in right subtree
        int rightDistance = findKthAncestor(root.right, k, node);

        // Check if the node is found in either left or right subtree
        int childDistance = leftDistance + rightDistance;

        // If the target node is found in either subtree
        if (childDistance > 0) {
            // If we reach the k-th ancestor, set ancestor to root's data
            if (childDistance == k) {
                ancestor = root.data;
            }
            return childDistance + 1;
        }
        return 0; // No target node found in this subtree
    }

    // Helper method to build a binary tree from level-order input
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

            System.out.println("Enter k (ancestor level) and node value:");
            int k = scanner.nextInt();
            int node = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            Q103_Kth_Ancestor_In_A_Tree solution = new Q103_Kth_Ancestor_In_A_Tree();
            int result = solution.kthAncestor(root, k, node);

            System.out.println("The " + k + "-th ancestor of node " + node + " is: " + result);
        }
        scanner.close();
    }
}
