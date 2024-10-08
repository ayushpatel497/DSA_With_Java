import java.util.*;
class Q31_Rotate_Image {
    // Function to rotate the matrix 90 degrees clockwise
    public void rotate(int[][] matrix) {
        // Step 1: Transpose the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row to complete the 90-degree clockwise rotation
        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix[0].length - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    // Main function to handle multiple test cases
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            System.out.println("Enter the size of the matrix (n x n) for test case " + (t + 1) + ": ");
            int n = sc.nextInt();

            int[][] matrix = new int[n][n];

            System.out.println("Enter the elements of the matrix:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            Q31_Rotate_Image obj = new Q31_Rotate_Image();
            obj.rotate(matrix);

            System.out.println("Matrix after 90-degree clockwise rotation for test case " + (t + 1) + ":");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}
