import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Q108_Inorder_Tree_Traversal_Without_Recursion_And_Without_Stack {

    // Morris Traversal for Inorder traversal without recursion or stack
    void morrisInorderTraversal(Node root) {
        Node current = root;

        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                Node predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    predecessor.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    }

    // Utility method to build a binary tree from array input
    Node buildTree(int[] nodes, int index) {
        if (index >= nodes.length || nodes[index] == -1) return null;

        Node root = new Node(nodes[index]);
        root.left = buildTree(nodes, 2 * index + 1);
        root.right = buildTree(nodes, 2 * index + 2);
        return root;
    }

    // Main method to test multiple test cases
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int testCases = sc.nextInt();

        Q108_Inorder_Tree_Traversal_Without_Recursion_And_Without_Stack traversal = new Q108_Inorder_Tree_Traversal_Without_Recursion_And_Without_Stack();

        for (int t = 0; t < testCases; t++) {
            System.out.println("Enter number of nodes:");
            int n = sc.nextInt();
            int[] nodes = new int[n];
            System.out.println("Enter nodes (use -1 for null nodes):");

            for (int i = 0; i < n; i++) {
                nodes[i] = sc.nextInt();
            }

            Node root = traversal.buildTree(nodes, 0);
            System.out.println("Inorder traversal for test case " + (t + 1) + ":");
            traversal.morrisInorderTraversal(root);
            System.out.println();
        }

        sc.close();
    }
}
