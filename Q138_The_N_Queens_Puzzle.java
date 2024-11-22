import java.util.*;

public class Q138_The_N_Queens_Puzzle {

    private static boolean isSafe(int row, int col, int n, int[][] board) {
        // Check the column above
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check the upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check the upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private static void solve(int row, int n, int[][] board, ArrayList<ArrayList<Integer>> result) {
        if (row == n) {
            // Flatten the current board into a single list
            ArrayList<Integer> solution = new ArrayList<>();
            for (int[] rows : board) {
                for (int cell : rows) {
                    solution.add(cell);
                }
            }
            result.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, n, board)) {
                board[row][col] = 1; // Place the queen
                solve(row + 1, n, board, result);
                board[row][col] = 0; // Backtrack
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> nQueens(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[][] board = new int[n][n];

        solve(0, n, board, result);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            System.out.print("\nEnter the value of N: ");
            int n = sc.nextInt();

            ArrayList<ArrayList<Integer>> solutions = nQueens(n);

            System.out.println("\nSolutions:");
            if (solutions.isEmpty()) {
                System.out.println("No solution exists");
            } else {
                for (ArrayList<Integer> solution : solutions) {
                    for (int cell : solution) {
                        System.out.print(cell + " ");
                    }
                    System.out.println();
                }
            }
        }

        sc.close();
    }
}
