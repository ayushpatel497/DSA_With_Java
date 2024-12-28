class Q194_Wildcard_Matching {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // DP table
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base cases
        dp[0][0] = true; // Empty string matches empty pattern

        // Fill the first row (handling patterns with only '*')
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }

        // Final result
        return dp[m][n];
    }

    public static void main(String[] args) {
        Q194_Wildcard_Matching solution = new Q194_Wildcard_Matching();

        System.out.println(solution.isMatch("aa", "a")); // Output: false
        System.out.println(solution.isMatch("aa", "*")); // Output: true
        System.out.println(solution.isMatch("cb", "?a")); // Output: false
        System.out.println(solution.isMatch("adceb", "*a*b")); // Output: true
        System.out.println(solution.isMatch("acdcb", "a*c?b")); // Output: false
    }
}
