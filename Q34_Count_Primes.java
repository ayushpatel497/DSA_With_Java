import java.util.Scanner;

class Q34_Count_Primes {
    
    // Method to count the number of prime numbers less than n
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        
        // Boolean array to mark non-prime numbers
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true; // Assume all numbers are prime initially
        }
        
        // Start from the first prime number, which is 2
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // Mark all multiples of i as non-prime
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // Count the number of primes less than n
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        
        return count;
    }

    // Main method to take multiple test cases as input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();
        
        Q34_Count_Primes solution = new Q34_Count_Primes();
        
        for (int i = 0; i < t; i++) {
            System.out.print("Enter the value of n: ");
            int n = sc.nextInt();
            
            int result = solution.countPrimes(n);
            System.out.println("Number of primes less than " + n + " is: " + result);
        }
        
        sc.close();
    }
}
