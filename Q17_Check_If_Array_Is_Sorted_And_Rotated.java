import java.util.Scanner;

class Q17_Check_If_Array_Is_Sorted_And_Rotated {
    // Method to check if the array is sorted and rotated
    public boolean check(int[] nums) {
        int check = 0;
        int n = nums.length;

        // Check for any out-of-order element
        for (int i = 0; i < n; i++) {
            // Compare current element with the next element, using modulus to wrap around
            if (nums[i] > nums[(i + 1) % n]) {
                check++;
            }
        }

        // If there is more than 1 rotation (out-of-order element), return false
        return check <= 1;
    }

    // Main method to take multiple test cases as input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q17_Check_If_Array_Is_Sorted_And_Rotated checker = new Q17_Check_If_Array_Is_Sorted_And_Rotated();

        // Read the number of test cases
        System.out.print("Enter the number of test cases: ");
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

            // Call the check method to verify if the array is sorted and rotated
            boolean isSortedAndRotated = checker.check(nums);

            // Output the result
            if (isSortedAndRotated) {
                System.out.println("The array is sorted and rotated.");
            } else {
                System.out.println("The array is not sorted and rotated.");
            }
        }

        sc.close(); // Close the scanner
    }
}
