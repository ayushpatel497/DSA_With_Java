import java.util.Scanner;

/*********************************************************
 Following is the TreeNode structure:
 ********************************************************/
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

public class Q114_LCA_Of_Two_Nodes_In_A_BST {
    
    public static TreeNode LCAinaBST(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        while (root != null) {
            if (p.data < root.data && q.data < root.data) {
                // Both nodes are in the left subtree
                root = root.left;
            } else if (p.data > root.data && q.data > root.data) {
                // Both nodes are in the right subtree
                root = root.right;
            } else {
                // We have found the split point, i.e., the LCA node
                return root;
            }
        }
        return null; // If no LCA found (shouldn't happen in valid BST with p and q existing)
    }
    
    // Helper method to insert nodes into the BST
    public static TreeNode insertIntoBST(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }
        if (data < root.data) {
            root.left = insertIntoBST(root.left, data);
        } else if (data > root.data) {
            root.right = insertIntoBST(root.right, data);
        }
        return root;
    }

    public static TreeNode findNode(TreeNode root, int data) {
        while (root != null) {
            if (data < root.data) {
                root = root.left;
            } else if (data > root.data) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null; // Node not found
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
            
            System.out.print("Enter the values of nodes P and Q to find LCA: ");
            int pData = scanner.nextInt();
            int qData = scanner.nextInt();
            
            TreeNode p = findNode(root, pData);
            TreeNode q = findNode(root, qData);
            
            TreeNode lca = LCAinaBST(root, p, q);
            System.out.println("LCA of nodes " + pData + " and " + qData + " is: " + (lca != null ? lca.data : "Not found"));
        }
        
        scanner.close();
    }
}
