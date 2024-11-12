import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class Q112_Predecessor_And_Successor_In_BST {
    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        TreeNode predecessor = null, successor = null;
        TreeNode current = root;
        
        // Find predecessor and successor
        while (current != null) {
            if (key < current.data) {
                successor = current;
                current = current.left;
            } else if (key > current.data) {
                predecessor = current;
                current = current.right;
            } else {
                // Node with 'key' found
                if (current.left != null) {
                    TreeNode temp = current.left;
                    while (temp.right != null) {
                        temp = temp.right;
                    }
                    predecessor = temp;
                }
                if (current.right != null) {
                    TreeNode temp = current.right;
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    successor = temp;
                }
                break;
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(predecessor != null ? predecessor.data : -1); // Add predecessor
        result.add(successor != null ? successor.data : -1); // Add successor
        return result;
    }

    public static TreeNode insertIntoBST(TreeNode root, int data) {
        if (root == null) return new TreeNode(data);
        if (data < root.data) root.left = insertIntoBST(root.left, data);
        else root.right = insertIntoBST(root.right, data);
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of test cases: ");
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            System.out.print("\nEnter number of nodes in BST: ");
            int n = scanner.nextInt();
            
            TreeNode root = null;
            System.out.print("Enter nodes of BST: ");
            for (int i = 0; i < n; i++) {
                int data = scanner.nextInt();
                root = insertIntoBST(root, data);
            }
            
            System.out.print("Enter key to find predecessor and successor: ");
            int key = scanner.nextInt();
            
            List<Integer> result = predecessorSuccessor(root, key);
            System.out.println("Predecessor: " + (result.get(0) == -1 ? "NULL" : result.get(0)));
            System.out.println("Successor: " + (result.get(1) == -1 ? "NULL" : result.get(1)));
        }
        
        scanner.close();
    }
}