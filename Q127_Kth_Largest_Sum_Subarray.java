import java.util.*;

public class Q127_Kth_Largest_Sum_Subarray {

    public static int getKthLargest(ArrayList<Integer> arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int n = arr.size();

        // Generate all subarray sums
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr.get(j);

                // Add to the heap
                if (minHeap.size() < k) {
                    minHeap.add(sum);
                } else if (sum > minHeap.peek()) {
                    minHeap.poll(); // Remove smallest in the heap
                    minHeap.add(sum);
                }
            }
        }

        // Root of the heap is the kth largest element
        return minHeap.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of test cases
        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            // Input size of array
            System.out.print("Enter size of the array: ");
            int n = sc.nextInt();

            ArrayList<Integer> arr = new ArrayList<>();
            System.out.print("Enter elements of the array: ");
            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }

            // Input K
            System.out.print("Enter the value of K: ");
            int k = sc.nextInt();

            // Output the Kth largest sum
            int result = getKthLargest(arr, k);
            System.out.println("The " + k + "-th largest sum is: " + result);
        }

        sc.close();
    }
}
