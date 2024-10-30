import java.util.Scanner;
import java.util.Stack;

public class Q73_Max_Rectangle {

    // Helper function to calculate the largest rectangle area in a histogram.
    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int h = (i == n ? 0 : heights[i]); // Treat last element as zero height for final cleanup
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }

    // Optimized function to find the maximum area of rectangle formed by 1s in a binary matrix.
    public int maxArea(int[][] M, int n, int m) {
        int[] heights = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            // Update the histogram heights for the current row
            for (int j = 0; j < m; j++) {
                // Increment height if we have a '1', else reset height to 0
                heights[j] = (M[i][j] == 0) ? 0 : heights[j] + 1;
            }
            // Calculate the largest rectangle area in the current histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for test cases
        System.out.println("Enter the number of test cases:");
        int t = scanner.nextInt();

        for (int test = 1; test <= t; test++) {
            System.out.println("Enter the number of rows and columns for the matrix:");
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int[][] M = new int[n][m];
            System.out.println("Enter the matrix elements (0s and 1s):");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    M[i][j] = scanner.nextInt();
                }
            }

            // Create an instance of the class to call the maxArea method
            Q73_Max_Rectangle solution = new Q73_Max_Rectangle();
            int maxRectangleArea = solution.maxArea(M, n, m);

            // Output result for the test case
            System.out.println("The maximum area of rectangle formed only by 1s for test case " + test + " is: " + maxRectangleArea);
        }

        scanner.close();
    }
}
