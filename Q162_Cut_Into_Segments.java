import java.util.* ;

public class Q162_Cut_Into_Segments { 

    public static int cutSegments(int n, int x, int y, int z) {
        // Create a DP array to store maximum number of segments for each length
        int[] dp = new int[n + 1];
        
        // Initialize the dp array with a minimum value
        Arrays.fill(dp, Integer.MIN_VALUE);

        // Base case: 0 length rod has 0 segments
        dp[0] = 0;

        // Iterate over all lengths from 1 to n
        for (int i = 1; i <= n; i++) {
            if (i >= x && dp[i - x] != Integer.MIN_VALUE) {
                dp[i] = Math.max(dp[i], dp[i - x] + 1);
            }
            if (i >= y && dp[i - y] != Integer.MIN_VALUE) {
                dp[i] = Math.max(dp[i], dp[i - y] + 1);
            }
            if (i >= z && dp[i - z] != Integer.MIN_VALUE) {
                dp[i] = Math.max(dp[i], dp[i - z] + 1);
            }
        }

        // If dp[n] is still Integer.MIN_VALUE, it means no segments can be formed
        return dp[n] == Integer.MIN_VALUE ? 0 : dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of test cases
        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            // Read the input values
            System.out.print("Enter N, X, Y, Z: ");
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            // Calculate and print the result
            System.out.println("Maximum segments: " + cutSegments(n, x, y, z));
        }

        sc.close();
    }
}
