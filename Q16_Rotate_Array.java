import java.util.Scanner;
import java.util.Arrays;

class Q16_Rotate_Array { 
    // Method to rotate the array 'k' times
    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        
        // Traverse through the original array and place each element in its new position
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i]; // Calculate the new index and store the element
        }
        
        // Use System.arraycopy() to copy elements from temp to nums
        System.arraycopy(temp, 0, nums, 0, temp.length); // Copies the entire 'temp' array into 'nums'
    }

    // Main method to take multiple test cases as input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q16_Rotate_Array rotator = new Q16_Rotate_Array();

        // Read the number of test cases
        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt(); // Number of test cases

        for (int test = 0; test < t; test++) {
            System.out.println("Test case " + (test + 1) + ":");

            // Read the size of the array
            System.out.print("Enter the size of the array: ");
            int n = sc.nextInt();

            // Create an array and read its elements
            int[] nums = new int[n];
            System.out.print("Enter the elements of the array: ");
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            // Read the value of k (number of rotations)
            System.out.print("Enter the number of rotations (k): ");
            int k = sc.nextInt();

            // Call the rotate method
            rotator.rotate(nums, k);

            // Output the rotated array
            System.out.println("Array after " + k + " rotations: " + Arrays.toString(nums));
        }

        sc.close(); // Close the scanner
    }
}
