import java.util.Scanner;

public class Q11_Bubble_Sort {

    // Function to perform Bubble Sort on an array
    public static void bubbleSort(int[] arr, int n) {
        // Traverse the array
        for (int i = 0; i < n - 1; i++) {
            // Last i elements are already in place, so reduce the number of comparisons
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if the element is greater than the next element
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
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

            // Perform bubble sort on the array
            bubbleSort(arr, n);

            // Print the sorted array
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(); // Move to the next line after printing each sorted array
        }

        sc.close(); // Close the scanner
    }
}
