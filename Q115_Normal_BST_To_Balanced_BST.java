import java.util.*;

/************************************************************

    Following is the TreeNode class structure

************************************************************/
class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Q115_Normal_BST_To_Balanced_BST {

    // Method to convert normal BST to balanced BST
    public static TreeNode<Integer> balancedBst(TreeNode<Integer> root) {
        List<Integer> inorderList = new ArrayList<>();
        
        // Step 1: Store the inorder traversal of the BST
        inorderTraversal(root, inorderList);
        
        // Step 2: Build a balanced BST from the sorted list
        return buildBalancedBST(inorderList, 0, inorderList.size() - 1);
    }

    // Helper method to perform inorder traversal and store elements in a list
    private static void inorderTraversal(TreeNode<Integer> root, List<Integer> list) {
        if (root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.data);
        inorderTraversal(root.right, list);
    }

    // Helper method to build a balanced BST from sorted list
    private static TreeNode<Integer> buildBalancedBST(List<Integer> list, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode<Integer> node = new TreeNode<>(list.get(mid));

        node.left = buildBalancedBST(list, start, mid - 1);
        node.right = buildBalancedBST(list, mid + 1, end);

        return node;
    }

    // Helper method to insert nodes in BST for testing
    public static TreeNode<Integer> insertIntoBST(TreeNode<Integer> root, int data) {
        if (root == null) return new TreeNode<>(data);
        if (data < root.data) root.left = insertIntoBST(root.left, data);
        else if (data > root.data) root.right = insertIntoBST(root.right, data);
        return root;
    }

    // Method to print inorder traversal of the BST for verification
    public static void printInOrder(TreeNode<Integer> root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
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

            // Convert to balanced BST
            TreeNode<Integer> balancedRoot = balancedBst(root);

            // Print inorder traversal of the balanced BST
            System.out.print("Inorder traversal of balanced BST: ");
            printInOrder(balancedRoot);
            System.out.println();
        }
        
        scanner.close();
    }
}
