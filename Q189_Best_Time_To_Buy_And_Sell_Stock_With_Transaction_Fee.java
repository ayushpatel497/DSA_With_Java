class Q189_Best_Time_To_Buy_And_Sell_Stock_With_Transaction_Fee {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        // Base states
        int hold = -prices[0]; // Profit when holding a stock
        int cash = 0;          // Profit when not holding a stock

        // Iterate through each day
        for (int i = 1; i < n; i++) {
            // Update hold and cash
            hold = Math.max(hold, cash - prices[i]);
            cash = Math.max(cash, hold + prices[i] - fee);
        }

        return cash;
    }

    public static void main(String[] args) {
        Q189_Best_Time_To_Buy_And_Sell_Stock_With_Transaction_Fee obj = new Q189_Best_Time_To_Buy_And_Sell_Stock_With_Transaction_Fee();

        // Test cases
        System.out.println(obj.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2)); // Output: 8
        System.out.println(obj.maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3)); // Output: 6
        System.out.println(obj.maxProfit(new int[]{5, 4, 3, 2, 1}, 1));     // Output: 0
    }
}
