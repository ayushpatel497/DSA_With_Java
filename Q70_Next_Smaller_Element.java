import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Q70_Next_Smaller_Element {

    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> result = new ArrayList<>(n);

        // Initialize result array with -1 for each element
        for (int i = 0; i < n; i++) {
            result.add(-1);
        }

        // Stack to store elements in order to find the next smaller
        Stack<Integer> stack = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            int current = arr.get(i);

            // Pop elements that are not smaller than the current one
            while (!stack.isEmpty() && stack.peek() >= current) {
                stack.pop();
            }

            // If stack is not empty, set the top as the next smaller element
            if (!stack.isEmpty()) {
                result.set(i, stack.peek());
            }

            // Push the current element onto the stack
            stack.push(current);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of test cases: ");
        int testCases = scanner.nextInt();
        
        while (testCases-- > 0) {
            System.out.print("Enter the size of the array: ");
            int n = scanner.nextInt();
            
            ArrayList<Integer> arr = new ArrayList<>(n);
            System.out.print("Enter the elements of the array: ");
            for (int i = 0; i < n; i++) {
                arr.add(scanner.nextInt());
            }
            
            ArrayList<Integer> result = nextSmallerElement(arr, n);
            
            System.out.println("Next smaller elements:");
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}
