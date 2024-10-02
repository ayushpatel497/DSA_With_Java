import java.util.ArrayList;
import java.util.Scanner;

public class Q4_Search_In_Rotated_Sorted_Array {

    public static int search(ArrayList<Integer> arr, int n, int k) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If the target element is found
            if (arr.get(mid) == k) {
                return mid;
            }

            // Check if the left half is sorted
            if (arr.get(low) <= arr.get(mid)) {
                // Check if the target is in the left half
                if (arr.get(low) <= k && k < arr.get(mid)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Otherwise, the right half must be sorted
            else {
                // Check if the target is in the right half
                if (arr.get(mid) < k && k <= arr.get(high)) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        // Target element not found
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of test cases
        System.out.print("Enter the number of test cases: ");
        int t = scanner.nextInt();

        // Loop for each test case
        for (int testCase = 0; testCase < t; testCase++) {
            System.out.println("Test case " + (testCase + 1) + ":");

            // Input array size
            System.out.print("Enter the size of the array: ");
            int n = scanner.nextInt();

            // Input the rotated sorted array
            ArrayList<Integer> arr = new ArrayList<>();
            System.out.println("Enter the elements of the rotated sorted array: ");
            for (int i = 0; i < n; i++) {
                arr.add(scanner.nextInt());
            }

            // Input the target element
            System.out.print("Enter the target element: ");
            int target = scanner.nextInt();

            // Call the search function
            int result = search(arr, n, target);

            if (result != -1) {
                System.out.println("Element found at index: " + result);
            } else {
                System.out.println("Element not found.");
            }
        }

        scanner.close();
    }
}
