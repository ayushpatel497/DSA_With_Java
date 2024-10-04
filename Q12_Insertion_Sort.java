import java.util.Scanner;

public class Q12_Insertion_Sort {

    // Function to perform Insertion Sort on an array
    public static void insertionSort(int[] arr, int n) {
        // Traverse from the second element (since the first element is trivially sorted)
        for (int i = 1; i < n; i++) {
            int key = arr[i];  // Element to be inserted in the sorted portion
            
            // Move elements that are greater than the key to one position ahead
			for(int j = i - 1; j >= 0; j--){
				if(arr[j] > key){
					arr[j + 1] = arr[j];  // Shift elements to the right
					arr[j] = key;  // Insert the key at the correct position
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

            // Perform insertion sort on the array
            insertionSort(arr, n);

            // Print the sorted array
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(); // Move to the next line after printing each sorted array
        }

        sc.close(); // Close the scanner
    }
}
