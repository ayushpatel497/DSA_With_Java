import java.util.*; 

public class Q13_Reverse_The_Array 
{
    // Method to reverse part of the array after index m
    public static void reverseArray(ArrayList<Integer> arr, int m) {
        // Start reversing from index m + 1 to the end of the array
        int s = m + 1; // Start of the part to reverse
        int e = arr.size() - 1; // End of the array

        // Swap elements from the start and the end of the section to be reversed
        while (s <= e) {
            int temp = arr.get(s); // Temporary store the value at index s
            arr.set(s, arr.get(e)); // Swap the element at s with the element at e
            arr.set(e, temp); // Place the value of s in the position of e
            s++; // Move start pointer forward
            e--; // Move end pointer backward
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of test cases
        int t = sc.nextInt();

        // Process each test case
        while (t-- > 0) {
            // Read the size of the array
            int n = sc.nextInt();

            // Initialize an ArrayList to store the array elements
            ArrayList<Integer> arr = new ArrayList<>();

            // Read the array elements
            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }

            // Read the index m after which the array needs to be reversed
            int m = sc.nextInt();

            // Call the reverseArray method to reverse part of the array
            reverseArray(arr, m);

            // Print the modified array
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println(); // Print newline after each test case
        }

        sc.close(); // Close the scanner
    }
}
