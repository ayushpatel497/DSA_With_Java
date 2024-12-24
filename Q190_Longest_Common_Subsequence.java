class Q190_Longest_Common_Subsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // Create a DP table
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Q190_Longest_Common_Subsequence obj = new Q190_Longest_Common_Subsequence();

        // Test cases
        System.out.println(obj.longestCommonSubsequence("abcde", "ace")); // Output: 3
        System.out.println(obj.longestCommonSubsequence("abc", "abc"));   // Output: 3
        System.out.println(obj.longestCommonSubsequence("abc", "def"));   // Output: 0
    }
}
