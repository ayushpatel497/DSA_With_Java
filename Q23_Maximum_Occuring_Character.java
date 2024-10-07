import java.util.Scanner;

class Q23_Maximum_Occuring_Character {

    // Function to find the maximum occurring character in a string
    public static char getMaxOccuringChar(String line) {
        int[] frequency = new int[26]; // Array to store frequency of each letter (a-z)

        // Iterate through each character in the string
        for (char c : line.toCharArray()) {
            // Ignore spaces and convert uppercase to lowercase
            if (c != ' ') {
                // Convert to lowercase and update frequency
                frequency[Character.toLowerCase(c) - 'a']++;
            }
        }

        char maxChar = ' ';
        int maxCount = 0;

        // Find the character with the maximum frequency
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > maxCount) {
                maxCount = frequency[i];
                maxChar = (char) (i + 'a'); // Convert back to character
            }
        }

        return maxChar;
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
            char result = getMaxOccuringChar(inputString);
            System.out.println("Maximum occurring character for test case " + (t + 1) + ": " + result);
        }
        
        sc.close(); // Close the scanner
    }
}

