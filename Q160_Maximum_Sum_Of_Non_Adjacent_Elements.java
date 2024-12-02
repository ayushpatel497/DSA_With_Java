import java.util.*;

public class Q160_Maximum_Sum_Of_Non_Adjacent_Elements {

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Edge case: if nums is empty
        if (nums == null || nums.isEmpty()) {
            return 0;
        }

        // Edge case: if nums contains only one element
        if (nums.size() == 1) {
            return nums.get(0);
        }

        int n = nums.size();
        int[] dp = new int[n];

        // Base cases
        dp[0] = nums.get(0);
        dp[1] = Math.max(nums.get(0), nums.get(1));

        // Fill the DP array
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums.get(i));
        }

        // The last element of dp contains the maximum sum
        return dp[n - 1];
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
            ArrayList<Integer> nums = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                nums.add(sc.nextInt());
            }

            // Calculate and print the result
            int result = maximumNonAdjacentSum(nums);
            System.out.println("Maximum sum of non-adjacent elements: " + result);
        }

        sc.close();
    }
}
