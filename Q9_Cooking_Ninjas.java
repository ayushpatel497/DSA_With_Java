import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q9_Cooking_Ninjas {
    
    // Function to check if it is possible to cook 'm' pratas in 'mid' time
    public static boolean isPossible(ArrayList<Integer> rank, int m, int mid) {
        int prataCount = 0;
        
        // Loop through each chef's rank
        for (int r : rank) {
            int time = 0;
            int count = 1;

            // Check how many pratas can be cooked by this chef within 'mid' time
            while (time + count * r <= mid) {
                time += count * r; // Increase time taken for current prata
                prataCount++; // Increment prata count
                count++; // Next prata takes more time
                if (prataCount >= m) {
                    return true; // We've made enough pratas
                }
            }
        }
        return prataCount >= m; // Return if enough pratas can be made
    }

    // Function to find the minimum cooking time
    public static int minCookTime(ArrayList<Integer> rank, int m) {
        Collections.sort(rank); // Sort the ranks for efficiency
        
        int s = 0; // Minimum possible time
        int e = rank.get(rank.size() - 1) * m * (m + 1) / 2; // Maximum possible time
        int ans = -1;

        // Binary search to find the minimum time
        while (s <= e) {
            int mid = s + (e - s) / 2; // Midpoint

            // Check if it's possible to cook 'm' pratas in 'mid' time
            if (isPossible(rank, m, mid)) {
                ans = mid; // Store the possible minimum time
                e = mid - 1; // Try for a smaller time
            } else {
                s = mid + 1; // Try for a larger time
            }
        }
        return ans; // Return the minimum time found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // Number of test cases

        // Loop over the number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of chefs
            int m = sc.nextInt(); // Number of pratas to cook

            ArrayList<Integer> rank = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                rank.add(sc.nextInt()); // Input for chefs' ranks
            }

            // Calculate and print the result for each test case
            int result = minCookTime(rank, m);
            System.out.println(result);
        }

        sc.close(); // Close the scanner
    }
}
