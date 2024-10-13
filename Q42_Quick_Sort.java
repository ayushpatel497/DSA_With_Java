import java.util.*;

public class Q42_Quick_Sort {

    // Helper function to partition the array
    public static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(high);  // Choosing the last element as the pivot
        int i = low - 1;  // Index of the smaller element

        for (int j = low; j < high; j++) {
            // If the current element is smaller than or equal to the pivot
            if (arr.get(j) <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                Collections.swap(arr, i, j);
            }
        }

        // Swap arr[i + 1] with the pivot (arr[high])
        Collections.swap(arr, i + 1, high);

        return i + 1;  // Return the partition index
    }

    // The main function that implements QuickSort
    public static void quickSort(List<Integer> arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Function to handle input and sorting
    public static List<Integer> quickSort(List<Integer> arr) {
        quickSort(arr, 0, arr.size() - 1);  // Sorting the entire list
        return arr;  // Return sorted list
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of test cases
        System.out.print("Enter the number of test cases: ");
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            // Input size of the list
            System.out.print("Enter the size of the array: ");
            int n = scanner.nextInt();

            List<Integer> arr = new ArrayList<>();
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                arr.add(scanner.nextInt());
            }

            // Perform quick sort
            quickSort(arr);

            // Output the sorted array
            System.out.println("Sorted array:");
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
