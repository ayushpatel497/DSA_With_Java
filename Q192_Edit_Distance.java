class Q192_Edit_Distance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // DP table
        int[][] dp = new int[m + 1][n + 1];

        // Base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // Deleting all characters from word1
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // Inserting all characters of word2
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // Characters match
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, // Replace
                            Math.min(dp[i][j - 1] + 1,        // Insert
                                     dp[i - 1][j] + 1));     // Delete
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Q192_Edit_Distance obj = new Q192_Edit_Distance();
        System.out.println(obj.minDistance("horse", "ros")); // Output: 3
        System.out.println(obj.minDistance("intention", "execution")); // Output: 5
    }
}
