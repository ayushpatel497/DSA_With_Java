class Q188_Best_Time_To_Buy_And_Sell_Stock_4 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        // If k >= n/2, it's the same as unlimited transactions
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        // DP array to store profits
        int[][] dp = new int[k + 1][n];

        // Fill DP table
        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0]; // Max difference between dp[i-1][t] and prices[t]
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
            }
        }

        return dp[k][n - 1];
    }

    public static void main(String[] args) {
        Q188_Best_Time_To_Buy_And_Sell_Stock_4 obj = new Q188_Best_Time_To_Buy_And_Sell_Stock_4();

        // Test cases
        System.out.println(obj.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3})); // Output: 7
        System.out.println(obj.maxProfit(1, new int[]{3, 2, 6, 5, 0, 3})); // Output: 4
        System.out.println(obj.maxProfit(3, new int[]{2, 4, 1}));           // Output: 2
    }
}
