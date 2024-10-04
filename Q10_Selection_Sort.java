import java.util.Scanner;

public class Q10_Selection_Sort {

    // Function to perform Selection Sort on an array
    public static void selectionSort(int[] arr, int n) {
        // Traverse the array
        for (int i = 0; i < n - 1; i++) {
            // Find the index of the minimum element in the unsorted part of the array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    // Main method to handle multiple test cases
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of test cases
        int t = sc.nextInt();

        // Loop for each test case
        while (t-- > 0) {
            // Read the size of the array
            int n = sc.nextInt();
            int[] arr = new int[n];

            // Read the elements of the array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Perform selection sort on the array
            selectionSort(arr, n);

            // Print the sorted array
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(); // Move to the next line after printing each sorted array
        }

        sc.close(); // Close the scanner
    }
}
