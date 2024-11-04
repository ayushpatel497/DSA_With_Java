import java.util.Scanner;

/*******************************************************
    Binary Tree Node class structure.
*******************************************************/
class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Q86_Count_Leaf_Nodes {

    // Function to count the number of leaf nodes in the binary tree
    public static int noOfLeafNodes(BinaryTreeNode<Integer> root) {
        // Base Case: If the tree is empty, there are no leaf nodes
        if (root == null) {
            return 0;
        }

        // If both left and right children are null, this is a leaf node
        if (root.left == null && root.right == null) {
            return 1;
        }

        // Recursively count leaf nodes in left and right subtrees and add them up
        int leftLeaves = noOfLeafNodes(root.left);
        int rightLeaves = noOfLeafNodes(root.right);

        return leftLeaves + rightLeaves;
    }

    // Helper method to create a binary tree from input
    public static BinaryTreeNode<Integer> buildTree(Scanner scanner) {
        System.out.print("Enter node data (-1 for null): ");
        int data = scanner.nextInt();

        // Base case: If data is -1, this node is null
        if (data == -1) {
            return null;
        }

        // Create the root node with the given data
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);

        System.out.println("Entering left child of " + data);
        root.left = buildTree(scanner); // Recursively build left subtree

        System.out.println("Entering right child of " + data);
        root.right = buildTree(scanner); // Recursively build right subtree

        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of test cases: ");
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.println("Building tree for test case " + (i + 1));
            BinaryTreeNode<Integer> root = buildTree(scanner);

            int leafCount = noOfLeafNodes(root);
            System.out.println("Number of leaf nodes: " + leafCount);
        }
        
        scanner.close();
    }
}
