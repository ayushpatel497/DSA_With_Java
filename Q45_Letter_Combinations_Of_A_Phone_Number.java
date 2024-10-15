import java.util.*;

public class Q45_Letter_Combinations_Of_A_Phone_Number {
    
    // Mapping of digits to corresponding letters (as on a traditional phone keypad)
    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };
    
    // Function to get all letter combinations for the given digits
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        StringBuilder combination = new StringBuilder();
        generateCombinations(0, digits, combination, result);
        return result;
    }

    // Recursive function to generate combinations
    private void generateCombinations(int index, String digits, StringBuilder combination, List<String> result) {
        // Base case: If we've considered all digits
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }

        // Get the current digit
        int digit = digits.charAt(index) - '0';
        String letters = KEYPAD[digit];  // Get the corresponding letters for the digit

        // Recursive case: Add each letter to the current combination
        for (char letter : letters.toCharArray()) {
            combination.append(letter);
            generateCombinations(index + 1, digits, combination, result);
            combination.deleteCharAt(combination.length() - 1);  // Backtrack
        }
    }

    // Main function to handle multiple test cases
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of test cases
        System.out.print("Enter the number of test cases: ");
        int testCases = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (int t = 0; t < testCases; t++) {
            // Input digits
            System.out.print("Enter the digits: ");
            String digits = scanner.nextLine();

            // Get the letter combinations
            Q45_Letter_Combinations_Of_A_Phone_Number obj = new Q45_Letter_Combinations_Of_A_Phone_Number();
            List<String> combinations = obj.letterCombinations(digits);

            // Output the result
            System.out.println("Letter combinations:");
            for (String combination : combinations) {
                System.out.println(combination);
            }
        }
        scanner.close();
    }
}