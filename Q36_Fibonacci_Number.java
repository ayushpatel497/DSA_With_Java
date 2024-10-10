import java.util.Scanner;

class Q36_Fibonacci_Number {
    // Recursive function to calculate the nth Fibonacci number
    public int fib(int n) {
        // Base cases
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        // Recursive case: F(n) = F(n-1) + F(n-2)
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Q36_Fibonacci_Number fibCalculator = new Q36_Fibonacci_Number();

        // Read the number of test cases
        System.out.print("Enter the number of test cases: ");
        int testCases = scanner.nextInt();

        // Loop through all test cases
        for (int t = 0; t < testCases; t++) {
            // Read the value of n
            System.out.print("Enter the value of n: ");
            int n = scanner.nextInt();

            // Calculate the nth Fibonacci number using recursion
            int result = fibCalculator.fib(n);

            // Output the result
            System.out.println("Fibonacci(" + n + ") = " + result);
        }

        scanner.close();
    }
}
