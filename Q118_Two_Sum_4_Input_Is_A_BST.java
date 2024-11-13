import java.util.*;

/* 

    Following is the class used to represent the object/node of the Binary Tree

    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

*/

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Q118_Two_Sum_4_Input_Is_A_BST {
    
    // Method to check if there exists a pair with the given target sum
    public static boolean twoSumInBST(BinaryTreeNode<Integer> root, int target) {
        if (root == null) return false;

        Stack<BinaryTreeNode<Integer>> leftStack = new Stack<>();
        Stack<BinaryTreeNode<Integer>> rightStack = new Stack<>();

        BinaryTreeNode<Integer> left = root, right = root;
        
        while (left != null) {
            leftStack.push(left);
            left = left.left;
        }
        
        while (right != null) {
            rightStack.push(right);
            right = right.right;
        }

        while (!leftStack.isEmpty() && !rightStack.isEmpty()) {
            BinaryTreeNode<Integer> leftNode = leftStack.peek();
            BinaryTreeNode<Integer> rightNode = rightStack.peek();

            if (leftNode == rightNode) break;

            int sum = leftNode.data + rightNode.data;

            if (sum == target) {
                return true;
            } else if (sum < target) {
                left = leftStack.pop().right;
                while (left != null) {
                    leftStack.push(left);
                    left = left.left;
                }
            } else {
                right = rightStack.pop().left;
                while (right != null) {
                    rightStack.push(right);
                    right = right.right;
                }
            }
        }
        
        return false;
    }

    // Helper method to insert a node into the BST
    private static BinaryTreeNode<Integer> insertIntoBST(BinaryTreeNode<Integer> root, int data) {
        if (root == null) {
            return new BinaryTreeNode<>(data);
        }
        if (data < root.data) {
            root.left = insertIntoBST(root.left, data);
        } else {
            root.right = insertIntoBST(root.right, data);
        }
        return root;
    }

    // Main method for taking input and running test cases
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of nodes in the BST: ");
        int n = sc.nextInt();

        BinaryTreeNode<Integer> root = null;
        System.out.println("Enter the nodes:");
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            root = insertIntoBST(root, data);
        }

        System.out.print("Enter the target sum: ");
        int target = sc.nextInt();

        boolean result = twoSumInBST(root, target);
        System.out.println("Is there a pair with the target sum? " + result);

        sc.close();
    }
}
