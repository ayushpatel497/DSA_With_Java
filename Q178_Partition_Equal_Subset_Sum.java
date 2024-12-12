import java.util.*;

class Q178_Partition_Equal_Subset_Sum {
    // Function to check if array can be partitioned into two subsets with equal sum
    static boolean equalPartition(int arr[]) {
        int totalSum = 0;

        // Calculate the total sum of the array
        for (int num : arr) {
            totalSum += num;
        }

        // If the total sum is odd, it's not possible to partition into equal parts
        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;

        // Create a DP array to check if subset with sum 'target' is possible
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Base case: Subset sum of 0 is always possible

        // Update the DP array for each element in the array
        for (int num : arr) {
            for (int sum = target; sum >= num; sum--) {
                dp[sum] = dp[sum] || dp[sum - num];
            }
        }

        // The result is whether a subset with sum equal to 'target' is possible
        return dp[target];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take the number of test cases
        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            // Input the size of the array
            System.out.print("Enter size of the array: ");
            int n = sc.nextInt();

            // Input the array elements
            int[] arr = new int[n];
            System.out.println("Enter elements of the array: ");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Check and print result
            if (equalPartition(arr)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }

        sc.close();
    }
}
