import java.util.*;

/*
Node defined as
*/
class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Q124_Is_Binary_Tree_Heap {
    boolean isHeap(Node tree) {
        if (tree == null) return true;

        int totalNodes = countNodes(tree);

        // Check if the binary tree is complete
        if (!isComplete(tree, 0, totalNodes)) return false;

        // Check if the binary tree satisfies heap property
        return isHeapProperty(tree);
    }

    // Count the number of nodes in the binary tree
    private int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Check if the binary tree is complete
    private boolean isComplete(Node root, int index, int totalNodes) {
        if (root == null) return true;

        // If index exceeds the number of nodes, it's not complete
        if (index >= totalNodes) return false;

        // Recursively check left and right subtrees
        return isComplete(root.left, 2 * index + 1, totalNodes) &&
               isComplete(root.right, 2 * index + 2, totalNodes);
    }

    // Check if the binary tree satisfies the heap property
    private boolean isHeapProperty(Node root) {
        if (root == null) return true;

        // Check if children exist and validate heap property
        if (root.left != null && root.left.data > root.data) return false;
        if (root.right != null && root.right.data > root.data) return false;

        // Recursively check left and right subtrees
        return isHeapProperty(root.left) && isHeapProperty(root.right);
    }

    // Method to build a tree from level order input
    private Node buildTree(List<Integer> levelOrder) {
        if (levelOrder.isEmpty() || levelOrder.get(0) == -1) return null;

        Node root = new Node(levelOrder.get(0));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < levelOrder.size()) {
            Node current = queue.poll();

            // Add left child
            if (levelOrder.get(i) != -1) {
                current.left = new Node(levelOrder.get(i));
                queue.add(current.left);
            }
            i++;

            // Add right child
            if (i < levelOrder.size() && levelOrder.get(i) != -1) {
                current.right = new Node(levelOrder.get(i));
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Main method to take input and test
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q124_Is_Binary_Tree_Heap obj = new Q124_Is_Binary_Tree_Heap();

        System.out.println("Enter the number of test cases:");
        int t = sc.nextInt();
        while (t-- > 0) {
            System.out.println("Enter the level-order representation of the tree (use -1 for null):");
            List<Integer> levelOrder = new ArrayList<>();
            while (sc.hasNextInt()) {
                int val = sc.nextInt();
                levelOrder.add(val);
                if (sc.hasNextLine() && sc.nextLine().isEmpty()) break;
            }

            Node root = obj.buildTree(levelOrder);
            boolean result = obj.isHeap(root);
            System.out.println("Is the given tree a heap? " + result);
        }

        sc.close();
    }
}
