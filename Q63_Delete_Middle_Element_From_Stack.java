import java.util.*;

public class Q63_Delete_Middle_Element_From_Stack {

    // Function to delete the middle element from the stack
    public static void deleteMiddle(Stack<Integer> inputStack, int N) {
        int middleIndex = (N + 1) / 2 - 1; // Calculate the 0-based middle index
        deleteMiddleHelper(inputStack, middleIndex);
    }

    // Helper function to delete the middle element using recursion
    private static void deleteMiddleHelper(Stack<Integer> stack, int currentIndex) {
        // Base case: when we reach the middle element
        if (currentIndex == 0) {
            stack.pop();
            return;
        }

        // Remove the top element and store it temporarily
        int topElement = stack.pop();

        // Recursive call to reach the middle element
        deleteMiddleHelper(stack, currentIndex - 1);

        // Push the element back after the middle element has been removed
        stack.push(topElement);
    }

    // Main function to handle multiple test cases
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            System.out.println("\nTest Case " + (t + 1) + ":");
            System.out.print("Enter the size of the stack (N): ");
            int n = scanner.nextInt();

            Stack<Integer> stack = new Stack<>();
            System.out.println("Enter " + (n + 1) + " elements for the stack:");
            for (int i = 0; i < n + 1; i++) {
                stack.push(scanner.nextInt());
            }

            System.out.println("Original Stack: " + stack);

            deleteMiddle(stack, n);

            System.out.println("Stack after deleting middle element: " + stack);
        }

        scanner.close();
    }
}
