import java.util.Scanner;

public class Q40_Check_If_Binary_Representation_Of_A_Number_Is_Palindrome {

    // Helper recursive function to check if the binary string is a palindrome
    private static boolean isBinaryPalindrome(String binaryStr, int start, int end) {
        // Base case: If start crosses end, it's a palindrome
        if (start >= end) {
            return true;
        }
        // If the characters at start and end are not the same, it's not a palindrome
        if (binaryStr.charAt(start) != binaryStr.charAt(end)) {
            return false;
        }
        // Recursive case: Check the next pair of characters
        return isBinaryPalindrome(binaryStr, start + 1, end - 1);
    }

    // Function to check if the binary representation of a number is a palindrome
    public static boolean checkPalindrome(long N) {
        // Convert the number to its binary string representation
        String binaryStr = Long.toBinaryString(N);

        // Call the recursive function to check if the binary string is a palindrome
        return isBinaryPalindrome(binaryStr, 0, binaryStr.length() - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of test cases
        System.out.print("Enter the number of test cases: ");
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            // Input the number to be checked
            System.out.print("Enter the number: ");
            long N = scanner.nextLong();

            // Check if the binary representation is a palindrome
            boolean result = checkPalindrome(N);

            // Output the result
            if (result) {
                System.out.println("The binary representation of " + N + " is a palindrome.");
            } else {
                System.out.println("The binary representation of " + N + " is NOT a palindrome.");
            }
        }

        scanner.close();
    }
}
