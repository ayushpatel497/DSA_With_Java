import java.util.Scanner;

class Q176_Pizza_With_3n_Slices {

    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        // Solve the problem considering two cases due to circular nature
        return Math.max(helper(slices, n / 3, 0, n - 2), helper(slices, n / 3, 1, n - 1));
    }

    private int helper(int[] slices, int rounds, int start, int end) {
        int[][] dp = new int[rounds + 1][2]; // dp[j][0]: exclude slice, dp[j][1]: include slice
        dp[1][1] = slices[start]; // Base case: first slice included
        for (int i = start + 1; i <= end; i++) {
            for (int j = rounds; j > 0; j--) {
                dp[j][0] = Math.max(dp[j][0], dp[j][1]); // Skip current slice
                dp[j][1] = dp[j - 1][0] + slices[i];    // Include current slice
            }
        }
        return Math.max(dp[rounds][0], dp[rounds][1]); // Max value for the given rounds
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of slices and their sizes
        System.out.println("Enter the number of slices (3n):");
        int n = scanner.nextInt();
        int[] slices = new int[n];
        System.out.println("Enter the sizes of the pizza slices:");
        for (int i = 0; i < n; i++) {
            slices[i] = scanner.nextInt();
        }

        // Solve and output the result
        Q176_Pizza_With_3n_Slices solver = new Q176_Pizza_With_3n_Slices();
        System.out.println("Maximum sum of slice sizes you can pick: " + solver.maxSizeSlices(slices));

        scanner.close();
    }
}
