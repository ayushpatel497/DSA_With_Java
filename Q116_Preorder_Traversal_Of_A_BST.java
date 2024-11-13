import java.util.ArrayList;
import java.util.Scanner;

/*
    Following is the class structure of the BinaryTreeNode class for reference:

    class BinaryTreeNode<T> {
        public T data;
        public BinaryTreeNode<T> left;
        public BinaryTreeNode<T> right;

        BinaryTreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
*/

class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Q116_Preorder_Traversal_Of_A_BST {
    
    private static int index = 0;

    public static BinaryTreeNode<Integer> preorderToBST(ArrayList<Integer> preorder) {
        index = 0; // reset index before starting
        return constructBST(preorder, Integer.MAX_VALUE);
    }
    
    // Helper function to construct the BST within a bound
    private static BinaryTreeNode<Integer> constructBST(ArrayList<Integer> preorder, int bound) {
        if (index >= preorder.size() || preorder.get(index) > bound) {
            return null;
        }
        
        int rootValue = preorder.get(index++);
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootValue);
        
        root.left = constructBST(preorder, rootValue);
        root.right = constructBST(preorder, bound);
        
        return root;
    }
    
    // Method to print inorder traversal of the tree (for verification purposes)
    public static void printInOrder(BinaryTreeNode<Integer> root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.print("Enter the number of elements in preorder traversal: ");
            int n = sc.nextInt();

            ArrayList<Integer> preorder = new ArrayList<>();
            System.out.print("Enter the elements of preorder traversal: ");
            for (int j = 0; j < n; j++) {
                preorder.add(sc.nextInt());
            }

            BinaryTreeNode<Integer> root = preorderToBST(preorder);

            System.out.print("Inorder traversal of constructed BST: ");
            printInOrder(root);
            System.out.println();
        }

        sc.close();
    }
}
