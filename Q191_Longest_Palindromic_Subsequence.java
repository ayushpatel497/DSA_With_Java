class Q191_Longest_Palindromic_Subsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Base cases: Single character substrings
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill the table for substrings of increasing lengths
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Q191_Longest_Palindromic_Subsequence obj = new Q191_Longest_Palindromic_Subsequence();
        System.out.println(obj.longestPalindromeSubseq("bbbab")); // Output: 4
        System.out.println(obj.longestPalindromeSubseq("cbbd"));  // Output: 2
    }
}
