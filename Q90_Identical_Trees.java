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

class Q90_Identical_Trees {

    // Function to check if two trees are identical.
    boolean isIdentical(Node r1, Node r2) {
        // Base case: both nodes are null, meaning they are identical
        if (r1 == null && r2 == null) {
            return true;
        }

        // If only one node is null, trees are not identical
        if (r1 == null || r2 == null) {
            return false;
        }

        // Check if data of both nodes is equal, and recursively check their subtrees
        return (r1.data == r2.data) && isIdentical(r1.left, r2.left) && isIdentical(r1.right, r2.right);
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
        Q90_Identical_Trees treeChecker = new Q90_Identical_Trees();

        System.out.print("Enter number of test cases: ");
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.println("Building Tree 1 for test case " + (i + 1));
            Node tree1 = buildTree(scanner);

            System.out.println("Building Tree 2 for test case " + (i + 1));
            Node tree2 = buildTree(scanner);

            boolean identical = treeChecker.isIdentical(tree1, tree2);
            System.out.println("Are the two trees identical? " + identical);
        }

        scanner.close();
    }
}
