import java.util.*;

public class Q80_First_Negative_In_Every_Window_Of_Size_K {
    
    // Function to find the first negative integer in every window of size k
    static List<Integer> printFirstNegativeInteger(int arr[], int k) {
        List<Integer> result = new ArrayList<>();  // List to store result for each window
        Deque<Integer> deque = new LinkedList<>(); // Deque to store indices of negative numbers

        // Process the first window of size k
        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) {
                deque.addLast(i);
            }
        }

        // Store the result of the first window
        result.add(deque.isEmpty() ? 0 : arr[deque.peekFirst()]);

        // Process the rest of the array
        for (int i = k; i < arr.length; i++) {
            // Remove the elements which are out of this window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.removeFirst();
            }

            // Add the current element if it is negative
            if (arr[i] < 0) {
                deque.addLast(i);
            }

            // Store the result for this window
            result.add(deque.isEmpty() ? 0 : arr[deque.peekFirst()]);
        }

        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of test cases
        System.out.print("Enter the number of test cases: ");
        int t = scanner.nextInt();

        for (int testCase = 1; testCase <= t; testCase++) {
            // Input array size and window size k
            System.out.print("Enter the size of the array: ");
            int n = scanner.nextInt();
            System.out.print("Enter the window size k: ");
            int k = scanner.nextInt();

            int[] arr = new int[n];
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            // Find the first negative integer in each window of size k
            List<Integer> result = printFirstNegativeInteger(arr, k);

            // Display the result
            System.out.println("First negative integer in each window of size " + k + ": " + result);
        }

        scanner.close();
    }
}
