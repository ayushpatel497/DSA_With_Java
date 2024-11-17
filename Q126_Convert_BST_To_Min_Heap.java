import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}

class Q126_Convert_BST_To_Min_Heap {

    // Helper function to perform an in-order traversal and store values in a list
    static void inorderTraversal(Node root, List<Integer> inorder) {
        if (root == null) return;
        inorderTraversal(root.left, inorder);
        inorder.add(root.data);
        inorderTraversal(root.right, inorder);
    }

    // Helper function to convert the BST to a Min Heap using pre-order traversal
    static void preorderFill(Node root, List<Integer> values, int[] index) {
        if (root == null) return;

        root.data = values.get(index[0]++);
        preorderFill(root.left, values, index);
        preorderFill(root.right, values, index);
    }

    // Function to convert BST to Min Heap
    static void convertBSTtoMinHeap(Node root) {
        // Step 1: Get the in-order traversal of the BST
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);

        // Step 2: Use the in-order values to fill the Min Heap via pre-order traversal
        int[] index = {0}; // To keep track of the current index in the in-order list
        preorderFill(root, inorder, index);
    }

    // Helper function to perform a level-order traversal and print the tree
    static void printLevelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        System.out.println();
    }

    // Main function to handle dynamic test cases
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int t = scanner.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            System.out.print("Enter the number of nodes in the BST: ");
            int n = scanner.nextInt();
            int[] values = new int[n];

            System.out.println("Enter the BST node values in level-order (complete binary tree):");
            for (int i = 0; i < n; i++) {
                values[i] = scanner.nextInt();
            }

            // Build the BST from the given level-order input
            Node root = buildCompleteBinaryTree(values);

            System.out.println("Original Level-Order Traversal of BST:");
            printLevelOrder(root);

            // Convert BST to Min Heap
            convertBSTtoMinHeap(root);

            System.out.println("Level-Order Traversal after converting to Min Heap:");
            printLevelOrder(root);
        }

        scanner.close();
    }

    // Function to build a complete binary tree from level-order input
    static Node buildCompleteBinaryTree(int[] values) {
        if (values.length == 0) return null;

        Node root = new Node(values[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < values.length) {
            Node current = queue.poll();

            if (i < values.length) {
                current.left = new Node(values[i++]);
                queue.add(current.left);
            }

            if (i < values.length) {
                current.right = new Node(values[i++]);
                queue.add(current.right);
            }
        }

        return root;
    }
}
