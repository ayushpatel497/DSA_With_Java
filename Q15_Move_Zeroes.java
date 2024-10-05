import java.util.Scanner;
import java.util.Arrays;

class Q15_Move_Zeroes { 
    // Method to move zeroes in an array to the end
    public void moveZeroes(int[] nums) {
        // j points to the position where the next non-zero element will be placed
        int j = 0;
        
        // Traverse through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is non-zero, swap it with the element at index j
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;  // Move j forward
            }
        }
    }

    // Main method to take multiple test cases as input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q15_Move_Zeroes mover = new Q15_Move_Zeroes();

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

            // Call the method to move zeroes
            mover.moveZeroes(nums);

            // Output the modified array
            System.out.println("Array after moving zeroes: " + Arrays.toString(nums));
        }

        sc.close(); // Close the scanner
    }
}

