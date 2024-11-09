import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Q107_Burning_Tree {
    // Function to return minimum time required to burn the complete binary tree from the target node
    public static int minTime(Node root, int target) {
        // Step 1: Map each node to its parent using a HashMap
        Map<Node, Node> parentMap = new HashMap<>();
        Node targetNode = buildParentMapAndFindTarget(root, target, parentMap);
        
        // Step 2: Use BFS to calculate burn time
        return calculateBurnTime(targetNode, parentMap);
    }

    // Function to create parent references and find the target node
    private static Node buildParentMapAndFindTarget(Node root, int target, Map<Node, Node> parentMap) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node targetNode = null;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.data == target) {
                targetNode = node;
            }
            
            if (node.left != null) {
                parentMap.put(node.left, node); // Map child to parent
                queue.add(node.left);
            }
            
            if (node.right != null) {
                parentMap.put(node.right, node); // Map child to parent
                queue.add(node.right);
            }
        }
        
        return targetNode;
    }

    // Function to calculate burn time using BFS from the target node
    private static int calculateBurnTime(Node targetNode, Map<Node, Node> parentMap) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        
        queue.add(targetNode);
        visited.add(targetNode);
        
        int burnTime = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean anyNodeBurned = false;

            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();

                // Check all three possible neighbors (left, right, parent)
                if (currentNode.left != null && visited.add(currentNode.left)) {
                    queue.add(currentNode.left);
                    anyNodeBurned = true;
                }
                
                if (currentNode.right != null && visited.add(currentNode.right)) {
                    queue.add(currentNode.right);
                    anyNodeBurned = true;
                }
                
                if (parentMap.containsKey(currentNode) && visited.add(parentMap.get(currentNode))) {
                    queue.add(parentMap.get(currentNode));
                    anyNodeBurned = true;
                }
            }
            
            // Increase burn time only if any node was burned in this iteration
            if (anyNodeBurned) {
                burnTime++;
            }
        }

        return burnTime;
    }

    // Function to build a binary tree from a level-order input array
    private static Node buildTreeFromLevelOrder(int[] values) {
        if (values.length == 0 || values[0] == -1) return null;

        Node root = new Node(values[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;
        while (!queue.isEmpty() && index < values.length) {
            Node current = queue.poll();

            // Add left child
            if (values[index] != -1) {
                current.left = new Node(values[index]);
                queue.add(current.left);
            }
            index++;

            // Check if there are more elements for the right child
            if (index >= values.length) break;

            // Add right child
            if (values[index] != -1) {
                current.right = new Node(values[index]);
                queue.add(current.right);
            }
            index++;
        }

        return root;
    }

    // Main method to run test cases
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Number of test cases
        System.out.print("Enter the number of test cases: ");
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.print("Enter number of nodes in the tree: ");
            int n = scanner.nextInt();

            System.out.println("Enter the tree nodes in level-order (use -1 for null nodes):");
            int[] nodes = new int[n];
            for (int j = 0; j < n; j++) {
                nodes[j] = scanner.nextInt();
            }

            System.out.print("Enter the target node: ");
            int target = scanner.nextInt();

            // Build tree from input and calculate burn time
            Node root = buildTreeFromLevelOrder(nodes);
            int burnTime = minTime(root, target);

            System.out.println("Minimum time to burn the tree from target node " + target + ": " + burnTime);
        }

        scanner.close();
    }
}
