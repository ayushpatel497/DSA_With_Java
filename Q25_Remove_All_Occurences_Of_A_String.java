import java.util.Scanner;

public class Q25_Remove_All_Occurences_Of_A_String {
    
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);

        // Continue removing occurrences until none are left
        while (sb.indexOf(part) != -1) {
            int index = sb.indexOf(part); // Find the index of the first occurrence
            sb.delete(index, index + part.length()); // Remove the occurrence
        }
        return sb.toString(); // Return the modified string
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Taking input for multiple test cases
        System.out.print("Enter the number of test cases: ");
        int testCases = sc.nextInt();
        sc.nextLine(); // Consume the newline character after reading the number

        // Creating an instance of the class
        Q25_Remove_All_Occurences_Of_A_String remover = new Q25_Remove_All_Occurences_Of_A_String();

        // Processing each test case
        for (int t = 0; t < testCases; t++) {
            System.out.print("Enter the string s for test case " + (t + 1) + ": ");
            String s = sc.nextLine();
            System.out.print("Enter the substring part for test case " + (t + 1) + ": ");
            String part = sc.nextLine();

            // Call the removeOccurrences method
            String result = remover.removeOccurrences(s, part);
            System.out.println("Result for test case " + (t + 1) + ": " + result);
        }

        sc.close(); // Close the scanner
    }
}
