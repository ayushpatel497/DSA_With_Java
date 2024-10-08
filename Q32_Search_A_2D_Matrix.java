import java.util.*;
class Q32_Search_A_2D_Matrix {
    // Function to search for a target value in a 2D matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        // If the matrix is empty, return false
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;    // Number of rows
        int n = matrix[0].length; // Number of columns

        // Treat the 2D matrix as a 1D array and use binary search
        int left = 0;
        int right = m * n - 1;

        // Binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / n][mid % n];  // Convert mid index to 2D index

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    // Main function to handle multiple test cases
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            System.out.println("Enter the dimensions of the matrix (m x n) for test case " + (t + 1) + ": ");
            int m = sc.nextInt();
            int n = sc.nextInt();

            int[][] matrix = new int[m][n];

            System.out.println("Enter the elements of the matrix:");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            System.out.print("Enter the target value for test case " + (t + 1) + ": ");
            int target = sc.nextInt();

            Q32_Search_A_2D_Matrix obj = new Q32_Search_A_2D_Matrix();
            boolean result = obj.searchMatrix(matrix, target);

            if (result) {
                System.out.println("Target " + target + " is found in the matrix.");
            } else {
                System.out.println("Target " + target + " is not found in the matrix.");
            }
        }

        sc.close();
    }
}
