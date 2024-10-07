import java.util.Scanner;

class Q21_Valid_Palindrome {
    // Function to check if the string is a palindrome
    public boolean isPalindrome(String s) {
        // Create a StringBuilder to store the cleaned string
        StringBuilder newS = new StringBuilder();

        // Traverse the original string and append only alphanumeric characters to newS
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Check if the character is a letter or digit
            if (Character.isLetterOrDigit(c)) {
                // Convert to lowercase and append to newS
                newS.append(Character.toLowerCase(c));
            }
        }

        // Now check if newS is a palindrome by using two-pointer technique
        int beg = 0;                     // Start pointer
        int end = newS.length() - 1;      // End pointer

        // Compare characters from the start and end of the cleaned string
        while (beg < end) {
            if (newS.charAt(beg) != newS.charAt(end)) {
                return false;  // Not a palindrome if mismatch occurs
            }
            beg++;
            end--;
        }

        // If no mismatch, the string is a palindrome
        return true;
    }

    // Main function to handle multiple test cases
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q21_Valid_Palindrome checker = new Q21_Valid_Palindrome();

        // Input: number of test cases
        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();
        sc.nextLine();  // Consume the newline character after the integer input

        // Process each test case
        for (int i = 0; i < t; i++) {
            System.out.println("Enter the string for test case " + (i + 1) + ": ");
            String s = sc.nextLine();

            // Check if the string is a valid palindrome and print the result
            if (checker.isPalindrome(s)) {
                System.out.println("Test case " + (i + 1) + ": The string is a palindrome.");
            } else {
                System.out.println("Test case " + (i + 1) + ": The string is not a palindrome.");
            }
        }

        sc.close(); // Close the scanner
    }
}

