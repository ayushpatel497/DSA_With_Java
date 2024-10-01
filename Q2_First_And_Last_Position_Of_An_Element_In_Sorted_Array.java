import java.util.ArrayList;
import java.util.Scanner;

public class Q2_First_And_Last_Position_Of_An_Element_In_Sorted_Array {

    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        int[] ans = new int[2];  // To store the first and last position
        ans[0] = findFirstPosition(arr, n, k);  // Find the first position of k
        ans[1] = findLastPosition(arr, n, k);   // Find the last position of k
        return ans;  // Return the array with first and last positions
    }

    // Function to find the first occurrence of k
    public static int findFirstPosition(ArrayList<Integer> arr, int n, int k) {
        int low = 0, high = n - 1;
        int firstPos = -1;  // Initialize to -1, meaning "not found"
        
        while (low <= high) {
            int mid = low + (high - low) / 2;  // Prevent potential overflow
            
            if (arr.get(mid) == k) {
                firstPos = mid;  // Store the index of the found element
                high = mid - 1;  // Continue searching in the left half
            } else if (arr.get(mid) < k) {
                low = mid + 1;  // Move right
            } else {
                high = mid - 1;  // Move left
            }
        }
        
        return firstPos;  // Return the first position or -1 if not found
    }

    // Function to find the last occurrence of k
    public static int findLastPosition(ArrayList<Integer> arr, int n, int k) {
        int low = 0, high = n - 1;
        int lastPos = -1;  // Initialize to -1, meaning "not found"
        
        while (low <= high) {
            int mid = low + (high - low) / 2;  // Prevent potential overflow
            
            if (arr.get(mid) == k) {
                lastPos = mid;  // Store the index of the found element
                low = mid + 1;  // Continue searching in the right half
            } else if (arr.get(mid) < k) {
                low = mid + 1;  // Move right
            } else {
                high = mid - 1;  // Move left
            }
        }
        
        return lastPos;  // Return the last position or -1 if not found
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

            // Input the sorted array from the user
            ArrayList<Integer> arr = new ArrayList<>();
            System.out.println("Enter the elements of the array (sorted): ");
            for (int i = 0; i < n; i++) {
                arr.add(scanner.nextInt());
            }

            // Input the target element k
            System.out.print("Enter the target element: ");
            int k = scanner.nextInt();

            // Find and display the first and last positions of k
            int[] result = firstAndLastPosition(arr, n, k);

            System.out.println("First position: " + result[0]);  // Output: First position
            System.out.println("Last position: " + result[1]);   // Output: Last position
        }

        scanner.close();
    }
}
