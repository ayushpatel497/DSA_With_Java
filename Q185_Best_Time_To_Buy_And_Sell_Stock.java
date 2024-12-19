class Q185_Best_Time_To_Buy_And_Sell_Stock {
    public int maxProfit(int[] prices) {
        // Base case: No profit possible if prices array is empty
        if (prices == null || prices.length < 2) return 0;

        int minPrice = Integer.MAX_VALUE; // Minimum price so far
        int maxProfit = 0;               // Maximum profit so far

        // Iterate through the array
        for (int price : prices) {
            // Update the minimum price seen so far
            if (price < minPrice) {
                minPrice = price;
            }
            // Calculate profit for current price
            int profit = price - minPrice;

            // Update the maximum profit if profit is greater
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit; // Maximum profit
    }

    public static void main(String[] args) {
        Q185_Best_Time_To_Buy_And_Sell_Stock obj = new Q185_Best_Time_To_Buy_And_Sell_Stock();

        // Test cases
        System.out.println(obj.maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // Output: 5
        System.out.println(obj.maxProfit(new int[]{7, 6, 4, 3, 1}));   // Output: 0
    }
}
