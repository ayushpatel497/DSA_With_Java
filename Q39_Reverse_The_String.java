import java.util.Scanner;

public class Q39_Reverse_The_String {
    
    // Recursive function to reverse the string
    public static String reverseString(String str) {
        // Base case: if the string is empty or has one character, return it
        if (str.isEmpty()) {
            return str;
        }

        // Recursive case: reverse the substring from the second character onward,
        // then add the first character at the end
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of test cases
        System.out.print("Enter the number of test cases: ");
        int testCases = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        for (int t = 0; t < testCases; t++) {
            // Input the string to be reversed
            System.out.print("Enter the string to reverse: ");
            String str = scanner.nextLine();

            // Call the recursive reverse function
            String reversedStr = reverseString(str);

            // Output the result
            System.out.println("Reversed String: " + reversedStr);
        }

        scanner.close();
    }
}
