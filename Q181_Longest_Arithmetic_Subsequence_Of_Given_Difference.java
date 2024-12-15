import java.io.*;
import java.util.*;

class Q181_Longest_Arithmetic_Subsequence_Of_Given_Difference {
    public int longestSubsequence(int[] arr, int difference) {
        // Initialize the dp array
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Each element is a subsequence of length 1
        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Check if arr[i] - arr[j] equals the given difference
                if (arr[i] - arr[j] == difference) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // Update the maximum length
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of test cases:");
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            System.out.println("Enter the size of the array:");

            System.out.println("Enter the elements of the array:");
            int[] arr = Arrays.stream(br.readLine().split(" "))
                              .mapToInt(Integer::parseInt)
                              .toArray();

            System.out.println("Enter the difference:");
            int difference = Integer.parseInt(br.readLine());

            Q181_Longest_Arithmetic_Subsequence_Of_Given_Difference obj = new Q181_Longest_Arithmetic_Subsequence_Of_Given_Difference();
            int result = obj.longestSubsequence(arr, difference);

            System.out.println("Length of the longest arithmetic subsequence: " + result);
        }
    }
}
