import java.util.*;

public class Q157_Count_Ways_To_Reach_The_Nth_Stairs {

    public static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Reading multiple test cases
        while (sc.hasNextInt()) {
            int nStairs = sc.nextInt();
            System.out.println(countDistinctWayToClimbStair(nStairs));
        }
        
        sc.close();
    }

    public static long countDistinctWayToClimbStair(int nStairs) {
        // Handle the edge case when nStairs is 0 or 1
        if (nStairs == 0 || nStairs == 1) {
            return 1;
        }

        // Create a DP array to store the number of ways
        long[] dp = new long[nStairs + 1];

        // Base cases
        dp[0] = 1;
        dp[1] = 1;

        // Fill the DP array iteratively
        for (int i = 2; i <= nStairs; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        // Return the number of ways to reach the nth stair
        return dp[nStairs];
    }
}
