import java.util.*;

public class Q46_Permutations {
    
    // Function to return all permutations of the input array
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPermutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length]; // To track which elements are used in the current permutation
        generatePermutations(nums, currentPermutation, used, result);
        return result;
    }

    // Recursive helper function to generate permutations
    private void generatePermutations(int[] nums, List<Integer> currentPermutation, boolean[] used, List<List<Integer>> result) {
        // Base case: if the current permutation has all the numbers, add it to the result
        if (currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation)); // Add a copy of the current permutation
            return;
        }

        // Recursive case: explore every number in the nums array
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                // Choose the current number (i) to be in the permutation
                currentPermutation.add(nums[i]);
                used[i] = true;

                // Recursively generate permutations with the remaining numbers
                generatePermutations(nums, currentPermutation, used, result);

                // Backtrack by removing the last chosen number and marking it as unused
                used[i] = false;
                currentPermutation.remove(currentPermutation.size() - 1);
            }
        }
    }

    // Main function to handle multiple test cases
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of test cases
        System.out.print("Enter the number of test cases: ");
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            // Input array size and elements
            System.out.print("Enter the size of the array: ");
            int n = scanner.nextInt();
            int[] nums = new int[n];
            
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            // Get the permutations
            Q46_Permutations obj = new Q46_Permutations();
            List<List<Integer>> permutations = obj.permute(nums);

            // Output the result
            System.out.println("Permutations:");
            for (List<Integer> permutation : permutations) {
                System.out.println(permutation);
            }
        }

        scanner.close();
    }
}
