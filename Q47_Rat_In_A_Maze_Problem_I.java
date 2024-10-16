import java.util.*;

public class Q47_Rat_In_A_Maze_Problem_I {

    // Function to find all possible paths in the maze
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> result = new ArrayList<>();
        
        // If starting cell is blocked, return an empty list
        if (mat[0][0] == 0 || mat[mat.length - 1][mat[0].length - 1] == 0) {
            return result;
        }
        
        // Define a visited matrix to track cells that are part of the current path
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        
        // Start backtracking from the top-left corner (0, 0)
        backtrack(mat, 0, 0, visited, "", result);
        return result;
    }

    // Helper function for backtracking
    private void backtrack(int[][] mat, int row, int col, boolean[][] visited, String path, ArrayList<String> result) {
        // Base case: If we reach the bottom-right corner, add the path to the result
        if (row == mat.length - 1 && col == mat[0].length - 1) {
            result.add(path);
            return;
        }

        // Mark the current cell as visited
        visited[row][col] = true;

        // Move in all four directions: down (D), left (L), right (R), up (U)

        // Move down (D)
        if (isSafe(mat, row + 1, col, visited)) {
            backtrack(mat, row + 1, col, visited, path + 'D', result);
        }

        // Move left (L)
        if (isSafe(mat, row, col - 1, visited)) {
            backtrack(mat, row, col - 1, visited, path + 'L', result);
        }

        // Move right (R)
        if (isSafe(mat, row, col + 1, visited)) {
            backtrack(mat, row, col + 1, visited, path + 'R', result);
        }

        // Move up (U)
        if (isSafe(mat, row - 1, col, visited)) {
            backtrack(mat, row - 1, col, visited, path + 'U', result);
        }

        // Backtrack by marking the current cell as unvisited
        visited[row][col] = false;
    }

    // Function to check if the move is valid and safe
    private boolean isSafe(int[][] mat, int row, int col, boolean[][] visited) {
        return (row >= 0 && row < mat.length && col >= 0 && col < mat[0].length && mat[row][col] == 1 && !visited[row][col]);
    }

    // Main function for handling multiple test cases
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of test cases
        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();

        for (int test = 0; test < t; test++) {
            // Input dimensions of the matrix
            System.out.print("Enter number of rows and columns: ");
            int n = sc.nextInt();
            int m = sc.nextInt();

            // Input the matrix
            int[][] mat = new int[n][m];
            System.out.println("Enter the matrix elements (0 or 1):");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            // Find and print all paths
            Q47_Rat_In_A_Maze_Problem_I obj = new Q47_Rat_In_A_Maze_Problem_I();
            ArrayList<String> paths = obj.findPath(mat);
            
            if (paths.isEmpty()) {
                System.out.println("No possible path.");
            } else {
                System.out.println("Possible paths:");
                for (String path : paths) {
                    System.out.println(path);
                }
            }
        }

        sc.close();
    }
}
