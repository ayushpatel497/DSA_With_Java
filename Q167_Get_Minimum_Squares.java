import java.util.*;

public class Q167_Get_Minimum_Squares {
    public int MinSquares(int n) {
        // DP array to store the minimum squares for each number up to n
        int[] dp = new int[n + 1];

        // Base case: Minimum squares needed to make 0 is 0
        dp[0] = 0;

        // Fill the DP array for all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            int minSquares = Integer.MAX_VALUE;

            // Iterate over all perfect squares less than or equal to i
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                minSquares = Math.min(minSquares, 1 + dp[i - square]);
            }

            dp[i] = minSquares;
        }

        // Return the result for n
        return dp[n];
    }

    public static void main(String[] args) {
        Q167_Get_Minimum_Squares solver = new Q167_Get_Minimum_Squares();
        Scanner sc = new Scanner(System.in);

        // Input the number of test cases
        int t = sc.nextInt();

        while (t-- > 0) {
            // Input the number n
            int n = sc.nextInt();

            // Output the minimum number of squares
            System.out.println(solver.MinSquares(n));
        }

        sc.close();
    }
}
