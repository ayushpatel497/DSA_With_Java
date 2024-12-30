import java.util.Scanner;

public class Q199_Check_If_It_Is_Possible_To_Survive_On_Island {
    // Function to calculate minimum days
    static int minimumDays(int S, int N, int M) {
        // Total food required
        int totalFood = S * M;
        
        // Working days (excluding Sundays)
        int workingDays = S - S / 7;
        
        // Calculate the minimum number of days required
        int ans = 0;
        if (totalFood % N == 0) {
            ans = totalFood / N;
        } else {
            ans = totalFood / N + 1;
        }
        
        // Feasibility check
        if (ans <= workingDays) {
            return ans;
        } else {
            return -1;
        }
    }

    // Main function to take dynamic test cases
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt(); // Number of test cases
        
        while (t-- > 0) {
            System.out.print("Enter S (number of days to survive): ");
            int S = sc.nextInt();
            
            System.out.print("Enter N (max food you can buy per day): ");
            int N = sc.nextInt();
            
            System.out.print("Enter M (food required per day): ");
            int M = sc.nextInt();
            
            int result = minimumDays(S, N, M);
            if (result == -1) {
                System.out.println("Survival is not possible.");
            } else {
                System.out.println("Minimum days required to buy food: " + result);
            }
        }
        
        sc.close();
    }
}
