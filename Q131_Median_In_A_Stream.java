import java.util.*;

public class Q131_Median_In_A_Stream {
    public static int[] findMedian(int[] arr, int n) {
        // Min-Heap for the larger half
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Max-Heap for the smaller half
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int[] medians = new int[n];

        for (int i = 0; i < n; i++) {
            int num = arr[i];

            // Add to Max-Heap (smaller half)
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            // Balance the heaps to maintain the property
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }

            // Calculate the median
            if (maxHeap.size() == minHeap.size()) {
                medians[i] = (maxHeap.peek() + minHeap.peek()) / 2;
            } else {
                medians[i] = maxHeap.peek();
            }
        }

        return medians;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            System.out.print("Enter the size of the array: ");
            int n = sc.nextInt();

            int[] arr = new int[n];
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int[] medians = findMedian(arr, n);
            System.out.println("Medians after processing each element:");
            for (int median : medians) {
                System.out.print(median + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
