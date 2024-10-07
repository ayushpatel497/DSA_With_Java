import java.util.Scanner;

public class Q24_Replace_Spaces {

    public static StringBuilder replaceSpaces(StringBuilder str) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            // If the character is a space, append "%20" to the result
            if (currentChar == ' ') {
                result.append("%20");
            } else {
                // Otherwise, append the character itself
                result.append(currentChar);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Taking input for multiple test cases
        System.out.print("Enter the number of test cases: ");
        int testCases = sc.nextInt();
        sc.nextLine(); // Consume the newline character after reading the number

        // Processing each test case
        for (int t = 0; t < testCases; t++) {
            System.out.print("Enter the string for test case " + (t + 1) + ": ");
            String inputString = sc.nextLine();
            StringBuilder strBuilder = new StringBuilder(inputString);
            StringBuilder result = replaceSpaces(strBuilder);
            System.out.println("Result for test case " + (t + 1) + ": " + result);
        }

        sc.close(); // Close the scanner
    }
}
