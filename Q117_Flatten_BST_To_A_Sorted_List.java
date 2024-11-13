import java.util.* ;

/************************************************************

 Following is the TreeNode class structure

 class TreeNode<T>
 {
     public T data;
     public TreeNode<T> left;
     public TreeNode<T> right;

    TreeNode(T data)
    {
        this.data = data;
        left = null;
        right = null;
     }
 };

 ************************************************************/

public class Q117_Flatten_BST_To_A_Sorted_List {
    private static TreeNode<Integer> prev = null; // Tracks the previous node in the flattened structure

    public static TreeNode<Integer> flatten(TreeNode<Integer> root) {
        // Dummy node that will act as the head of the flattened list
        TreeNode<Integer> dummy = new TreeNode<>(-1);
        prev = dummy; // Start with the dummy node
        
        // Helper method to perform in-order traversal and flatten the tree
        inorderFlatten(root);
        
        // The head of the flattened list will be the right child of the dummy node
        return dummy.right;
    }

    private static void inorderFlatten(TreeNode<Integer> node) {
        if (node == null) return;

        // Recursively flatten the left subtree
        inorderFlatten(node.left);

        // Set the left child of the current node to null (for right-skewed list)
        node.left = null;

        // Link the previous node's right to the current node
        prev.right = node;

        // Move prev to the current node
        prev = node;

        // Recursively flatten the right subtree
        inorderFlatten(node.right);
    }

    // Utility method to print the flattened tree for testing
    public static void printFlattenedTree(TreeNode<Integer> root) {
        TreeNode<Integer> current = root;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.right;
        }
        System.out.println();
    }

    // Main method for testing with multiple test cases
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.print("Enter the number of nodes in the BST: ");
            int n = sc.nextInt();

            TreeNode<Integer> root = null;
            System.out.println("Enter the nodes:");
            for (int j = 0; j < n; j++) {
                int data = sc.nextInt();
                root = insertIntoBST(root, data);
            }

            // Flatten the BST
            TreeNode<Integer> flattenedList = flatten(root);

            // Print the flattened list
            System.out.print("Flattened BST to sorted list: ");
            printFlattenedTree(flattenedList);
        }

        sc.close();
    }

    // Helper method to insert nodes into BST
    private static TreeNode<Integer> insertIntoBST(TreeNode<Integer> root, int data) {
        if (root == null) {
            return new TreeNode<>(data);
        }
        if (data < root.data) {
            root.left = insertIntoBST(root.left, data);
        } else {
            root.right = insertIntoBST(root.right, data);
        }
        return root;
    }
}
