import java.util.Scanner;

/* 
Definition for a binary tree node.
*/
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Q88_Diameter_Of_A_Binary_Tree {
    
    // Helper class to store the height and diameter simultaneously
    static class HeightDiameter {
        int height;
        int diameter;

        HeightDiameter(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    // Function to calculate the height and diameter of the binary tree
    private HeightDiameter diameterHelper(Node node) {
        // Base case: if node is null, height and diameter are 0
        if (node == null) {
            return new HeightDiameter(0, 0);
        }

        // Recursively calculate height and diameter for left and right subtrees
        HeightDiameter left = diameterHelper(node.left);
        HeightDiameter right = diameterHelper(node.right);

        // Height of the current node
        int currentHeight = Math.max(left.height, right.height) + 1;
        
        // Diameter is the largest of:
        // 1. Diameter of the left subtree
        // 2. Diameter of the right subtree
        // 3. Height of left subtree + height of right subtree + 1 (if the path goes through this node)
        int currentDiameter = Math.max(left.height + right.height + 1, Math.max(left.diameter, right.diameter));
        
        return new HeightDiameter(currentHeight, currentDiameter);
    }

    // Function to return the diameter of the binary tree
    public int diameter(Node root) {
        return diameterHelper(root).diameter;
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

        Q88_Diameter_Of_A_Binary_Tree treeDiameterCalculator = new Q88_Diameter_Of_A_Binary_Tree();

        for (int i = 0; i < t; i++) {
            System.out.println("Building tree for test case " + (i + 1));
            Node root = buildTree(scanner);

            int diameter = treeDiameterCalculator.diameter(root);
            System.out.println("Diameter of the binary tree: " + diameter);
        }
        
        scanner.close();
    }
}
