import java.util.Scanner;

public class Q37_Count_Ways_To_Reach_The_Nth_Stairs {

    // Recursive function to count the number of distinct ways to climb stairs
    public static long countDistinctWayToClimbStair(int nStairs) {
        // Base cases
        if (nStairs == 0 || nStairs == 1) {
            return 1;
        }

        // Recursive calls: sum of ways to reach (n-1)th and (n-2)th stairs
        return countDistinctWayToClimbStair(nStairs - 1) + countDistinctWayToClimbStair(nStairs - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of test cases
        System.out.print("Enter the number of test cases: ");
        int testCases = scanner.nextInt();

        // Process each test case
        for (int t = 0; t < testCases; t++) {
            // Read the number of stairs
            System.out.print("Enter the number of stairs: ");
            int nStairs = scanner.nextInt();

            // Output the result
            long result = countDistinctWayToClimbStair(nStairs);
            System.out.println("Ways to climb " + nStairs + " stairs = " + result);
        }

        scanner.close();
    }
}
