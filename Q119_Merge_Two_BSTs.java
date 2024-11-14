import java.util.*;

/*********************************************************
 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int val) {
         this.data = val;
         this.left = null;
         this.right = null;
     }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.data = val;
         this.left = left;
         this.right = right;
     }
 };
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
    TreeNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.data = val;
        this.left = left;
        this.right = right;
    }
}

public class Q119_Merge_Two_BSTs {

    public static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        List<Integer> mergedList = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        pushLeftNodes(root1, stack1);
        pushLeftNodes(root2, stack2);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            Stack<TreeNode> smallerStack;
            if (stack1.isEmpty()) {
                smallerStack = stack2;
            } else if (stack2.isEmpty()) {
                smallerStack = stack1;
            } else {
                smallerStack = (stack1.peek().data < stack2.peek().data) ? stack1 : stack2;
            }
            TreeNode node = smallerStack.pop();
            mergedList.add(node.data);
            pushLeftNodes(node.right, smallerStack);
        }
        
        return mergedList;
    }

    private static void pushLeftNodes(TreeNode node, Stack<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    private static TreeNode insertIntoBST(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }
        if (data < root.data) {
            root.left = insertIntoBST(root.left, data);
        } else {
            root.right = insertIntoBST(root.right, data);
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();

        for (int testCase = 1; testCase <= t; testCase++) {
            System.out.println("\nTest case #" + testCase + ":");
            
            // Input for the first BST
            System.out.print("Enter number of nodes in first BST: ");
            int n1 = sc.nextInt();
            TreeNode root1 = null;
            System.out.println("Enter the nodes for the first BST:");
            for (int i = 0; i < n1; i++) {
                int data = sc.nextInt();
                root1 = insertIntoBST(root1, data);
            }

            // Input for the second BST
            System.out.print("Enter number of nodes in second BST: ");
            int n2 = sc.nextInt();
            TreeNode root2 = null;
            System.out.println("Enter the nodes for the second BST:");
            for (int i = 0; i < n2; i++) {
                int data = sc.nextInt();
                root2 = insertIntoBST(root2, data);
            }

            // Merging the two BSTs and displaying the result
            List<Integer> mergedList = mergeBST(root1, root2);
            System.out.println("Merged BST elements in sorted order: " + mergedList);
        }

        sc.close();
    }
}
