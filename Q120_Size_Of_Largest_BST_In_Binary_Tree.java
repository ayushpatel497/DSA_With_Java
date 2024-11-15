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

public class Q120_Size_Of_Largest_BST_In_Binary_Tree {

    static class SubtreeInfo {
        boolean isBST;
        int size;
        int min;
        int max;

        SubtreeInfo(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int largestBST(TreeNode root) {
        return largestBSTHelper(root).size;
    }

    private static SubtreeInfo largestBSTHelper(TreeNode node) {
        if (node == null) {
            return new SubtreeInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        SubtreeInfo leftInfo = largestBSTHelper(node.left);
        SubtreeInfo rightInfo = largestBSTHelper(node.right);

        if (leftInfo.isBST && rightInfo.isBST && node.data > leftInfo.max && node.data < rightInfo.min) {
            int size = leftInfo.size + rightInfo.size + 1;
            int min = Math.min(node.data, leftInfo.min);
            int max = Math.max(node.data, rightInfo.max);
            return new SubtreeInfo(true, size, min, max);
        }

        return new SubtreeInfo(false, Math.max(leftInfo.size, rightInfo.size), 0, 0);
    }

    private static TreeNode buildTreeFromLevelOrder(String[] values) {
        if (values.length == 0 || values[0].equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (i < values.length) {
            TreeNode current = queue.poll();
            if (!values[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(values[i]));
                queue.add(current.left);
            }
            i++;
            if (i < values.length && !values[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(values[i]));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (int testCase = 1; testCase <= t; testCase++) {
            System.out.print("Enter the tree nodes in level-order (use 'null' for empty nodes): ");
            String input = sc.nextLine();
            String[] values = input.split(" ");
            TreeNode root = buildTreeFromLevelOrder(values);

            int largestBSTSize = largestBST(root);
            System.out.println("Size of largest BST in given binary tree (Test case " + testCase + "): " + largestBSTSize);
        }
        sc.close();
    }
}
