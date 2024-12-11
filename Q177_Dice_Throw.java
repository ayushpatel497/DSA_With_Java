import java.util.Scanner;

class Q177_Dice_Throw {

    static int noOfWays(int m, int n, int x) {
        // DP table to store the number of ways to get a sum with n dice
        int[][] dp = new int[n + 1][x + 1];

        // Base case: 0 dice and sum 0
        dp[0][0] = 1;

        // Fill the DP table
        for (int dice = 1; dice <= n; dice++) {
            for (int target = 1; target <= x; target++) {
                dp[dice][target] = 0; // Initialize ways to 0
                for (int face = 1; face <= m; face++) {
                    if (target - face >= 0) {
                        dp[dice][target] += dp[dice - 1][target - face];
                    }
                }
            }
        }

        // Return the number of ways to get sum x with n dice
        return dp[n][x];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of test cases:");
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            System.out.println("Enter the number of faces (m), dice (n), and target sum (x):");
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int x = scanner.nextInt();

            // Handle edge cases
            if (x < n || x > n * m) {
                System.out.println("0");
            } else {
                System.out.println("Number of ways: " + noOfWays(m, n, x));
            }
        }

        scanner.close();
    }
}
