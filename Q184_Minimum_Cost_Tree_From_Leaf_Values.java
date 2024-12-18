class Q184_Minimum_Cost_Tree_From_Leaf_Values {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int[][] maxLeaf = new int[n][n];

        // Fill maxLeaf table
        for (int i = 0; i < n; i++) {
            maxLeaf[i][i] = arr[i];
            for (int j = i + 1; j < n; j++) {
                maxLeaf[i][j] = Math.max(maxLeaf[i][j - 1], arr[j]);
            }
        }

        // Fill dp table
        for (int len = 2; len <= n; len++) { // Subarray lengths
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // Partition the subarray
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + maxLeaf[i][k] * maxLeaf[k + 1][j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Q184_Minimum_Cost_Tree_From_Leaf_Values obj = new Q184_Minimum_Cost_Tree_From_Leaf_Values();

        // Test cases
        System.out.println(obj.mctFromLeafValues(new int[]{6, 2, 4})); // Output: 32
        System.out.println(obj.mctFromLeafValues(new int[]{4, 11, 2, 5, 6})); // Output: 95
    }
}
