import java.util.*;

public class Q43_Subsets {

    // Helper function to generate subsets using backtracking
    private void generateSubsets(int index, int[] nums, List<Integer> subset, List<List<Integer>> result) {
        // Add the current subset to the result
        result.add(new ArrayList<>(subset));

        // Recursively explore adding each element to the subset
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);  // Add element to the current subset
            generateSubsets(i + 1, nums, subset, result);  // Recur for the next index
            subset.remove(subset.size() - 1);  // Backtrack by removing the last element added
        }
    }

    // Function to generate all subsets
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();  // To store all the subsets
        List<Integer> subset = new ArrayList<>();  // Temporary list to store a subset
        generateSubsets(0, nums, subset, result);  // Call the recursive function
        return result;
    }

    // Main function to take multiple test cases
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of test cases
        System.out.print("Enter the number of test cases: ");
        int testCases = scanner.nextInt();

        Q43_Subsets obj = new Q43_Subsets();

        for (int t = 0; t < testCases; t++) {
            // Input size of the array
            System.out.print("Enter the size of the array: ");
            int n = scanner.nextInt();

            // Input elements of the array
            int[] nums = new int[n];
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            // Get all subsets
            List<List<Integer>> subsets = obj.subsets(nums);

            // Print the subsets
            System.out.println("Subsets:");
            for (List<Integer> subset : subsets) {
                System.out.println(subset);
            }
        }

        scanner.close();
    }
}
