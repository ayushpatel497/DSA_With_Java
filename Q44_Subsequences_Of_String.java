import java.util.*;

public class Q44_Subsequences_Of_String {

    // Recursive function to generate subsequences
    private static void generateSubsequences(int index, String str, StringBuilder temp, ArrayList<String> result) {
        // Base case: If we've considered all characters
        if (index == str.length()) {
            // If the subsequence is non-empty, add it to the result
            if (temp.length() > 0) {
                result.add(temp.toString());
            }
            return;
        }

        // Recursive case 1: Include the current character
        temp.append(str.charAt(index));
        generateSubsequences(index + 1, str, temp, result);

        // Recursive case 2: Exclude the current character (backtrack)
        temp.deleteCharAt(temp.length() - 1);
        generateSubsequences(index + 1, str, temp, result);
    }

    // Function to generate all subsequences of a given string
    public static ArrayList<String> subsequences(String str) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder temp = new StringBuilder();  // To store each subsequence
        generateSubsequences(0, str, temp, result);  // Call the recursive function
        return result;
    }

    // Main function to take multiple test cases
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of test cases
        System.out.print("Enter the number of test cases: ");
        int testCases = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        for (int t = 0; t < testCases; t++) {
            // Input string
            System.out.print("Enter the string: ");
            String str = scanner.nextLine();

            // Get all subsequences
            ArrayList<String> subsequences = subsequences(str);

            // Print the subsequences
            System.out.println("Subsequences:");
            for (String subsequence : subsequences) {
                System.out.println(subsequence);
            }
        }

        scanner.close();
    }
}
