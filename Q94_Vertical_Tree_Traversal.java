import java.util.*;

// Binary Tree Node
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class Q94_Vertical_Tree_Traversal {

    // Function to find the vertical order traversal of Binary Tree.
    static ArrayList<Integer> verticalOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // TreeMap to store nodes at each horizontal distance
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        
        // Queue to perform level-order traversal (BFS)
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));  // Add root node with horizontal distance 0

        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            Node currentNode = currentPair.node;
            int horizontalDistance = currentPair.horizontalDistance;

            // Add node data to list of corresponding horizontal distance in map
            map.putIfAbsent(horizontalDistance, new ArrayList<>());
            map.get(horizontalDistance).add(currentNode.data);

            // Add left and right children to queue with updated horizontal distance
            if (currentNode.left != null) queue.add(new Pair(currentNode.left, horizontalDistance - 1));
            if (currentNode.right != null) queue.add(new Pair(currentNode.right, horizontalDistance + 1));
        }

        // Add all values from map to result list in order of horizontal distances
        for (ArrayList<Integer> nodesAtDistance : map.values()) {
            result.addAll(nodesAtDistance);
        }

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
            ArrayList<Integer> result = verticalOrder(root);

            System.out.println("Vertical Order Traversal for tree " + tc + ": " + result);
        }
        scanner.close();
    }
}
