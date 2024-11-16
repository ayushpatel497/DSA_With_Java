import java.util.*;

public class Q121_Build_Min_Heap {
    public static int[] buildMinHeap(int[] arr) {
        int n = arr.length;

        // Start heapifying from the last non-leaf node
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        return arr;
    }

    // Function to heapify a subtree rooted at index 'i'
    private static void heapify(int[] arr, int n, int i) {
        int smallest = i; // Initialize smallest as root
        int left = 2 * i + 1; // Left child index
        int right = 2 * i + 2; // Right child index

        // Check if the left child exists and is smaller than the current smallest
        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }

        // Check if the right child exists and is smaller than the current smallest
        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }

        // If the smallest is not the root, swap and continue heapifying
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            // Recursively heapify the affected subtree
            heapify(arr, n, smallest);
        }
    }

    // Main method to test multiple test cases
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();

        for (int testCase = 1; testCase <= t; testCase++) {
            System.out.print("Enter the number of elements in the array: ");
            int n = sc.nextInt();
            int[] arr = new int[n];

            System.out.print("Enter the elements of the array: ");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int[] minHeap = buildMinHeap(arr);

            System.out.println("Min-Heap for Test Case " + testCase + ": " + Arrays.toString(minHeap));
        }

        sc.close();
    }
}
