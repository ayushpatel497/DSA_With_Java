import java.util.*;

// Binary Tree Node
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Q97_Right_View_Of_Binary_Tree {

    // Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // Queue for level order traversal
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            // Traverse nodes at current level
            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();
                // Add the last node in the current level to the result
                if (i == size - 1) {
                    result.add(currentNode.data);
                }
                // Add left and right children to queue for next level
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
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
            Q97_Right_View_Of_Binary_Tree solution = new Q97_Right_View_Of_Binary_Tree();
            ArrayList<Integer> result = solution.rightView(root);

            System.out.println("Right View for tree " + tc + ": " + result);
        }
        scanner.close();
    }
}
