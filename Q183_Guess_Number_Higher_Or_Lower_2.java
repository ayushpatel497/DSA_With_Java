class Q183_Guess_Number_Higher_Or_Lower_2 {
    public int getMoneyAmount(int n) {
        // DP table to store the minimum cost for ranges [i, j]
        int[][] dp = new int[n + 1][n + 1];

        // Fill the DP table for all possible lengths of ranges
        for (int len = 2; len <= n; len++) { // Length of the range
            for (int start = 1; start <= n - len + 1; start++) {
                int end = start + len - 1;
                dp[start][end] = Integer.MAX_VALUE;
                
                // Try guessing every number in the range [start, end]
                for (int x = start; x <= end; x++) {
                    int leftCost = x - 1 >= start ? dp[start][x - 1] : 0;
                    int rightCost = x + 1 <= end ? dp[x + 1][end] : 0;
                    int cost = x + Math.max(leftCost, rightCost);
                    dp[start][end] = Math.min(dp[start][end], cost);
                }
            }
        }

        // Result for the range [1, n]
        return dp[1][n];
    }

    public static void main(String[] args) {
        Q183_Guess_Number_Higher_Or_Lower_2 obj = new Q183_Guess_Number_Higher_Or_Lower_2();
        
        // Test cases
        System.out.println(obj.getMoneyAmount(10)); // Output: 16
        System.out.println(obj.getMoneyAmount(5));  // Output: 6
    }
}
