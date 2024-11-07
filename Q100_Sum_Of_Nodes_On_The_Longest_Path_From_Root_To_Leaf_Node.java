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

class Q100_Sum_Of_Nodes_On_The_Longest_Path_From_Root_To_Leaf_Node {
    
    // Helper method to calculate the longest path sum
    private void findLongestPath(Node node, int currentSum, int currentLength, int[] maxSumAndLength) {
        if (node == null) {
            // Update max sum if we've found a longer path or same length with greater sum
            if (currentLength > maxSumAndLength[1] || 
               (currentLength == maxSumAndLength[1] && currentSum > maxSumAndLength[0])) {
                maxSumAndLength[0] = currentSum; // Update max sum
                maxSumAndLength[1] = currentLength; // Update max length
            }
            return;
        }

        // Add current node's data to current sum and increase length
        currentSum += node.data;
        currentLength += 1;

        // Recur for left and right children
        findLongestPath(node.left, currentSum, currentLength, maxSumAndLength);
        findLongestPath(node.right, currentSum, currentLength, maxSumAndLength);
    }

    // Method to calculate sum of the longest path from root to leaf
    public int sumOfLongRootToLeafPath(Node root) {
        int[] maxSumAndLength = new int[2]; // [0] - max sum, [1] - max length
        findLongestPath(root, 0, 0, maxSumAndLength);
        return maxSumAndLength[0];
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
            Q100_Sum_Of_Nodes_On_The_Longest_Path_From_Root_To_Leaf_Node solution = new Q100_Sum_Of_Nodes_On_The_Longest_Path_From_Root_To_Leaf_Node();
            int result = solution.sumOfLongRootToLeafPath(root);

            System.out.println("Sum of nodes on the longest path from root to leaf for tree " + tc + ": " + result);
        }
        scanner.close();
    }
}
