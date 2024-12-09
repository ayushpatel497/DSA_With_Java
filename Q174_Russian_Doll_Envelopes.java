import java.util.Arrays;

public class Q174_Russian_Doll_Envelopes {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;

        // Step 1: Sort envelopes by width; if widths are the same, sort by height descending
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // Descending height
            }
            return a[0] - b[0]; // Ascending width
        });

        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Every envelope can stand alone

        int maxEnvelopes = 1;

        // Step 2: DP to calculate LIS on heights
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxEnvelopes = Math.max(maxEnvelopes, dp[i]);
        }

        return maxEnvelopes;
    }

    public static void main(String[] args) {
        Q174_Russian_Doll_Envelopes solver = new Q174_Russian_Doll_Envelopes();
        int[][] envelopes1 = {
            {5, 4}, {6, 4}, {6, 7}, {2, 3}
        };

        int[][] envelopes2 = {
            {1, 1}, {1, 1}, {1, 1}
        };

        System.out.println("Max envelopes (Test 1): " + solver.maxEnvelopes(envelopes1)); // Output: 3
        System.out.println("Max envelopes (Test 2): " + solver.maxEnvelopes(envelopes2)); // Output: 1
    }
}
