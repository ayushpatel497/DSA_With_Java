import java.util.Scanner;

class Q3_Peak_Index_In_A_Mountain_Array {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If the mid element is greater than the next element
            if (arr[mid] > arr[mid + 1]) {
                // The peak is either at mid or to the left of mid
                high = mid;
            } else {
                // We are in the increasing part of the mountain
                low = mid + 1;
            }
        }

        // low and high will converge to the peak element index
        return low;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of test cases
        System.out.print("Enter the number of test cases: ");
        int t = scanner.nextInt();

        // Loop for each test case
        for (int testCase = 0; testCase < t; testCase++) {
            System.out.println("Test case " + (testCase + 1) + ":");

            // Take array size input
            System.out.print("Enter the size of the mountain array: ");
            int n = scanner.nextInt();

            // Input the mountain array from the user
            int[] arr = new int[n];
            System.out.println("Enter the elements of the mountain array: ");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            // Create an instance of the class and call the method
            Q3_Peak_Index_In_A_Mountain_Array peakFinder = new Q3_Peak_Index_In_A_Mountain_Array();
            int peakIndex = peakFinder.peakIndexInMountainArray(arr);

            // Output the result
            System.out.println("Peak index: " + peakIndex);
        }

        scanner.close();
    }
}

