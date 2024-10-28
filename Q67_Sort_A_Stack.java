import java.util.Scanner;
import java.util.Stack;

public class Q67_Sort_A_Stack {
    
    // Function to sort the stack using recursion
    public static void sortStack(Stack<Integer> stack) {
        // Base case: if the stack is empty, return
        if (stack.isEmpty()) {
            return;
        }
        
        // Remove the top element
        int topElement = stack.pop();
        
        // Sort the remaining stack
        sortStack(stack);
        
        // Insert the removed element back in sorted order
        insertInSortedOrder(stack, topElement);
    }
    
    // Helper function to insert an element in sorted order
    public static void insertInSortedOrder(Stack<Integer> stack, int value) {
        // Base case: if the stack is empty or the value is greater than the top element, push it
        if (stack.isEmpty() || value > stack.peek()) {
            stack.push(value);
            return;
        }
        
        // Hold the top element and recurse
        int topElement = stack.pop();
        insertInSortedOrder(stack, value);
        
        // Put the held element back on top
        stack.push(topElement);
    }
    
    // Function to print the stack from top to bottom
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

            // Sort the stack and print it
            sortStack(stack);
            System.out.println("Sorted stack:");
            printStack(stack);
        }

        scanner.close();
    }
}
