import java.util.Scanner;

class Q83_Circular_Tour {
    
    // Function to find the starting point for a circular tour
    int tour(int petrol[], int distance[]) {
        int totalPetrolDeficit = 0;       // Stores deficit in petrol if we can't reach a pump
        int currentPetrolBalance = 0;     // Tracks the net petrol left as we travel
        int startingPoint = 0;            // Stores the index of the potential starting pump

        // Loop through each petrol pump to calculate petrol balance and determine the starting point
        for (int i = 0; i < petrol.length; i++) {
            int netPetrol = petrol[i] - distance[i]; // Petrol after traveling to next pump
            currentPetrolBalance += netPetrol;       // Update the current balance of petrol

            // If petrol balance is negative, reset the starting point and add to the total deficit
            if (currentPetrolBalance < 0) {
                totalPetrolDeficit += currentPetrolBalance; // Add deficit to total
                currentPetrolBalance = 0;                   // Reset balance for new start
                startingPoint = i + 1;                      // Set next pump as new starting point
            }
        }

        // If total petrol (balance + deficit) is non-negative, we found a valid start point
        if (currentPetrolBalance + totalPetrolDeficit >= 0) {
            return startingPoint;
        } else {
            return -1; // Otherwise, a complete circular tour is not possible
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user for number of test cases
        System.out.print("Enter the number of test cases: ");
        int testCases = scanner.nextInt();
        
        // Create an instance of Q83_Circular_Tour to call the tour function
        Q83_Circular_Tour solution = new Q83_Circular_Tour();
        
        // Iterate through each test case
        for (int t = 0; t < testCases; t++) {
            System.out.print("\nEnter the number of petrol pumps for test case " + (t + 1) + ": ");
            int n = scanner.nextInt();  // Number of petrol pumps
            
            int[] petrol = new int[n];  // Array to hold petrol amounts at each pump
            int[] distance = new int[n]; // Array to hold distances to the next pump
            
            System.out.println("Enter petrol quantities:");
            for (int i = 0; i < n; i++) {
                petrol[i] = scanner.nextInt(); // Read petrol amounts for each pump
            }
            
            System.out.println("Enter distances to next pump:");
            for (int i = 0; i < n; i++) {
                distance[i] = scanner.nextInt(); // Read distances to next pump
            }
            
            // Call tour function and get the starting point
            int result = solution.tour(petrol, distance);
            System.out.println("Starting point for test case " + (t + 1) + ": " + result);
        }
        
        scanner.close(); // Close the scanner
    }
}
