import java.util.Scanner;

public class Q29_Print_Like_A_Wave {

	// Function to print the 2D array in wave-like order
	public static int[] wavePrint(int arr[][], int nRows, int mCols) {
		int[] result = new int[nRows * mCols];
		int index = 0;
		
		// Traverse through columns
		for (int col = 0; col < mCols; col++) {
			// For even indexed column, go top to bottom
			if (col % 2 == 0) {
				for (int row = 0; row < nRows; row++) {
					result[index++] = arr[row][col];
				}
			} 
			// For odd indexed column, go bottom to top
			else {
				for (int row = nRows - 1; row >= 0; row--) {
					result[index++] = arr[row][col];
				}
			}
		}
		return result;
	}

	// Main method to take multiple test cases input
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of test cases: ");
		int testCases = sc.nextInt();
		
		for (int t = 0; t < testCases; t++) {
			System.out.println("Enter number of rows and columns for test case " + (t + 1) + ": ");
			int nRows = sc.nextInt();
			int mCols = sc.nextInt();
			
			int[][] arr = new int[nRows][mCols];
			
			System.out.println("Enter the elements of the matrix:");
			for (int i = 0; i < nRows; i++) {
				for (int j = 0; j < mCols; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int[] waveResult = wavePrint(arr, nRows, mCols);
			
			System.out.println("Wave print of the matrix for test case " + (t + 1) + ":");
			for (int num : waveResult) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
