import java.util.*;

public class Q171_Minimum_Sideway_Jumps {
    static int mod = 1000000000;

    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;

        // Space optimization arrays
        int[] curr = new int[4];
        int[] next = new int[4];
        Arrays.fill(curr, mod);

        // Base case: no jumps needed at the last index
        Arrays.fill(next, 0);

        // Iterate from the second-to-last point back to the start
        for (int index = n - 2; index >= 0; index--) {
            for (int lane = 1; lane <= 3; lane++) {
                // If there's no obstacle in the current lane at the next point
                if (obstacles[index + 1] != lane) {
                    curr[lane] = next[lane];
                } else {
                    // Otherwise, calculate the cost of jumping to another lane
                    int ans = mod;
                    for (int i = 1; i <= 3; i++) {
                        if (lane != i && obstacles[index] != i) {
                            ans = Math.min(ans, 1 + next[i]);
                        }
                    }
                    curr[lane] = ans;
                }
            }
            // Update next for the next iteration
            next = curr.clone();
        }

        // Return the minimum jumps needed to start at lane 2 (middle lane)
        return Math.min(next[1] + 1, Math.min(next[2], next[3] + 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q171_Minimum_Sideway_Jumps solver = new Q171_Minimum_Sideway_Jumps();

        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            System.out.print("Enter the size of the obstacles array: ");
            int n = sc.nextInt();

            int[] obstacles = new int[n];
            System.out.println("Enter the obstacles array:");
            for (int i = 0; i < n; i++) {
                obstacles[i] = sc.nextInt();
            }

            int result = solver.minSideJumps(obstacles);
            System.out.println("Minimum side jumps needed: " + result);
        }

        sc.close();
    }
}
