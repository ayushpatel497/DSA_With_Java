class Q187_Best_Time_To_Buy_And_Sell_Stock_3 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int n = prices.length;

        // Arrays to store profits
        int[] leftProfit = new int[n];
        int[] rightProfit = new int[n];

        // Forward pass: Calculate max profit for the first transaction
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - minPrice);
        }

        // Backward pass: Calculate max profit for the second transaction
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            rightProfit[i] = Math.max(rightProfit[i + 1], maxPrice - prices[i]);
        }

        // Combine results to find the maximum profit with at most two transactions
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, leftProfit[i] + rightProfit[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Q187_Best_Time_To_Buy_And_Sell_Stock_3 obj = new Q187_Best_Time_To_Buy_And_Sell_Stock_3();

        // Test cases
        System.out.println(obj.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4})); // Output: 6
        System.out.println(obj.maxProfit(new int[]{1, 2, 3, 4, 5}));         // Output: 4
        System.out.println(obj.maxProfit(new int[]{7, 6, 4, 3, 1}));         // Output: 0
    }
}
