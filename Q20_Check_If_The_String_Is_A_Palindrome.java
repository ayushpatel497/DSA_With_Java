import java.util.Scanner;

public class Q20_Check_If_The_String_Is_A_Palindrome {

    // Method to check if the given string is a palindrome, ignoring special characters and case
    public static boolean checkPalindrome(String str) {
        // Initialize a StringBuilder to hold the cleaned string (letters and digits only)
        StringBuilder cleanedStr = new StringBuilder();

        // Traverse the input string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Check if the character is alphanumeric (letters or digits) and add it to cleanedStr
            if (Character.isLetterOrDigit(ch)) {
                cleanedStr.append(Character.toLowerCase(ch)); // Convert to lowercase
            }
        }

        // Now, check if the cleaned string is a palindrome
        int s = 0;
        int e = cleanedStr.length() - 1;

        while (s < e) {
            // Compare characters from the start and end
            if (cleanedStr.charAt(s) != cleanedStr.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }

        return true; // If no mismatch found, the string is a palindrome
    }

    // Main method to take multiple test cases
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of test cases
        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();
        sc.nextLine();  // To consume the newline character after the integer input

        // Loop for multiple test cases
        for (int i = 0; i < t; i++) {
            // Read the string input
            System.out.print("Enter a string to check: ");
            String str = sc.nextLine();

            // Call the method to check if it's a palindrome
            boolean result = checkPalindrome(str);

            // Output the result
            if (result) {
                System.out.println("The string is a palindrome.");
            } else {
                System.out.println("The string is not a palindrome.");
            }
        }

        sc.close();
    }
}
