import java.util.ArrayList;
import java.util.Scanner;

public class Q6_Allocate_Books {

    // Function to check if it's possible to allocate books with the given mid value
    public static boolean isPossible(ArrayList<Integer> arr, int n, int m, int mid) {
        int studentCount = 1; // At least one student is required
        int pageSum = 0; // Pages currently allocated to the student

        for (int i = 0; i < n; i++) {
            if (pageSum + arr.get(i) <= mid) {
                pageSum += arr.get(i); // Allocate the book to the current student
            } else {
                studentCount++; // Allocate to a new student
                if (studentCount > m || arr.get(i) > mid) {
                    return false; // If more students are needed or a book can't fit in the limit
                }
                pageSum = arr.get(i); // Reset pages for new student
            }
        }
        return true; // Possible to allocate books
    }

    // Function to allocate books
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if (m > n) return -1; // Edge case: if more students than books, impossible to allocate

        int s = 0;
        int e = 0; // End is the sum of all pages

        // Calculate the sum of all book pages and find the max book size
        for (int i = 0; i < n; i++) {
            e += arr.get(i);
        }

        int ans = -1; // Store the answer (minimum possible max number of pages)

        // Perform binary search
        while (s <= e) {
            int mid = s + (e - s) / 2; // Mid-point
            if (isPossible(arr, n, m, mid)) {
                ans = mid; // Mid is a potential answer
                e = mid - 1; // Try to find a smaller valid mid
            } else {
                s = mid + 1; // Try to increase mid
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of test cases
        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();

        // Loop through each test case
        while (t-- > 0) {
            // Input number of books (n) and students (m)
            System.out.print("Enter number of books and students: ");
            int n = sc.nextInt();
            int m = sc.nextInt();

            // Input the array of pages in books
            ArrayList<Integer> arr = new ArrayList<>();
            System.out.println("Enter the pages in each book:");
            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }

            // Output the result
            int result = findPages(arr, n, m);
            if (result != -1) {
                System.out.println("Minimum number of pages: " + result);
            } else {
                System.out.println("Allocation not possible.");
            }
        }
        sc.close();
    }
}
