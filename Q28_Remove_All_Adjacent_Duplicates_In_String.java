import java.util.Scanner;

class Q28_Remove_All_Adjacent_Duplicates_In_String { 
    
    // Function to remove adjacent duplicates
    public String removeDuplicates(String s) {
        // Using StringBuilder as a stack
        StringBuilder stack = new StringBuilder();
        
        // Iterate through the string
        for (char c : s.toCharArray()) {
            // If stack is not empty and top of stack is equal to the current character, pop it
            if (stack.length() > 0 && stack.charAt(stack.length() - 1) == c) {
                stack.deleteCharAt(stack.length() - 1);  // Simulate popping from stack
            } else {
                stack.append(c);  // Otherwise, push the current character
            }
        }
        
        // Return the final string after removing duplicates
        return stack.toString();
    }

    // Main method to handle multiple test cases
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of test cases: ");
        int testCases = sc.nextInt();
        sc.nextLine();  // Consume the newline character
        
        Q28_Remove_All_Adjacent_Duplicates_In_String remover = new Q28_Remove_All_Adjacent_Duplicates_In_String();
        
        for (int t = 0; t < testCases; t++) {
            System.out.print("Enter the string for test case " + (t + 1) + ": ");
            String input = sc.nextLine();
            
            String result = remover.removeDuplicates(input);
            
            System.out.println("Result after removing duplicates for test case " + (t + 1) + ": " + result);
        }
        
        sc.close();
    }
}