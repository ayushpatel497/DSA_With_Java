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

class Q99_Diagonal_Tree_Traversal {

    // Function to return diagonal traversal of a binary tree
    public ArrayList<Integer> diagonal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // A queue to hold nodes of the current diagonal
        Queue<Node> queue = new LinkedList<>();
        
        if (root == null) return result;

        // Start with the root
        queue.add(root);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            
            // Traverse the current diagonal
            while (currentNode != null) {
                result.add(currentNode.data); // Add node's data to result
                // If left child exists, add it to the queue (for the next diagonal)
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                // Move to the right node in the current diagonal
                currentNode = currentNode.right;
            }
        }
        
        return result;
    }

    // Helper method to build a binary tree from input (level order)
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
            Q99_Diagonal_Tree_Traversal solution = new Q99_Diagonal_Tree_Traversal();
            ArrayList<Integer> result = solution.diagonal(root);

            System.out.println("Diagonal Traversal for tree " + tc + ": " + result);
        }
        scanner.close();
    }
}
