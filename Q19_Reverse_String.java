import java.util.*;

class Q19_Reverse_String {
    
    // Method to reverse a given string (character array)
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while(start < end){
            // Swap the characters at start and end pointers
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    // Main method to take multiple test cases
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of test cases
        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();
        sc.nextLine();  // To consume the newline character after integer input

        Q19_Reverse_String reverser = new Q19_Reverse_String();

        // Loop for multiple test cases
        for (int test = 0; test < t; test++) {
            // Read the string input as a character array
            System.out.print("Enter a string to reverse: ");
            String input = sc.nextLine();
            char[] charArray = input.toCharArray(); // Convert string to character array

            // Call the method to reverse the string
            reverser.reverseString(charArray);

            // Output the reversed string
            System.out.print("Reversed string: ");
            System.out.println(new String(charArray)); // Convert char array back to string and print
        }

        sc.close();
    }
}