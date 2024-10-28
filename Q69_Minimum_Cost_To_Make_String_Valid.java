import java.util.*;

public class Q69_Minimum_Cost_To_Make_String_Valid {

    public static int findMinimumCost(String str) {
        // If the length is odd, it’s impossible to balance, return -1
        if (str.length() % 2 != 0) {
            return -1;
        }

        // Stack to keep track of unmatched brackets
        Stack<Character> stack = new Stack<>();

        // Traverse through the string
        for (char ch : str.toCharArray()) {
            // If it's an opening bracket, push it onto the stack
            if (ch == '{') {
                stack.push(ch);
            } else {
                // If it's a closing bracket
                if (!stack.isEmpty() && stack.peek() == '{') {
                    // Match found, pop the opening bracket
                    stack.pop();
                } else {
                    // Unmatched closing bracket, push onto the stack
                    stack.push(ch);
                }
            }
        }

        // After the loop, the stack will have unmatched brackets
        int openCount = 0, closeCount = 0;
        
        // Count the unmatched opening and closing brackets
        while (!stack.isEmpty()) {
            if (stack.pop() == '{') {
                openCount++;
            } else {
                closeCount++;
            }
        }

        // Calculate the minimum operations required
        // Each two unmatched brackets need 1 operation
        int operations = (openCount + 1) / 2 + (closeCount + 1) / 2;

        return operations;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take number of test cases
        System.out.print("Enter the number of test cases: ");
        int testCases = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (int i = 1; i <= testCases; i++) {
            System.out.print("Enter the string: ");
            String str = scanner.nextLine();

            // Find and print the minimum cost to make the string valid
            int result = findMinimumCost(str);
            System.out.println("Minimum cost to make string valid: " + result);
        }

        scanner.close();
    }
}
