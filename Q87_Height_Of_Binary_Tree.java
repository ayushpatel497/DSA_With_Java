import java.util.Scanner;

/* 
Definition for a binary tree node.
*/
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Q87_Height_Of_Binary_Tree {

    // Function to find the height of a binary tree
    int height(Node node) {
        // If the node is null, it has no height
        if (node == null) {
            return 0;
        }

        // Recursively calculate the height of left and right subtrees
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // Height of the current node is max of left and right subtree heights + 1
        return Math.max(leftHeight, rightHeight) + 1;
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

        System.out.print("Enter number of test cases: ");
        int t = scanner.nextInt();

        Q87_Height_Of_Binary_Tree treeHeightCalculator = new Q87_Height_Of_Binary_Tree();

        for (int i = 0; i < t; i++) {
            System.out.println("Building tree for test case " + (i + 1));
            Node root = buildTree(scanner);

            int height = treeHeightCalculator.height(root);
            System.out.println("Height of the binary tree: " + height);
        }
        
        scanner.close();
    }
}
