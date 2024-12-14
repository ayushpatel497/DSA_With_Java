import java.io.*;
import java.util.*;

class Q180_Longest_Arithmetic_Subsequence {
    int lengthOfLongestAP(Integer[] arr) {
        int n = arr.length;

        if (n <= 2) return n;

        // Create a table to store solutions of subproblems
        int[][] dp = new int[n][n];
        int maxLen = 2;

        // Initialize the last column as 2 (every pair with the last element forms an AP of length 2)
        for (int i = 0; i < n - 1; i++) {
            dp[i][n - 1] = 2;
        }

        // Fill dp table in bottom-up manner
        for (int j = n - 2; j >= 1; j--) {
            int i = j - 1;
            int k = j + 1;

            while (i >= 0 && k <= n - 1) {
                if (arr[i] + arr[k] == 2 * arr[j]) {
                    dp[i][j] = dp[j][k] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                    i--;
                    k++;
                } else if (arr[i] + arr[k] < 2 * arr[j]) {
                    k++;
                } else {
                    dp[i][j] = 2; // Default value if no progression exists
                    i--;
                }
            }

            // Fill remaining entries in column j
            while (i >= 0) {
                dp[i][j] = 2;
                i--;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of test cases:");
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            System.out.println("Enter the size of the array:");

            System.out.println("Enter the elements of the array:");
            Integer[] arr = Arrays.stream(br.readLine().split(" "))
                                   .map(Integer::parseInt)
                                   .toArray(Integer[]::new);

            Q180_Longest_Arithmetic_Subsequence obj = new Q180_Longest_Arithmetic_Subsequence();
            int result = obj.lengthOfLongestAP(arr);

            System.out.println("Length of the longest arithmetic progression: " + result);
        }
    }
}
