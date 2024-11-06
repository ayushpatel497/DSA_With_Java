import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

/* Binary Tree Node */
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Q92_Zigzag_Tree_Traversal {

    // Function to store the zigzag order traversal of tree in a list.
    ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // Stacks to manage the current and next levels
        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();

        // Add root to current level stack
        currentLevel.push(root);
        boolean leftToRight = true;

        while (!currentLevel.isEmpty()) {
            Node node = currentLevel.pop();
            result.add(node.data);

            // If left to right, push left child first then right child
            if (leftToRight) {
                if (node.left != null) {
                    nextLevel.push(node.left);
                }
                if (node.right != null) {
                    nextLevel.push(node.right);
                }
            } else { // Else push right child first then left child
                if (node.right != null) {
                    nextLevel.push(node.right);
                }
                if (node.left != null) {
                    nextLevel.push(node.left);
                }
            }

            // If current level is finished, switch to next level
            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;  // Toggle the traversal direction
                Stack<Node> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
        return result;
    }

    // Method to build a binary tree from an array input (level-order)
    public static Node buildTreeFromInput(String[] nodeValues) {
        if (nodeValues.length == 0 || nodeValues[0].equals("N")) {
            return null;
        }

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

        Q92_Zigzag_Tree_Traversal traversal = new Q92_Zigzag_Tree_Traversal();

        for (int tc = 1; tc <= t; tc++) {
            System.out.println("Enter node values for tree " + tc + " in level order (use 'N' for null):");
            String[] nodeValues = scanner.nextLine().split(" ");

            Node root = buildTreeFromInput(nodeValues);
            ArrayList<Integer> result = traversal.zigZagTraversal(root);

            System.out.println("Zigzag Traversal for tree " + tc + ": " + result);
        }
        scanner.close();
    }
}
