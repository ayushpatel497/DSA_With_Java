import java.util.Scanner;

/* Binary Tree Node */
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Q91_Sum_Tree {
    // Function to check if the binary tree is a Sum Tree
    boolean isSumTree(Node root) {
        // Empty tree or a leaf node is trivially a Sum Tree
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        // Recursively check if left and right subtrees are Sum Trees
        if (isSumTree(root.left) && isSumTree(root.right)) {
            int leftSum = sum(root.left);   // Calculate sum of left subtree
            int rightSum = sum(root.right); // Calculate sum of right subtree

            // Check if current node's data is the sum of left and right subtree sums
            return root.data == leftSum + rightSum;
        }
        return false;
    }

    // Helper function to calculate the sum of values in a subtree rooted at `node`
    int sum(Node node) {
        if (node == null) {
            return 0;
        }
        return node.data + sum(node.left) + sum(node.right);
    }

    // Helper method to build a binary tree from user input
    public static Node buildTree(Scanner scanner) {
        System.out.print("Enter node data (-1 for null): ");
        int data = scanner.nextInt();

        // Base case: if data is -1, this node is null
        if (data == -1) {
            return null;
        }

        // Create a node with the given data
        Node root = new Node(data);

        System.out.println("Entering left child of " + data);
        root.left = buildTree(scanner);  // Recursively build left subtree

        System.out.println("Entering right child of " + data);
        root.right = buildTree(scanner); // Recursively build right subtree

        return root;
    }

    // Main method for taking test cases and running the isSumTree function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Q91_Sum_Tree treeChecker = new Q91_Sum_Tree();

        System.out.print("Enter number of test cases: ");
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.println("Building Tree for test case " + (i + 1));
            Node root = buildTree(scanner);

            boolean result = treeChecker.isSumTree(root);
            System.out.println("Is the tree a Sum Tree? " + result);
        }

        scanner.close();
    }
}
