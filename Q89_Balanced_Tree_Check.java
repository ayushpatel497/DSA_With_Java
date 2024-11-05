import java.util.Scanner;

/* A binary tree node class */
class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Q89_Balanced_Tree_Check {

    // Helper function that checks for height and balance simultaneously
    private int checkHeightBalance(Node root) {
        // Base case: if node is null, height is 0, and it is balanced
        if (root == null) {
            return 0;
        }

        // Recursively get height of left and right subtrees
        int leftHeight = checkHeightBalance(root.left);
        int rightHeight = checkHeightBalance(root.right);

        // If left or right subtree is unbalanced, return -1 immediately
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return the height of this subtree if balanced
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Function to check whether a binary tree is balanced
    boolean isBalanced(Node root) {
        return checkHeightBalance(root) != -1;
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of test cases: ");
        int t = scanner.nextInt();

        Q89_Balanced_Tree_Check treeBalanceChecker = new Q89_Balanced_Tree_Check();

        for (int i = 0; i < t; i++) {
            System.out.println("Building tree for test case " + (i + 1));
            Node root = buildTree(scanner);

            boolean isBalanced = treeBalanceChecker.isBalanced(root);
            System.out.println("Is the binary tree balanced? " + isBalanced);
        }

        scanner.close();
    }
}
