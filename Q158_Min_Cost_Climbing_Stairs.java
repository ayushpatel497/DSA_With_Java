import java.util.*;

class Q158_Min_Cost_Climbing_Stairs {
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        // Handle edge cases where the input array has less than 2 steps
        if (n == 1) return cost[0];
        if (n == 2) return Math.min(cost[0], cost[1]);

        // DP array to store the minimum cost to reach each step
        int[] dp = new int[n];

        // Base cases
        dp[0] = cost[0];
        dp[1] = cost[1];

        // Fill the DP array
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        // The result is the minimum cost to reach the top, which can be from the last or second-last step
        return Math.min(dp[n - 1], dp[n - 2]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of test cases
        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            // Read number of steps in the current test case
            System.out.print("Enter number of steps: ");
            int n = sc.nextInt();

            // Read the cost array
            int[] cost = new int[n];
            System.out.print("Enter the cost array: ");
            for (int i = 0; i < n; i++) {
                cost[i] = sc.nextInt();
            }

            // Compute the result for the current test case
            int result = minCostClimbingStairs(cost);
            System.out.println("Minimum cost to climb stairs: " + result);
        }

        sc.close();
    }
}
