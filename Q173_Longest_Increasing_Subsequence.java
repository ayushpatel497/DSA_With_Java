import java.util.*;

public class Q173_Longest_Increasing_Subsequence {
    // Function to find length of longest increasing subsequence.
    static int longestSubsequence(int arr[]) {
        int n = arr.length;

        // Base case: If the array is empty
        if (n == 0) return 0;

        // Create a dp array to store the LIS values
        int[] dp = new int[n];

        // Initialize each position with 1 (minimum LIS for each element)
        Arrays.fill(dp, 1);

        int maxLIS = 1;

        // Build the dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // Update the maximum LIS found so far
            maxLIS = Math.max(maxLIS, dp[i]);
        }

        return maxLIS;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            System.out.print("Enter the size of the array: ");
            int n = sc.nextInt();
            int[] arr = new int[n];

            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int result = longestSubsequence(arr);
            System.out.println("Length of Longest Increasing Subsequence: " + result);
        }

        sc.close();
    }
}
