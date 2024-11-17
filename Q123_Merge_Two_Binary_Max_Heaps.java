import java.util.*;

class Q123_Merge_Two_Binary_Max_Heaps {
    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        // Step 1: Create a combined array
        int[] merged = new int[n + m];
        System.arraycopy(a, 0, merged, 0, n);
        System.arraycopy(b, 0, merged, n, m);

        // Step 2: Build the heap
        for (int i = (n + m) / 2 - 1; i >= 0; i--) {
            heapify(merged, n + m, i);
        }

        return merged;
    }

    // Heapify function to maintain max-heap property
    private void heapify(int[] heap, int size, int i) {
        int largest = i; // Assume the current node is the largest
        int left = 2 * i + 1; // Left child index
        int right = 2 * i + 2; // Right child index

        // Check if the left child exists and is greater than the largest
        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }

        // Check if the right child exists and is greater than the largest
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        // If the largest is not the current node, swap and recurse
        if (largest != i) {
            swap(heap, i, largest);
            heapify(heap, size, largest);
        }
    }

    // Utility function to swap elements
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main method for testing with multiple test cases
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();

        for (int testCase = 1; testCase <= t; testCase++) {
            System.out.print("Enter the size of the first heap: ");
            int n = sc.nextInt();
            int[] a = new int[n];
            System.out.print("Enter the elements of the first heap: ");
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            System.out.print("Enter the size of the second heap: ");
            int m = sc.nextInt();
            int[] b = new int[m];
            System.out.print("Enter the elements of the second heap: ");
            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }

            Q123_Merge_Two_Binary_Max_Heaps obj = new Q123_Merge_Two_Binary_Max_Heaps();
            int[] mergedHeap = obj.mergeHeaps(a, b, n, m);

            System.out.println("Merged Max Heap: " + Arrays.toString(mergedHeap));
        }

        sc.close();
    }
}
