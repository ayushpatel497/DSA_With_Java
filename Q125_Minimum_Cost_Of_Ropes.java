import java.util.PriorityQueue;
import java.util.Scanner;

class Q125_Minimum_Cost_Of_Ropes {
    // Function to return the minimum cost of connecting the ropes.
    public int minCost(int[] arr) {
        // Create a priority queue (min-heap)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all rope lengths to the min-heap
        for (int length : arr) {
            minHeap.add(length);
        }

        int totalCost = 0;

        // Process the heap until only one rope remains
        while (minHeap.size() > 1) {
            // Take out the two smallest ropes
            int first = minHeap.poll();
            int second = minHeap.poll();

            // Calculate the cost of connecting these ropes
            int cost = first + second;
            totalCost += cost;

            // Add the combined rope back to the heap
            minHeap.add(cost);
        }

        return totalCost;
    }

    // Main method to take dynamic input and run test cases
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Q125_Minimum_Cost_Of_Ropes solution = new Q125_Minimum_Cost_Of_Ropes();

        System.out.print("Enter the number of test cases: ");
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            System.out.print("Enter the number of ropes for test case " + i + ": ");
            int n = scanner.nextInt();
            int[] ropes = new int[n];

            System.out.println("Enter the lengths of the ropes:");
            for (int j = 0; j < n; j++) {
                ropes[j] = scanner.nextInt();
            }

            int result = solution.minCost(ropes);
            System.out.println("Minimum cost of connecting ropes for test case " + i + ": " + result);
        }
        
        scanner.close();
    }
}
