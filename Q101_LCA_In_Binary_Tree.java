import java.util.*;

// Definition for binary tree node
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Q101_LCA_In_Binary_Tree {

    // Function to find the lowest common ancestor (LCA) of two nodes in a binary tree.
    Node lca(Node root, int n1, int n2) {
        // Base case: if root is null, return null
        if (root == null) {
            return null;
        }

        // If either n1 or n2 matches with root's data, return root (this node could be the LCA)
        if (root.data == n1 || root.data == n2) {
            return root;
        }

        // Recur for left and right subtrees
        Node leftLCA = lca(root.left, n1, n2);
        Node rightLCA = lca(root.right, n1, n2);

        // If n1 and n2 are found in left and right subtrees of this node, this is the LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // Otherwise, return the non-null child (left or right subtree where one or both nodes were found)
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    // Helper method to build a binary tree from level order input
    public static Node buildTreeFromInput(String[] nodeValues) {
        if (nodeValues.length == 0 || nodeValues[0].equals("N")) return null;

        Node root = new Node(Integer.parseInt(nodeValues[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty() && i < nodeValues.length) {
            Node currentNode = queue.poll();

            // Left child
            if (!nodeValues[i].equals("N")) {
                currentNode.left = new Node(Integer.parseInt(nodeValues[i]));
                queue.add(currentNode.left);
            }
            i++;

            // Right child
            if (i < nodeValues.length && !nodeValues[i].equals("N")) {
                currentNode.right = new Node(Integer.parseInt(nodeValues[i]));
                queue.add(currentNode.right);
            }
            i++;
        }
        return root;
    }

    // Main method to handle multiple test cases
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int t = Integer.parseInt(scanner.nextLine());

        for (int tc = 1; tc <= t; tc++) {
            System.out.println("Enter node values for tree " + tc + " in level order (use 'N' for null):");
            String[] nodeValues = scanner.nextLine().split(" ");

            Node root = buildTreeFromInput(nodeValues);

            System.out.println("Enter two nodes to find LCA for:");
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            Q101_LCA_In_Binary_Tree solution = new Q101_LCA_In_Binary_Tree();
            Node lcaNode = solution.lca(root, n1, n2);

            if (lcaNode != null) {
                System.out.println("LCA of nodes " + n1 + " and " + n2 + " for tree " + tc + ": " + lcaNode.data);
            } else {
                System.out.println("One or both of the nodes are not present in the tree.");
            }
        }
        scanner.close();
    }
}
