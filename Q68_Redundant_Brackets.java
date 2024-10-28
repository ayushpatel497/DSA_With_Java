import java.util.Stack;
import java.util.Scanner;

public class Q68_Redundant_Brackets {

    public static boolean findRedundantBrackets(String s) {
        // Stack to hold characters in the expression
        Stack<Character> stack = new Stack<>();
        
        // Traverse each character in the expression
        for (char ch : s.toCharArray()) {
            // If character is a closing bracket, check for redundancy
            if (ch == ')') {
                boolean isRedundant = true;
                
                // Pop elements until opening bracket '(' is found
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char top = stack.pop();
                    
                    // If an operator is found, the brackets are not redundant
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        isRedundant = false;
                    }
                }
                
                // Pop the opening bracket '('
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                
                // If no operator was found, it means brackets were redundant
                if (isRedundant) {
                    return true;
                }
            }
            // Push all other characters onto the stack
            else {
                stack.push(ch);
            }
        }
        
        // If no redundant brackets were found
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of test cases: ");
        int testCases = scanner.nextInt();
        scanner.nextLine();  // Consume newline character
        
        for (int t = 1; t <= testCases; t++) {
            System.out.print("Enter the expression: ");
            String expression = scanner.nextLine();
            
            // Check for redundant brackets
            boolean hasRedundantBrackets = findRedundantBrackets(expression);
            
            // Output result
            System.out.println("Does the expression contain redundant brackets? " + hasRedundantBrackets);
        }
        
        scanner.close();
    }
}
