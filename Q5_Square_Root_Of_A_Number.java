import java.util.Scanner;

public class Q5_Square_Root_Of_A_Number {

    // Function to calculate the integer square root of a number N
    public static int sqrtN(long N) {
        long low = 0;
        long high = N;
        long ans = 0;

        // Binary search to find the integer square root
        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (mid * mid == N) {
                return (int)mid; // If perfect square root
            } else if (mid * mid < N) {
                low = mid + 1;
                ans = mid; // Store potential answer
            } else {
                high = mid - 1;
            }
        }

        return (int)ans; // Return the integer part of the square root
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of test cases
        System.out.print("Enter the number of test cases: ");
        int t = scanner.nextInt();

        // Loop through each test case
        for (int testCase = 0; testCase < t; testCase++) {
            System.out.println("Test case " + (testCase + 1) + ":");

            // Input the number N
            System.out.print("Enter the number N: ");
            long N = scanner.nextLong();

            // Call the sqrtN function to calculate the integer square root
            int result = sqrtN(N);

            // Output the result
            System.out.println("Square root of " + N + " is: " + result);
        }

        scanner.close();
    }
}
