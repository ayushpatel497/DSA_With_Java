import java.util.Scanner;

public class Q35_Modular_Exponentiation {

    // Method to calculate (x^n) % m using modular exponentiation
    public static int modularExponentiation(int x, int n, int m) {
        long result = 1;    // Use long to prevent overflow
        long base = x % m;  // Convert x to long to prevent overflow

        while (n > 0) {
            // If n is odd, multiply base with result
            if ((n & 1) == 1) {
                result = (result * base) % m;
            }
            // n must be even now, so divide it by 2
            n = n >> 1; // Equivalent to n = n / 2
            base = (base * base) % m; // Square the base
        }
        return (int) result;  // Convert result back to int
    }

    // Main function to handle multiple test cases
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt(); // Number of test cases
        
        for (int i = 0; i < t; i++) {
            System.out.print("Enter the values of x, n, and m: ");
            int x = sc.nextInt(); // Base
            int n = sc.nextInt(); // Exponent
            int m = sc.nextInt(); // Modulus
            
            // Call the modular exponentiation function
            int result = modularExponentiation(x, n, m);
            
            // Print the result
            System.out.println("Result: " + result);
        }
        
        sc.close();
    }
}
