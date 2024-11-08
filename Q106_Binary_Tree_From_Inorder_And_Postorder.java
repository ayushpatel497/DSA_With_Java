import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Q106_Binary_Tree_From_Inorder_And_Postorder {

    private int postIndex; // To keep track of the current root position in postorder

    public Node buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1; // Start from the last element of postorder
        Map<Integer, Integer> inorderMap = new HashMap<>(); // Map to store index of elements in inorder array

        // Populate the inorder map
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1, inorderMap);
    }

    private Node buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd, Map<Integer, Integer> inorderMap) {
        if (inStart > inEnd) return null; // Base case: no elements in this subtree

        // The current root's value is the current postIndex element in postorder
        int rootValue = postorder[postIndex--];
        Node root = new Node(rootValue);

        // Find the index of this root in inorder array
        int inIndex = inorderMap.get(rootValue);

        // Recurse for the right and left subtrees
        root.right = buildTreeHelper(inorder, postorder, inIndex + 1, inEnd, inorderMap); // Right subtree
        root.left = buildTreeHelper(inorder, postorder, inStart, inIndex - 1, inorderMap); // Left subtree

        return root;
    }

    // Function to print preorder traversal of the tree
    public void printPreorder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of test cases:");
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.println("Enter the size of inorder and postorder arrays:");
            int n = scanner.nextInt();

            int[] inorder = new int[n];
            int[] postorder = new int[n];

            System.out.println("Enter inorder traversal:");
            for (int j = 0; j < n; j++) {
                inorder[j] = scanner.nextInt();
            }

            System.out.println("Enter postorder traversal:");
            for (int j = 0; j < n; j++) {
                postorder[j] = scanner.nextInt();
            }

            Q106_Binary_Tree_From_Inorder_And_Postorder solution = new Q106_Binary_Tree_From_Inorder_And_Postorder();
            Node root = solution.buildTree(inorder, postorder);

            System.out.println("Preorder traversal of constructed tree:");
            solution.printPreorder(root);
            System.out.println();
        }

        scanner.close();
    }
}
