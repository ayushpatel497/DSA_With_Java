import java.util.Scanner;

public class Q38_Binary_Search {

    // Recursive binary search function
    public static int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    // Helper function to perform binary search recursively
    private static int binarySearch(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1; // Base case: target not found
        }

        int mid = start + (end - start) / 2;

        // Check if the middle element is the target
        if (nums[mid] == target) {
            return mid;
        }

        // If target is smaller, search the left half
        if (nums[mid] > target) {
            return binarySearch(nums, target, start, mid - 1);
        }

        // If target is larger, search the right half
        return binarySearch(nums, target, mid + 1, end);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of test cases
        System.out.print("Enter the number of test cases: ");
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            // Input the size of the array
            System.out.print("Enter the size of the array: ");
            int n = scanner.nextInt();

            // Input the elements of the array
            int[] nums = new int[n];
            System.out.println("Enter the elements of the array in sorted order: ");
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            // Input the target value
            System.out.print("Enter the target value: ");
            int target = scanner.nextInt();

            // Call the binary search function
            int result = search(nums, target);

            // Output the result
            if (result == -1) {
                System.out.println("Target not found");
            } else {
                System.out.println("Target found at index: " + result);
            }
        }

        scanner.close();
    }
}
