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

class Q95_Top_View_Of_Binary_Tree {

    // Function to return a list of nodes visible from the top view from left to right
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // TreeMap to store the first node at each horizontal distance
        Map<Integer, Integer> topViewMap = new TreeMap<>();

        // Queue to store nodes along with their horizontal distances
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            Node currentNode = currentPair.node;
            int horizontalDistance = currentPair.horizontalDistance;

            // If no node at this horizontal distance, add the current node to top view
            topViewMap.putIfAbsent(horizontalDistance, currentNode.data);

            // Add left and right children to the queue with updated horizontal distances
            if (currentNode.left != null) queue.add(new Pair(currentNode.left, horizontalDistance - 1));
            if (currentNode.right != null) queue.add(new Pair(currentNode.right, horizontalDistance + 1));
        }

        // Add all values from the TreeMap to the result list
        result.addAll(topViewMap.values());

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
            ArrayList<Integer> result = topView(root);

            System.out.println("Top View for tree " + tc + ": " + result);
        }
        scanner.close();
    }
}
