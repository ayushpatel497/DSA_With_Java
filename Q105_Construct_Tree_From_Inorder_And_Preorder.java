import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Q105_Construct_Tree_From_Inorder_And_Preorder {

    public static Node buildTree(int[] inorder, int[] preorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;

        int n = preorder.length;
        Stack<Node> stack = new Stack<>();
        Node root = new Node(preorder[0]);
        stack.push(root);
        int preIndex = 1, inIndex = 0;

        while (preIndex < n) {
            Node currentNode = null;

            // Traverse the stack to find the correct position for the next node
            while (!stack.isEmpty() && stack.peek().data == inorder[inIndex]) {
                currentNode = stack.pop();
                inIndex++;
            }

            // Create a new node for the current preorder element
            Node newNode = new Node(preorder[preIndex]);

            if (currentNode != null) {
                currentNode.right = newNode;
            } else {
                stack.peek().left = newNode;
            }

            stack.push(newNode);
            preIndex++;
        }

        return root;
    }

    // Function to print postorder traversal
    public static void printPostOrder(Node node) {
        if (node == null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data + " ");
    }

    // Main function to handle test cases
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            System.out.println("Enter size of inorder and preorder arrays:");
            int n = scanner.nextInt();

            int[] inorder = new int[n];
            int[] preorder = new int[n];

            System.out.println("Enter inorder traversal:");
            for (int j = 0; j < n; j++) {
                inorder[j] = scanner.nextInt();
            }

            System.out.println("Enter preorder traversal:");
            for (int j = 0; j < n; j++) {
                preorder[j] = scanner.nextInt();
            }

            Node root = buildTree(inorder, preorder);

            System.out.println("Postorder traversal of constructed tree:");
            printPostOrder(root);
            System.out.println();
        }

        scanner.close();
    }
}
