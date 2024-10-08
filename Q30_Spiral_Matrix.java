import java.util.*;

public class Q30_Spiral_Matrix {
    // Function to return a list of integers representing the spiral order of the matrix
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top row
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse downwards along the right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Check if top and bottom overlap
            if (top <= bottom) {
                // Traverse from right to left along the bottom row
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Check if left and right overlap
            if (left <= right) {
                // Traverse upwards along the left column
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    // Main method to handle multiple test cases input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of test cases: ");
        int testCases = sc.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            System.out.println("Enter number of rows and columns for test case " + (t + 1) + ": ");
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            
            int[][] matrix = new int[rows][cols];
            
            System.out.println("Enter the elements of the matrix:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            Q30_Spiral_Matrix obj = new Q30_Spiral_Matrix();
            List<Integer> spiralResult = obj.spiralOrder(matrix);
            
            System.out.println("Spiral order of the matrix for test case " + (t + 1) + ":");
            for (int num : spiralResult) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        
        sc.close();
    }
}
