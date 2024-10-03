import java.util.Arrays;
import java.util.Scanner;

public class Q8_Aggressive_Cows {
    
    // Function to check if it is possible to place cows with at least minDist distance apart
    public static boolean isPossible(int[] stalls, int k, int minDist) {
        int count = 1;  // Count of cows placed
        int lastPosition = stalls[0];  // Position of the last placed cow

        // Loop through the stalls to place cows
        for (int i = 1; i < stalls.length; i++) {
            // If the current stall's position is greater than or equal to the last placed cow's position + minDist
            if (stalls[i] - lastPosition >= minDist) {
                count++;  // Place the cow
                lastPosition = stalls[i];  // Update the last position
            }
            // If we've placed all cows, return true
            if (count == k) {
                return true;
            }
        }
        return false;  // Not possible to place all cows
    }

    // Function to find the largest minimum distance
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);  // Sort the stall positions
        
        int s = 0;  // Minimum possible distance
        int e = stalls[stalls.length - 1] - stalls[0];  // Maximum possible distance
        int ans = -1;  // To store the answer

        // Binary search for the largest minimum distance
        while (s <= e) {
            int mid = s + (e - s) / 2;  // Midpoint

            // Check if we can place cows with at least mid distance
            if (isPossible(stalls, k, mid)) {
                ans = mid;  // Update answer
                s = mid + 1;  // Try for a larger distance
            } else {
                e = mid - 1;  // Try for a smaller distance
            }
        }
        return ans;  // Return the largest minimum distance found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // Number of test cases

        // Loop over the number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of stalls
            int k = sc.nextInt(); // Number of cows

            int[] stalls = new int[n];
            // Input for stall positions
            for (int i = 0; i < n; i++) {
                stalls[i] = sc.nextInt();
            }

            // Calculate and print the result for each test case
            int result = aggressiveCows(stalls, k);
            System.out.println(result);
        }

        sc.close(); // Close the scanner
    }
}

