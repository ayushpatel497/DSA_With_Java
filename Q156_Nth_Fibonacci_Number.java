public class Q156_Nth_Fibonacci_Number {

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        
        // Reading the value of 'n'
        int n = sc.nextInt();
        
        // Printing the nth Fibonacci number
        System.out.println(findNthFibonacci(n));

        sc.close();
    }

    // Method to find the nth Fibonacci number using DP
    public static int findNthFibonacci(int n) {
        // Handle edge cases for n = 1 or n = 2
        if (n == 1 || n == 2) {
            return 1;
        }

        // Create a DP array to store Fibonacci numbers
        int[] dp = new int[n + 1];
        
        // Initialize base cases
        dp[1] = 1;
        dp[2] = 1;

        // Fill the DP array using the recurrence relation
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Return the nth Fibonacci number
        return dp[n];
    }
}
