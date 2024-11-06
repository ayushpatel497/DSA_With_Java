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

class Q96_Bottom_View_Of_Binary_Tree {

    // Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // TreeMap to store the last node at each horizontal distance
        Map<Integer, Integer> bottomViewMap = new TreeMap<>();

        // Queue to store nodes along with their horizontal distances
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            Node currentNode = currentPair.node;
            int horizontalDistance = currentPair.horizontalDistance;

            // Update the TreeMap with the current node at this horizontal distance
            bottomViewMap.put(horizontalDistance, currentNode.data);

            // Add left and right children to the queue with updated horizontal distances
            if (currentNode.left != null) queue.add(new Pair(currentNode.left, horizontalDistance - 1));
            if (currentNode.right != null) queue.add(new Pair(currentNode.right, horizontalDistance + 1));
        }

        // Add all values from the TreeMap to the result list
        result.addAll(bottomViewMap.values());

        return result;
    }

    // Helper class to store a node with its horizontal distance
    static class Pair {
        Node node;
        int horizontalDistance;

        Pair(Node node, int horizontalDistance) {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
        }
    }

    // Method to build a binary tree from an array input (level-order)
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
            Q96_Bottom_View_Of_Binary_Tree solution = new Q96_Bottom_View_Of_Binary_Tree();
            ArrayList<Integer> result = solution.bottomView(root);

            System.out.println("Bottom View for tree " + tc + ": " + result);
        }
        scanner.close();
    }
}
