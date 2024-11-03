import java.util.*;

public class Q85_Sum_Of_Minimum_And_Maximum_Elements_Of_All_Subarrays_Of_Size_K { 

    // Function to return the sum of min and max elements of all subarrays of size k
    public int SumOfKsubArray(int[] arr, int N, int k) {
        if (arr == null || N == 0 || k > N) return 0;

        // Initialize deques to store indices of min and max elements
        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();
        
        int sum = 0;  // Variable to store the sum of min and max of all subarrays

        for (int i = 0; i < N; i++) {
            // Remove elements that are out of the current window from both deques
            if (!minDeque.isEmpty() && minDeque.peekFirst() <= i - k) {
                minDeque.pollFirst();
            }
            if (!maxDeque.isEmpty() && maxDeque.peekFirst() <= i - k) {
                maxDeque.pollFirst();
            }

            // Maintain elements in minDeque in increasing order of their values
            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] >= arr[i]) {
                minDeque.pollLast();
            }

            // Maintain elements in maxDeque in decreasing order of their values
            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] <= arr[i]) {
                maxDeque.pollLast();
            }

            // Add current element's index to both deques
            minDeque.offerLast(i);
            maxDeque.offerLast(i);

            // Add sum of min and max elements of current window to sum when the window is full
            if (i >= k - 1) {
                int minElement = arr[minDeque.peekFirst()];
                int maxElement = arr[maxDeque.peekFirst()];
                sum += minElement + maxElement;
            }
        }
        
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Q85_Sum_Of_Minimum_And_Maximum_Elements_Of_All_Subarrays_Of_Size_K obj = new Q85_Sum_Of_Minimum_And_Maximum_Elements_Of_All_Subarrays_Of_Size_K();

        System.out.print("Enter number of test cases: ");
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            System.out.print("Enter size of array (N): ");
            int N = scanner.nextInt();
            
            System.out.print("Enter size of subarray (k): ");
            int k = scanner.nextInt();
            
            int[] arr = new int[N];
            System.out.println("Enter elements of array:");
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            
            int result = obj.SumOfKsubArray(arr, N, k);
            System.out.println("Sum of min and max elements of all subarrays of size " + k + " is: " + result);
        }
        
        scanner.close();
    }
}
