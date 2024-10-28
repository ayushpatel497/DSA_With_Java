import java.util.*;

public class Q64_Valid_Parentheses {

    public static boolean isValidParenthesis(String s) {
        // Initialize a stack to hold opening parentheses
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the string
        for (char ch : s.toCharArray()) {
            // Push opening brackets onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // Check closing brackets for matching pairs
            else if (ch == ')' || ch == '}' || ch == ']') {
                // If the stack is empty or top element doesn’t match, return false
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                    return false;
                }
            }
        }

        // If the stack is empty, parentheses are balanced
        return stack.isEmpty();
    }

    // Helper function to check if characters are a matching pair
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') || 
               (open == '{' && close == '}') || 
               (open == '[' && close == ']');
    }

    // Main method to handle input and test cases
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Iterate through each test case
        for (int t = 1; t <= testCases; t++) {
            System.out.print("Enter the parentheses string for test case " + t + ": ");
            String s = scanner.nextLine();
            boolean isValid = isValidParenthesis(s);
            System.out.println("Test case " + t + " result: " + (isValid ? "Balanced" : "Not Balanced"));
        }

        scanner.close();
    }
}
