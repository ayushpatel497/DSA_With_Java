public class Q170_Minimum_Score_Triangulation_Of_Polygon {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        // DP table to store the minimum score for polygon i to j
        int[][] dp = new int[n][n];

        // Fill the DP table
        for (int len = 3; len <= n; len++) { // len is the size of the subpolygon
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // Endpoint of the subpolygon
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) { // Choose a middle vertex to form a triangle
                    int cost = values[i] * values[k] * values[j] + dp[i][k] + dp[k][j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        // The answer is the minimum score for the whole polygon
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Q170_Minimum_Score_Triangulation_Of_Polygon solver = new Q170_Minimum_Score_Triangulation_Of_Polygon();
        int[] values1 = {1, 2, 3};
        int[] values2 = {3, 7, 4, 5};
        System.out.println("Minimum Score (values1): " + solver.minScoreTriangulation(values1)); // Output: 6
        System.out.println("Minimum Score (values2): " + solver.minScoreTriangulation(values2)); // Output: 144
    }
}
