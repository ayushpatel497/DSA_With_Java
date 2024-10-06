import java.util.*;

public class Q18_Sum_Of_Two_Arrays {
    public static int[] findArraySum(int[] a, int n, int[] b, int m) {
        // Initialize result array with size of max(n, m) + 1 to accommodate carry if needed
        int[] ans = new int[Math.max(n, m) + 1];
        int i = n - 1; // Pointer for array 'a'
        int j = m - 1; // Pointer for array 'b'
        int k = ans.length - 1; // Pointer for the result array
        int carry = 0; // Initialize carry

        // Traverse both arrays from the end
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry; // Start with carry value

            // Add value from 'a' if it's within bounds
            if (i >= 0) {
                sum += a[i];
                i--;
            }

            // Add value from 'b' if it's within bounds
            if (j >= 0) {
                sum += b[j];
                j--;
            }

            // Calculate carry and the current digit
            carry = sum / 10;
            ans[k] = sum % 10;
            k--;
        }

        // If the result array starts with 0, we need to remove it
        if (ans[0] == 0) {
            return Arrays.copyOfRange(ans, 1, ans.length); // Return the array without leading 0
        }
        return ans; // Return the complete result array
    }

    // Main method to test the function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read multiple test cases
        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();

        for (int test = 0; test < t; test++) {
            // Input array 'a'
            System.out.print("Enter the size of array a: ");
            int n = sc.nextInt();
            int[] a = new int[n];
            System.out.print("Enter elements of array a: ");
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            // Input array 'b'
            System.out.print("Enter the size of array b: ");
            int m = sc.nextInt();
            int[] b = new int[m];
            System.out.print("Enter elements of array b: ");
            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }

            // Find the sum of the two arrays
            int[] result = findArraySum(a, n, b, m);

            // Output the result
            System.out.print("Sum of the arrays: ");
            for (int num : result) {
                System.out.print(num);
            }
            System.out.println();
        }

        sc.close();
    }
}
