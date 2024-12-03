import java.util.*;

public class Q161_House_Robber_2 {

    // Helper function to calculate max loot for a linear row of houses
    public static long robLinear(int[] nums, int start, int end) {
        long prev1 = 0, prev2 = 0;
        for (int i = start; i <= end; i++) {
            long current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public static long houseRobber(int[] valueInHouse) {
        int n = valueInHouse.length;

        // Edge case: If there's only one house
        if (n == 1) {
            return valueInHouse[0];
        }

        // Rob houses excluding the first or the last house
        long rob1 = robLinear(valueInHouse, 0, n - 2);
        long rob2 = robLinear(valueInHouse, 1, n - 1);

        // Return the maximum of the two scenarios
        return Math.max(rob1, rob2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of test cases
        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            // Read the size of the array
            System.out.print("Enter the size of the array: ");
            int n = sc.nextInt();

            // Read the array elements
            System.out.print("Enter the array elements: ");
            int[] valueInHouse = new int[n];
            for (int i = 0; i < n; i++) {
                valueInHouse[i] = sc.nextInt();
            }

            // Calculate and print the result
            long result = houseRobber(valueInHouse);
            System.out.println("Maximum money robbed: " + result);
        }

        sc.close();
    }
}
