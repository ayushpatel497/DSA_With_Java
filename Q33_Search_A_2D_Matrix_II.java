import java.util.Scanner;

class Q33_Search_A_2D_Matrix_II {
    // Function to search for a target value in a 2D matrix with sorted rows and columns
    public boolean searchMatrix(int[][] matrix, int target) {
        // Check if matrix is empty
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Start from the top-right corner of the matrix
        int row = 0;
        int col = cols - 1;

        // Traverse the matrix
        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                // If the current element is greater than the target, move left
                col--;
            } else {
                // If the current element is smaller than the target, move down
                row++;
            }
        }

        // If target is not found, return false
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

            Q33_Search_A_2D_Matrix_II obj = new Q33_Search_A_2D_Matrix_II();
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
