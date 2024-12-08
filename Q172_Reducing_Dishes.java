import java.util.*;

public class Q172_Reducing_Dishes {
    public int maxSatisfaction(int[] satisfaction) {
        // Step 1: Sort the satisfaction array in ascending order
        Arrays.sort(satisfaction);
        int n = satisfaction.length;

        // Step 2: Create the DP table
        int[][] dp = new int[n + 1][n + 1];

        // Step 3: Fill the DP table in a bottom-up manner
        for (int index = n - 1; index >= 0; index--) {
            for (int time = index; time >= 0; time--) {
                // Calculate the profit for including the dish
                int includeDish = (satisfaction[index] * (time + 1)) + dp[index + 1][time + 1];

                // Calculate the profit for excluding the dish
                int excludeDish = dp[index + 1][time];

                // Store the maximum of including or excluding the dish
                dp[index][time] = Math.max(includeDish, excludeDish);
            }
        }

        // Step 4: Return the maximum like-time coefficient
        return dp[0][0];
    }

    public static void main(String[] args) {
        Q172_Reducing_Dishes solver = new Q172_Reducing_Dishes();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            System.out.print("Enter the number of dishes: ");
            int n = sc.nextInt();
            int[] satisfaction = new int[n];

            System.out.println("Enter the satisfaction levels:");
            for (int i = 0; i < n; i++) {
                satisfaction[i] = sc.nextInt();
            }

            int result = solver.maxSatisfaction(satisfaction);
            System.out.println("Maximum like-time coefficient: " + result);
        }

        sc.close();
    }
}
