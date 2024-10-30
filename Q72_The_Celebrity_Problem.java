import java.util.Scanner;
import java.util.Stack;

public class Q72_The_Celebrity_Problem {

    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int[][] mat) {
        int n = mat.length;
        Stack<Integer> stack = new Stack<>();

        // Step 1: Push all people onto the stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        // Step 2: Determine the potential celebrity
        while (stack.size() > 1) {
            int A = stack.pop();
            int B = stack.pop();

            if (mat[A][B] == 1) {
                // A knows B, so A cannot be a celebrity
                stack.push(B);
            } else {
                // A does not know B, so B cannot be a celebrity
                stack.push(A);
            }
        }

        // Step 3: Verify the potential celebrity
        int candidate = stack.pop();

        // Check if candidate is known by everyone else and doesn't know anyone
        for (int i = 0; i < n; i++) {
            if (i != candidate && (mat[candidate][i] == 1 || mat[i][candidate] == 0)) {
                return -1; // Candidate fails celebrity conditions
            }
        }

        return candidate; // Candidate is the celebrity
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for test cases
        System.out.println("Enter the number of test cases:");
        int t = scanner.nextInt();

        for (int test = 1; test <= t; test++) {
            System.out.println("Enter the number of people at the party:");
            int n = scanner.nextInt();

            // Input the n x n matrix
            int[][] mat = new int[n][n];
            System.out.println("Enter the matrix (0s and 1s) representing who knows whom:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = scanner.nextInt();
                }
            }

            // Create an instance of the class to call the celebrity method
            Q72_The_Celebrity_Problem solution = new Q72_The_Celebrity_Problem();
            int celebrityIndex = solution.celebrity(mat);

            // Output result for the test case
            if (celebrityIndex == -1) {
                System.out.println("There is no celebrity at the party for test case " + test + ".");
            } else {
                System.out.println("The celebrity at the party for test case " + test + " is at index: " + celebrityIndex);
            }
        }

        scanner.close(); // Close the scanner to avoid resource leaks
    }
}
