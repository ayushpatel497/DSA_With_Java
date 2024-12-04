import java.util.Scanner;

public class Q164_Ninja_And_The_Fence {
    public static int numberOfWays(int n, int k) {
        // Define modulo value
        int MOD = 1000000007;

        // Handle base cases
        if (n == 1) return k;                  // Only one post, all colors possible
        if (n == 2) return (k * (k - 1) + k) % MOD; // Two posts: (different + same colors)

        // Variables to store previous values
        long same = k;                         // Ways to paint last two posts the same color
        long diff = k * (k - 1);               // Ways to paint last two posts different colors
        long total = (same + diff) % MOD;      // Total ways to paint first two posts

        // Iterate to calculate the number of ways for n posts
        for (int i = 3; i <= n; i++) {
            same = diff;                       // Current "same" is previous "diff"
            diff = (total * (k - 1)) % MOD;    // Current "diff" depends on previous total
            total = (same + diff) % MOD;       // Total ways for current post count
        }

        return (int) total; // Return the result as an integer
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of test cases
        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            // Read input values n (number of posts) and k (number of colors)
            System.out.print("Enter n and k: ");
            int n = sc.nextInt();
            int k = sc.nextInt();

            // Calculate and print the result
            System.out.println("Number of ways to paint the fence: " + numberOfWays(n, k));
        }

        sc.close();
    }
}
