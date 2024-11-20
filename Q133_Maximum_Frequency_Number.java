import java.util.*;

public class Q133_Maximum_Frequency_Number {
    public static int maxFrequencyNumber(int n, int[] arr) {
        // Map to store frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        // Map to store the first occurrence of each number
        Map<Integer, Integer> firstIndexMap = new HashMap<>();

        // Track the maximum frequency and the number associated with it
        int maxFrequency = 0;
        int result = -1;

        for (int i = 0; i < n; i++) {
            int num = arr[i];

            // Increment the frequency of the current number
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

            // Record the first occurrence index if not already present
            if (!firstIndexMap.containsKey(num)) {
                firstIndexMap.put(num, i);
            }

            // Update the result if the current number has higher frequency
            // or if the frequency is equal but it occurs earlier
            if (frequencyMap.get(num) > maxFrequency || 
               (frequencyMap.get(num) == maxFrequency && firstIndexMap.get(num) < firstIndexMap.get(result))) {
                maxFrequency = frequencyMap.get(num);
                result = num;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            System.out.print("Enter the size of the array: ");
            int n = sc.nextInt();

            int[] arr = new int[n];
            System.out.print("Enter the elements of the array: ");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int result = maxFrequencyNumber(n, arr);
            System.out.println("Maximum Frequency Number: " + result);
        }

        sc.close();
    }
}
