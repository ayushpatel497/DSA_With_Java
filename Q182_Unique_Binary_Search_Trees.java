class Q182_Unique_Binary_Search_Trees {
    public int numTrees(int n) {
        // DP array to store the number of unique BSTs for each value of n
        int[] dp = new int[n + 1];
        
        // Base cases: For 0 or 1 nodes, there's exactly 1 unique BST
        dp[0] = 1;
        dp[1] = 1;

        // Fill the dp array for all numbers from 2 to n
        for (int nodes = 2; nodes <= n; nodes++) {
            for (int root = 1; root <= nodes; root++) {
                // Left subtree has `root - 1` nodes, right subtree has `nodes - root` nodes
                dp[nodes] += dp[root - 1] * dp[nodes - root];
            }
        }

        // The result for `n` nodes is stored in dp[n]
        return dp[n];
    }

    public static void main(String[] args) {
        Q182_Unique_Binary_Search_Trees obj = new Q182_Unique_Binary_Search_Trees();
        
        // Test cases
        System.out.println(obj.numTrees(3)); // Output: 5
        System.out.println(obj.numTrees(4)); // Output: 14
        System.out.println(obj.numTrees(5)); // Output: 42
    }
}
