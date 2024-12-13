import java.io.*;
import java.util.*;

class Q179_Minimum_Swaps_To_Make_Sequences_Increasing {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;

        // Initialize dp arrays
        int[] keep = new int[n]; // Minimum swaps to keep nums1[i] and nums2[i] unchanged
        int[] swap = new int[n]; // Minimum swaps to swap nums1[i] and nums2[i]

        // Base case: no swaps at the beginning
        keep[0] = 0; // No swap needed
        swap[0] = 1; // One swap at the start

        for (int i = 1; i < n; i++) {
            // Initialize with a high value
            keep[i] = swap[i] = Integer.MAX_VALUE;

            // Case 1: No swap needed at i
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                keep[i] = keep[i - 1]; // No swaps carried forward
                swap[i] = swap[i - 1] + 1; // Add one swap to previous swaps
            }

            // Case 2: Swap at i
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                keep[i] = Math.min(keep[i], swap[i - 1]); // No additional swap if previous was swapped
                swap[i] = Math.min(swap[i], keep[i - 1] + 1); // Add one swap to previous keep
            }
        }

        // Return the minimum swaps to make both arrays strictly increasing
        return Math.min(keep[n - 1], swap[n - 1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of test cases:");
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            System.out.println("Enter the size of the arrays:");

            System.out.println("Enter the elements of nums1:");
            int[] nums1 = Arrays.stream(br.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();

            System.out.println("Enter the elements of nums2:");
            int[] nums2 = Arrays.stream(br.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();

            Q179_Minimum_Swaps_To_Make_Sequences_Increasing obj = new Q179_Minimum_Swaps_To_Make_Sequences_Increasing();
            int result = obj.minSwap(nums1, nums2);

            System.out.println("Minimum swaps to make sequences strictly increasing: " + result);
        }
    }
}
