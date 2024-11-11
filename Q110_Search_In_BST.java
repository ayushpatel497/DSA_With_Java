import java.util.Scanner;

/*********************************************************

 Following is the BinaryTreeNode structure:

*********************************************************/
class BinaryTreeNode {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    BinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class Q110_Search_In_BST {

    // Function to search for a value x in the Binary Search Tree.
    public static boolean searchInBST(BinaryTreeNode root, int x) {
        while (root != null) {
            if (root.data == x) {
                return true;
            } else if (x < root.data) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return false;
    }

    // Helper function to insert a value into the BST
    public static BinaryTreeNode insertIntoBST(BinaryTreeNode root, int data) {
        if (root == null) {
            return new BinaryTreeNode(data);
        }
        if (data < root.data) {
            root.left = insertIntoBST(root.left, data);
        } else {
            root.right = insertIntoBST(root.right, data);
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of nodes in the BST
        System.out.print("Enter the number of nodes in the BST: ");
        int n = scanner.nextInt();

        BinaryTreeNode root = null;

        // Input nodes to create the BST
        System.out.println("Enter the values of nodes in the BST:");
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            root = insertIntoBST(root, val);
        }

        // Input the number of search queries
        System.out.print("Enter the number of search queries: ");
        int q = scanner.nextInt();

        // Input search queries and print results
        System.out.println("Enter the values to search in the BST:");
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();
            boolean found = searchInBST(root, x);
            System.out.println("Is " + x + " present in BST? " + found);
        }

        scanner.close();
    }
}
