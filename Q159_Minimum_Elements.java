import java.util.*;

public class Q159_Minimum_Elements {
    public static int minimumElements(int num[], int x) {
        // Initialize the dp array with a large value (infinity)
        int[] dp = new int[x + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // Base case: The minimum number of elements to make sum 0 is 0
        dp[0] = 0;

        // Iterate over each sum from 1 to x
        for (int i = 1; i <= x; i++) {
            // Iterate over all array elements
            for (int n : num) {
                if (i >= n && dp[i - n] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - n] + 1);
                }
            }
        }

        // If the target sum cannot be formed, return -1
        return dp[x] == Integer.MAX_VALUE ? -1 : dp[x];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of test cases
        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            // Read the size of the array and the target sum
            System.out.print("Enter size of array and target sum: ");
            int n = sc.nextInt();
            int x = sc.nextInt();

            // Read the array elements
            System.out.print("Enter array elements: ");
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = sc.nextInt();
            }

            // Calculate and print the result
            int result = minimumElements(num, x);
            System.out.println("Minimum number of elements: " + (result == -1 ? "Not Possible" : result));
        }

        sc.close();
    }
}
