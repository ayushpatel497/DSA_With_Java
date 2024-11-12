import java.util.Scanner;

/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

class TreeNode<T> {
    int data;
    TreeNode<Integer> left, right;

    TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Q113_Find_Kth_Smallest_Element_In_BST {
    
    // Helper class variable to track count of nodes visited and store kth smallest value
    private static int count;
    private static int kthSmallestValue;

    public static int kthSmallest(TreeNode<Integer> root, int k) {
        count = 0;
        kthSmallestValue = -1;  // Default value if k is out of bounds
        inorderTraversal(root, k);
        return kthSmallestValue;
    }

    private static void inorderTraversal(TreeNode<Integer> node, int k) {
        if (node == null) return;
        
        inorderTraversal(node.left, k);
        
        count++;
        if (count == k) {
            kthSmallestValue = node.data;
            return;
        }
        
        inorderTraversal(node.right, k);
    }

    public static TreeNode<Integer> insertIntoBST(TreeNode<Integer> root, int data) {
        if (root == null) return new TreeNode<>(data);
        if (data < root.data) root.left = insertIntoBST(root.left, data);
        else root.right = insertIntoBST(root.right, data);
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of test cases: ");
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            System.out.print("\nEnter number of nodes in BST: ");
            int n = scanner.nextInt();
            
            TreeNode<Integer> root = null;
            System.out.print("Enter nodes of BST: ");
            for (int i = 0; i < n; i++) {
                int data = scanner.nextInt();
                root = insertIntoBST(root, data);
            }
            
            System.out.print("Enter value of k to find k-th smallest element: ");
            int k = scanner.nextInt();
            
            int result = kthSmallest(root, k);
            System.out.println("The " + k + "-th smallest element is: " + (result == -1 ? "Not found" : result));
        }
        
        scanner.close();
    }
}
