import java.util.*;

public class Q165_0_1_Knapsack {
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        // Create a 2D DP array
        int[][] dp = new int[n + 1][maxWeight + 1];

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= maxWeight; w++) {
                if (weight[i - 1] <= w) { // Item can be included
                    dp[i][w] = Math.max(dp[i - 1][w], value[i - 1] + dp[i - 1][w - weight[i - 1]]);
                } else { // Item cannot be included
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // The last cell of the DP table contains the maximum value
        return dp[n][maxWeight];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of test cases
        int t = sc.nextInt();

        while (t-- > 0) {
            // Read number of items
            int n = sc.nextInt();

            // Read weights and values
            int[] weight = new int[n];
            int[] value = new int[n];
            for (int i = 0; i < n; i++) {
                weight[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                value[i] = sc.nextInt();
            }

            // Read the maximum weight the knapsack can carry
            int maxWeight = sc.nextInt();

            // Calculate and print the result
            System.out.println(knapsack(weight, value, n, maxWeight));
        }

        sc.close();
    }
}
