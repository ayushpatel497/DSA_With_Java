public class Q169_Largest_Square_Formed_In_A_Matrix {
    static int maxSquare(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;

        // DP matrix to store the maximum side length of square ending at (i, j)
        int[][] dp = new int[n][m];
        int maxLength = 0;

        // Iterate over the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    // If we are in the first row or first column, the value is same as mat[i][j]
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // Take the minimum of the three neighbors and add 1
                        dp[i][j] = Math.min(dp[i - 1][j], 
                                    Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                    // Update the maximum side length
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {0, 1, 1, 0, 1},
            {1, 1, 0, 1, 0},
            {0, 1, 1, 1, 0},
            {1, 1, 1, 1, 0},
            {1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0}
        };

        System.out.println("The largest square side length is: " + maxSquare(mat));
    }
}
