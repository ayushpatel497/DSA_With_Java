import java.util.Arrays;
import java.util.Scanner;

class Q14_Merge_Sorted_Array {
    // Merge method to merge two sorted arrays nums1 and nums2
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;  // Last element of nums1's original values
        int j = n - 1;  // Last element of nums2
        int k = m + n - 1;  // Last position in nums1 for merging

        // Merge in reverse order from the end of nums1
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } 
            else {
                nums1[k--] = nums2[j--];
            }
        }

        // If there are remaining elements in nums2, copy them
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    // Main function to take multiple test cases as input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q14_Merge_Sorted_Array merger = new Q14_Merge_Sorted_Array();

        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt(); // Read number of test cases

        for (int test = 0; test < t; test++) {
            System.out.println("Test case " + (test + 1) + ":");

            System.out.print("Enter the size of nums1 array (m): ");
            int m = sc.nextInt();

            System.out.print("Enter the elements of nums1 array (without placeholders): ");
            int[] nums1 = new int[m + m]; // Creating nums1 with space for both arrays
            for (int i = 0; i < m; i++) {
                nums1[i] = sc.nextInt();
            }

            System.out.print("Enter the size of nums2 array (n): ");
            int n = sc.nextInt();

            System.out.print("Enter the elements of nums2 array: ");
            int[] nums2 = new int[n];
            for (int i = 0; i < n; i++) {
                nums2[i] = sc.nextInt();
            }

            // Perform the merge
            merger.merge(nums1, m, nums2, n);

            // Output the merged array
            System.out.println("Merged array: " + Arrays.toString(nums1));
        }
        sc.close();
    }
}
