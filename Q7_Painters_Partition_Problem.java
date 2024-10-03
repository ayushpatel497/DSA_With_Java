import java.util.ArrayList;
import java.util.Scanner;

public class Q7_Painters_Partition_Problem {

    // Function to check if it's possible to paint all boards with the given maximum length (mid)
    public static boolean isPossible(ArrayList<Integer> boards, int k, int mid) {
        int painterCount = 1;  // Start with the first painter
        int boardSum = 0;      // Sum of board lengths painted by the current painter

        for (int i = 0; i < boards.size(); i++) {
            // If the current board can be painted by the current painter within the allowed length (mid)
            if (boardSum + boards.get(i) <= mid) {
                boardSum += boards.get(i);  // Add the board length to the current painter's workload
            } else {
                // If the current board cannot be painted, assign it to a new painter
                painterCount++;
                // If the number of painters exceeds the allowed number or the board itself is larger than mid, return false
                if (painterCount > k || boards.get(i) > mid) {
                    return false;
                }
                boardSum = boards.get(i);  // Assign the current board length to the new painter
            }
        }
        return true;  // Return true if all boards can be painted by k or fewer painters
    }

    // Function to find the largest minimum distance (i.e., the minimum time in which all painters can paint the boards)
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        int s = 0;  // Start of the search space (minimum possible value)
        int e = 0;  // End of the search space (total sum of all board lengths)
        int ans = -1;  // Variable to store the result

        // Calculate the total sum of all boards' lengths to set the upper bound for binary search (e)
        for (int i = 0; i < boards.size(); i++) {
            e += boards.get(i);
        }

        // Perform binary search to find the largest minimum distance
        while (s <= e) {
            int mid = s + (e - s) / 2;  // Midpoint of the current search space

            // Check if it's possible to paint all boards with the current max length (mid)
            if (isPossible(boards, k, mid)) {
                ans = mid;  // Update the answer to the current mid
                e = mid - 1;  // Try for a smaller max length
            } else {
                s = mid + 1;  // Try for a larger max length
            }
        }
        return ans;  // Return the final result (largest minimum distance)
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // Number of test cases

        // Loop over the number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of boards
            int k = sc.nextInt(); // Number of painters

            ArrayList<Integer> boards = new ArrayList<>();
            // Take input for board lengths
            for (int i = 0; i < n; i++) {
                boards.add(sc.nextInt());
            }

            // Calculate and print the result for each test case
            int result = findLargestMinDistance(boards, k);
            System.out.println(result);
        }
        sc.close();
    }
}
