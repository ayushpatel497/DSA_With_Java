import java.util.*;

public class Q166_Combination_Sum_4 {
    public static int findWays(int[] num, int tar) {
        // Create a DP array to store the number of ways to reach each target
        int[] dp = new int[tar + 1];

        // Base case: One way to form a sum of 0 (by choosing no elements)
        dp[0] = 1;

        // Iterate over all targets from 1 to 'tar'
        for (int t = 1; t <= tar; t++) {
            // Iterate over all numbers in the array
            for (int n : num) {
                if (t >= n) { // If current target is at least the current number
                    dp[t] += dp[t - n];
                }
            }
        }

        return dp[tar];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of test cases
        int t = sc.nextInt();

        while (t-- > 0) {
            // Read target and size of array
            int tar = sc.nextInt();
            int n = sc.nextInt();

            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = sc.nextInt();
            }

            // Output the number of ways
            System.out.println(findWays(num, tar));
        }

        sc.close();
    }
}
