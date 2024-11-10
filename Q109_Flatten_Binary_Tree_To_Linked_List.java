import java.util.Scanner;

/* Node structure */
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Q109_Flatten_Binary_Tree_To_Linked_List {

    // Function to flatten binary tree to linked list in-place
    public static void flatten(Node root) {
        Node current = root;
        
        while (current != null) {
            if (current.left != null) {
                Node predecessor = current.left;
                
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                
                predecessor.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }

    // Utility method to build a binary tree from array input
    static Node buildTree(int[] nodes, int index) {
        if (index >= nodes.length || nodes[index] == -1) return null;

        Node root = new Node(nodes[index]);
        root.left = buildTree(nodes, 2 * index + 1);
        root.right = buildTree(nodes, 2 * index + 2);
        return root;
    }

    // Method to print the flattened tree as a linked list
    static void printFlattenedTree(Node root) {
        Node current = root;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.right;
        }
        System.out.println();
    }

    // Main method to test multiple test cases
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            System.out.println("Enter number of nodes:");
            int n = sc.nextInt();
            int[] nodes = new int[n];
            System.out.println("Enter nodes in level order (use -1 for null nodes):");

            for (int i = 0; i < n; i++) {
                nodes[i] = sc.nextInt();
            }

            Node root = buildTree(nodes, 0);
            flatten(root);

            System.out.println("Flattened tree as linked list for test case " + (t + 1) + ":");
            printFlattenedTree(root);
        }

        sc.close();
    }
}
