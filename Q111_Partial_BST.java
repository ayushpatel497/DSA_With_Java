import java.util.*;

/*************************************************************

    Following is the BinaryTreeNode structure

*************************************************************/

class BinaryTreeNode<T> {
    int data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }
}

public class Q111_Partial_BST {

    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        return validateBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Utility function to recursively validate the Partial BST conditions
    private static boolean validateBSTUtil(BinaryTreeNode<Integer> node, int min, int max) {
        if (node == null) {
            return true;
        }

        // Check if node data is within the range [min, max]
        if (node.data < min || node.data > max) {
            return false;
        }

        // Recursively check the left and right subtrees with updated ranges
        return validateBSTUtil(node.left, min, node.data) && validateBSTUtil(node.right, node.data, max);
    }

    // Helper method to insert nodes to construct a tree for testing
    public static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root, int data) {
        if (root == null) {
            return new BinaryTreeNode<>(data);
        }
        if (data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of test cases: ");
        int t = scanner.nextInt();

        while (t-- > 0) {
            System.out.print("Enter number of nodes in the tree: ");
            int n = scanner.nextInt();

            BinaryTreeNode<Integer> root = null;

            System.out.println("Enter the values of nodes:");
            for (int i = 0; i < n; i++) {
                int val = scanner.nextInt();
                root = insert(root, val);
            }

            System.out.println("Is the tree a Partial BST? " + validateBST(root));
        }

        scanner.close();
    }
}
