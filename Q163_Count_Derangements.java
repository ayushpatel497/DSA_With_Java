import java.util.Scanner;

public class Q163_Count_Derangements {

    public static long countDerangements(int n) {
        // Define the modulo value
        int MOD = 1000000007;

        // Base cases
        if (n == 1) return 0;  // Only 1 element, no derangement possible
        if (n == 2) return 1;  // 1 valid derangement for 2 elements

        // Create a dp array to store results for subproblems
        long[] dp = new long[n + 1];

        // Initialize base cases
        dp[1] = 0;
        dp[2] = 1;

        // Fill dp array iteratively
        for (int i = 3; i <= n; i++) {
            dp[i] = ((i - 1) * (dp[i - 1] + dp[i - 2])) % MOD;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of test cases
        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            // Read input value of n
            System.out.print("Enter value of n: ");
            int n = sc.nextInt();

            // Calculate and print the result
            System.out.println("Number of derangements: " + countDerangements(n));
        }

        sc.close();
    }
}
