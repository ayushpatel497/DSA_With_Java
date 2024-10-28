import java.util.*;

public class Q65_Insert_An_Element_At_Its_Bottom_In_A_Given_Stack {

    // Function to insert an element at the bottom of the stack
    public static Stack<Integer> pushAtBottom(Stack<Integer> myStack, int x) {
        // Base case: if stack is empty, push x and return
        if (myStack.isEmpty()) {
            myStack.push(x);
            return myStack;
        }
        
        // Hold all elements by popping, then insert x at the bottom
        int temp = myStack.pop();
        pushAtBottom(myStack, x);
        
        // Push the popped elements back onto the stack
        myStack.push(temp);
        return myStack;
    }

    // Helper function to print the stack from top to bottom
    public static void printStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        while (!tempStack.isEmpty()) {
            System.out.print(tempStack.peek() + " ");
            stack.push(tempStack.pop());
        }
        System.out.println();
    }

    // Main function to handle multiple test cases
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            Stack<Integer> stack = new Stack<>();
            
            System.out.print("Enter the number of elements in the stack: ");
            int n = scanner.nextInt();
            
            System.out.println("Enter the elements of the stack:");
            for (int i = 0; i < n; i++) {
                stack.push(scanner.nextInt());
            }

            System.out.print("Enter the element to push at the bottom: ");
            int x = scanner.nextInt();

            // Insert element at the bottom and print the updated stack
            stack = pushAtBottom(stack, x);
            System.out.println("Stack after pushing " + x + " at the bottom:");
            printStack(stack);
        }
        
        scanner.close();
    }
}
