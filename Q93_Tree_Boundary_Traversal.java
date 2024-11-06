import java.util.ArrayList;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

// Binary Tree Node
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class Q93_Tree_Boundary_Traversal {

    // Function to perform boundary traversal
    ArrayList<Integer> boundary(Node node) {
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null) return result;

        result.add(node.data);

        // Add left boundary excluding leaves
        addLeftBoundary(node.left, result);

        // Add all leaf nodes
        addLeaves(node.left, result);
        addLeaves(node.right, result);

        // Add right boundary excluding leaves and root in reverse order
        addRightBoundary(node.right, result);

        return result;
    }

    // Helper method to add left boundary
    private void addLeftBoundary(Node node, ArrayList<Integer> result) {
        while (node != null) {
            if (!isLeaf(node)) result.add(node.data);
            node = (node.left != null) ? node.left : node.right;
        }
    }

    // Helper method to add leaf nodes
    private void addLeaves(Node node, ArrayList<Integer> result) {
        if (node == null) return;
        if (isLeaf(node)) {
            result.add(node.data);
        } else {
            addLeaves(node.left, result);
            addLeaves(node.right, result);
        }
    }

    // Helper method to add right boundary in reverse
    private void addRightBoundary(Node node, ArrayList<Integer> result) {
        ArrayList<Integer> temp = new ArrayList<>();
        while (node != null) {
            if (!isLeaf(node)) temp.add(node.data);
            node = (node.right != null) ? node.right : node.left;
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            result.add(temp.get(i));
        }
    }

    // Check if a node is a leaf
    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    // Method to build a binary tree from an array input (level-order)
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

    // Main method to run multiple test cases
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int t = Integer.parseInt(scanner.nextLine());

        Q93_Tree_Boundary_Traversal traversal = new Q93_Tree_Boundary_Traversal();

        for (int tc = 1; tc <= t; tc++) {
            System.out.println("Enter node values for tree " + tc + " in level order (use 'N' for null):");
            String[] nodeValues = scanner.nextLine().split(" ");

            Node root = buildTreeFromInput(nodeValues);
            ArrayList<Integer> result = traversal.boundary(root);

            System.out.println("Boundary Traversal for tree " + tc + ": " + result);
        }
        scanner.close();
    }
}
