import java.util.Scanner;

public class Q26_Permutation_In_String {

    // Function to check if a permutation of s1 exists as a substring in s2
    public boolean checkInclusion(String s1, String s2) {
        // Edge case: If s1 is longer than s2, it's impossible for s1 to be a permutation of any substring in s2
        if (s1.length() > s2.length()) {
            return false;
        }

        // Frequency arrays for s1 and the sliding window in s2
        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        // Populate frequency array for s1
        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        // Populate initial window of size s1.length() in s2
        for (int i = 0; i < s1.length(); i++) {
            windowFreq[s2.charAt(i) - 'a']++;
        }

        // Check the initial window
        if (matches(s1Freq, windowFreq)) {
            return true;
        }

        // Slide the window over s2
        for (int i = s1.length(); i < s2.length(); i++) {
            // Add the current character to the window
            windowFreq[s2.charAt(i) - 'a']++;
            // Remove the leftmost character of the previous window
            windowFreq[s2.charAt(i - s1.length()) - 'a']--;

            // Check if the current window matches the frequency array of s1
            if (matches(s1Freq, windowFreq)) {
                return true;
            }
        }

        return false; // No matching permutation found
    }

    // Helper function to check if two frequency arrays match
    private boolean matches(int[] s1Freq, int[] windowFreq) {
        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] != windowFreq[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Taking input for multiple test cases
        System.out.print("Enter the number of test cases: ");
        int testCases = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        Q26_Permutation_In_String permutationChecker = new Q26_Permutation_In_String();

        for (int t = 0; t < testCases; t++) {
            System.out.print("Enter string s1 for test case " + (t + 1) + ": ");
            String s1 = sc.nextLine();
            System.out.print("Enter string s2 for test case " + (t + 1) + ": ");
            String s2 = sc.nextLine();

            boolean result = permutationChecker.checkInclusion(s1, s2);
            System.out.println("Result for test case " + (t + 1) + ": " + result);
        }

        sc.close(); // Close the scanner
    }
}
