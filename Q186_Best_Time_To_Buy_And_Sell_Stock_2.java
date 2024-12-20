class Q186_Best_Time_To_Buy_And_Sell_Stock_2 {
    public int maxProfit(int[] prices) {
        // Base case: No profit possible if prices array is empty
        if (prices == null || prices.length < 2) return 0;

        int maxProfit = 0; // Total profit

        // Iterate through the prices array
        for (int i = 1; i < prices.length; i++) {
            // If there's an increase in price, add the difference to maxProfit
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit; // Total maximum profit
    }

    public static void main(String[] args) {
        Q186_Best_Time_To_Buy_And_Sell_Stock_2 obj = new Q186_Best_Time_To_Buy_And_Sell_Stock_2();

        // Test cases
        System.out.println(obj.maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // Output: 7
        System.out.println(obj.maxProfit(new int[]{1, 2, 3, 4, 5}));   // Output: 4
        System.out.println(obj.maxProfit(new int[]{7, 6, 4, 3, 1}));   // Output: 0
    }
}
