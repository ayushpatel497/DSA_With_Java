import java.util.Scanner;
import java.util.Stack;

public class Q71_Largest_Rectangle_In_Histogram {

    // Method to calculate the largest rectangle area in a histogram
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0; // Variable to store the maximum area found
        int n = heights.length;
        
        // Stack to store indices of the bars in ascending order of heights
        Stack<Integer> stack = new Stack<>();

        // Loop through each bar in the histogram, including an extra loop to handle remaining bars
        for (int i = 0; i <= n; i++) {
            // Use 0 as a dummy height for the "end" of the histogram to trigger remaining stack processing
            int currentHeight = (i == n) ? 0 : heights[i];

            // If the current height is less than the height of the bar at stack's top, calculate area
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()]; // Pop the height from the stack
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; // Calculate the width for this height
                maxArea = Math.max(maxArea, height * width); // Update maxArea if this area is larger
            }

            // Push the current index to stack
            stack.push(i);
        }

        return maxArea; // Return the maximum rectangle area found
    }

    public static void main(String[] args) {
        Q71_Largest_Rectangle_In_Histogram solution = new Q71_Largest_Rectangle_In_Histogram();
        Scanner scanner = new Scanner(System.in);

        // Prompt for the number of test cases
        System.out.println("Enter the number of test cases:");
        int testCases = scanner.nextInt();

        // Process each test case
        for (int t = 1; t <= testCases; t++) {
            System.out.println("Enter the number of elements in the histogram:");
            int n = scanner.nextInt(); // Number of bars in the histogram

            // Read histogram heights
            int[] heights = new int[n];
            System.out.println("Enter the heights of the histogram bars:");
            for (int i = 0; i < n; i++) {
                heights[i] = scanner.nextInt();
            }

            // Calculate and display the largest rectangle area for this test case
            int maxRectangleArea = solution.largestRectangleArea(heights);
            System.out.println("The largest rectangle area for test case " + t + " is: " + maxRectangleArea);
        }

        // Close the scanner to avoid resource leaks
        scanner.close();
    }
}
