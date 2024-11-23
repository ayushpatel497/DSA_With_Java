import java.util.*;

public class Q139_Sudoku_Solver {

    // Helper function to check if placing 'num' at (row, col) is valid
    private static boolean isValid(int[][] sudoku, int row, int col, int num) {
        // Check row
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == num) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == num) {
                return false;
            }
        }

        // Check 3x3 sub-grid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (sudoku[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    // Recursive function to solve the Sudoku
    private static boolean solve(int[][] sudoku) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Find an empty cell
                if (sudoku[row][col] == 0) {
                    // Try all numbers from 1 to 9
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(sudoku, row, col, num)) {
                            // Place the number
                            sudoku[row][col] = num;

                            // Recur to solve the rest
                            if (solve(sudoku)) {
                                return true;
                            }

                            // Backtrack
                            sudoku[row][col] = 0;
                        }
                    }
                    return false; // No valid number found, backtrack
                }
            }
        }
        return true; // All cells are filled
    }

    // Function to solve the Sudoku puzzle
    public static void solveSudoku(int[][] sudoku) {
        if (solve(sudoku)) {
            // Print the solved Sudoku
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(sudoku[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution exists");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the Sudoku puzzle
        System.out.println("Enter the Sudoku grid (row-wise, use 0 for empty cells):");
        int[][] sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = sc.nextInt();
            }
        }

        System.out.println("Solved Sudoku:");
        solveSudoku(sudoku);

        sc.close();
    }
}
