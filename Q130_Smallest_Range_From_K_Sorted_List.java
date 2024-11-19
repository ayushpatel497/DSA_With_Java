import java.util.*;

public class Q130_Smallest_Range_From_K_Sorted_List {

    static class Node {
        int value; // Value in the list
        int listIndex; // Index of the list this value belongs to
        int elementIndex; // Index of this value in its list

        public Node(int value, int listIndex, int elementIndex) {
            this.value = value;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }
    }

    public static int kSorted(int[][] a, int k, int n) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.value));

        int max = Integer.MIN_VALUE; // Track the max value in the current range
        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE; // Variables to store the range

        // Initialize the heap with the first element of each list
        for (int i = 0; i < k; i++) {
            minHeap.add(new Node(a[i][0], i, 0));
            max = Math.max(max, a[i][0]);
        }

        while (minHeap.size() == k) {
            Node current = minHeap.poll();
            int min = current.value;

            // Update the smallest range if the current range is smaller
            if (max - min < rangeEnd - rangeStart) {
                rangeStart = min;
                rangeEnd = max;
            }

            // Add the next element from the list of the removed element, if it exists
            if (current.elementIndex + 1 < n) {
                int nextValue = a[current.listIndex][current.elementIndex + 1];
                minHeap.add(new Node(nextValue, current.listIndex, current.elementIndex + 1));
                max = Math.max(max, nextValue);
            }
        }

        // Return the size of the smallest range
        return rangeEnd - rangeStart + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            System.out.print("Enter the number of lists (K): ");
            int k = sc.nextInt();

            System.out.print("Enter the size of each list (N): ");
            int n = sc.nextInt();

            int[][] lists = new int[k][n];

            for (int i = 0; i < k; i++) {
                System.out.print("Enter elements of list " + (i + 1) + ": ");
                for (int j = 0; j < n; j++) {
                    lists[i][j] = sc.nextInt();
                }
            }

            int result = kSorted(lists, k, n);
            System.out.println("Size of the smallest range: " + result);
        }

        sc.close();
    }
}
