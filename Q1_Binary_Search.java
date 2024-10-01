import java.util.Arrays;
import java.util.Scanner;

public class Q1_Binary_Search {

    // Binary Search method
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // Calculate the middle index
            int mid = low + (high - low) / 2; // Prevents potential overflow for large arrays

            // Check if the target is at mid
            if (arr[mid] == target) {
                return mid; // Target found, return index
            } 
            // If target is greater, ignore the left half
            else if (arr[mid] < target) {
                low = mid + 1;
            } 
            // If target is smaller, ignore the right half
            else {
                high = mid - 1;
            }
        }
        
        // Target not found, return -1
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of test cases
        System.out.print("Enter the number of test cases: ");
        int t = scanner.nextInt();

        // Loop for each test case
        for (int testCase = 0; testCase < t; testCase++) {
            System.out.println("Test case " + (testCase + 1) + ":");

            // Take array size input
            System.out.print("Enter the size of the array: ");
            int n = scanner.nextInt();

            // Input the array elements from the user
            int[] arr = new int[n];
            System.out.println("Enter the elements of the array: ");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            // Input the target element
            System.out.print("Enter the target element: ");
            int target = scanner.nextInt();

            // Array should be sorted before applying binary search
            Arrays.sort(arr);

            // Perform binary search
            int result = binarySearch(arr, target);

            // Output the result
            if (result != -1) {
                System.out.println("Element found at index: " + result);
            } else {
                System.out.println("Element not found.");
            }
        }

        scanner.close();
    }
}
