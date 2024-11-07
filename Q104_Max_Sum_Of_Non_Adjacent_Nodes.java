import java.util.*;

class Q104_Max_Sum_Of_Non_Adjacent_Nodes {
    
    // Function to return the maximum sum of non-adjacent nodes.
    static int getMaxSum(Node root) {
        // HashMap to store computed results
        HashMap<Node, Integer> memo = new HashMap<>();
        return getMaxSumHelper(root, memo);
    }

    // Helper function with memoization
    private static int getMaxSumHelper(Node node, HashMap<Node, Integer> memo) {
        // Base case: if node is null, the sum is 0
        if (node == null) return 0;

        // If result for the current node is already calculated, return it
        if (memo.containsKey(node)) return memo.get(node);

        // Include the current node's value
        int includeNode = node.data;
        if (node.left != null) {
            includeNode += getMaxSumHelper(node.left.left, memo);
            includeNode += getMaxSumHelper(node.left.right, memo);
        }
        if (node.right != null) {
            includeNode += getMaxSumHelper(node.right.left, memo);
            includeNode += getMaxSumHelper(node.right.right, memo);
        }

        // Exclude the current node's value
        int excludeNode = getMaxSumHelper(node.left, memo) + getMaxSumHelper(node.right, memo);

        // Maximum sum for the current node
        int result = Math.max(includeNode, excludeNode);

        // Store the result in the memoization map
        memo.put(node, result);

        return result;
    }

    // Helper method to build a tree for testing purposes
    public static Node buildTreeFromArray(int[] values) {
        if (values.length == 0 || values[0] == -1) return null;
        Node root = new Node(values[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            Node current = queue.poll();
            if (values[i] != -1) {
                current.left = new Node(values[i]);
                queue.add(current.left);
            }
            i++;
            if (i < values.length && values[i] != -1) {
                current.right = new Node(values[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    // Main method to handle user input for test cases
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of test cases:");
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int tc = 1; tc <= t; tc++) {
            System.out.println("Enter the binary tree values in level order (use -1 for null nodes):");
            String[] nodes = scanner.nextLine().split(" ");
            int[] values = Arrays.stream(nodes).mapToInt(Integer::parseInt).toArray();
            Node root = buildTreeFromArray(values);
            int result = getMaxSum(root);
            System.out.println("Maximum sum of non-adjacent nodes: " + result);
        }
        scanner.close();
    }
}

// Binary Tree Node class
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}
