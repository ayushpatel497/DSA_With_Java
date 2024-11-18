import java.util.*;

public class Q128_Merge_K_Sorted_Arrays {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        // Min-heap to store elements and their indices
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Add the first element of each array to the heap
        for (int i = 0; i < k; i++) {
            if (!kArrays.get(i).isEmpty()) {
                minHeap.add(new int[]{kArrays.get(i).get(0), i, 0});
            }
        }

        // Merge arrays
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll(); // Get the smallest element
            int value = current[0];
            int arrayIndex = current[1];
            int elementIndex = current[2];

            result.add(value);

            // Add the next element from the same array to the heap
            if (elementIndex + 1 < kArrays.get(arrayIndex).size()) {
                minHeap.add(new int[]{kArrays.get(arrayIndex).get(elementIndex + 1), arrayIndex, elementIndex + 1});
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of test cases
        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            // Input the number of arrays
            System.out.print("Enter the number of sorted arrays (k): ");
            int k = sc.nextInt();

            ArrayList<ArrayList<Integer>> kArrays = new ArrayList<>();
            System.out.println("Enter the sorted arrays:");
            for (int i = 0; i < k; i++) {
                int size = sc.nextInt(); // Size of the current array
                ArrayList<Integer> array = new ArrayList<>();
                for (int j = 0; j < size; j++) {
                    array.add(sc.nextInt());
                }
                kArrays.add(array);
            }

            // Merge the arrays
            ArrayList<Integer> mergedArray = mergeKSortedArrays(kArrays, k);
            System.out.println("Merged Sorted Array: " + mergedArray);
        }

        sc.close();
    }
}
