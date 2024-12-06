import java.util.*;

public class Q168_Ninjas_Trip {

    public static int minimumCoins(int n, int[] days, int[] cost) {
        // DP array to store the minimum cost for each day of the year
        int[] dp = new int[366]; // Array for days from 0 to 365
        boolean[] isTravelDay = new boolean[366]; // To mark the travel days

        // Mark the travel days in the year
        for (int day : days) {
            isTravelDay[day] = true;
        }

        // Fill the DP array
        for (int i = 1; i <= 365; i++) {
            if (!isTravelDay[i]) {
                // If it's not a travel day, the cost remains the same as the previous day
                dp[i] = dp[i - 1];
            } else {
                // Calculate the minimum cost using the three ticket options
                int oneDayPass = dp[i - 1] + cost[0];
                int sevenDayPass = dp[Math.max(0, i - 7)] + cost[1];
                int thirtyDayPass = dp[Math.max(0, i - 30)] + cost[2];
                dp[i] = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
            }
        }

        // The answer will be stored in dp[365]
        return dp[365];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the number of test cases
        int t = sc.nextInt();

        while (t-- > 0) {
            // Input the number of travel days
            int n = sc.nextInt();

            // Input the travel days
            int[] days = new int[n];
            for (int i = 0; i < n; i++) {
                days[i] = sc.nextInt();
            }

            // Input the cost of tickets
            int[] cost = new int[3];
            for (int i = 0; i < 3; i++) {
                cost[i] = sc.nextInt();
            }

            // Output the minimum cost
            System.out.println(minimumCoins(n, days, cost));
        }

        sc.close();
    }
}
