import java.util.*;

public class Q82_First_Non_Repeating_Character_In_A_Stream {

    public String FirstNonRepeating(String s) {
        // Queue to track the order of characters in the stream
        Queue<Character> queue = new LinkedList<>();
        // Array to store the frequency of each character
        int[] freq = new int[26];
        
        StringBuilder result = new StringBuilder();
        
        // Iterate over each character in the stream
        for (char ch : s.toCharArray()) {
            // Increase frequency count for the current character
            freq[ch - 'a']++;
            
            // Add the character to the queue
            queue.add(ch);
            
            // Check the queue's front for a non-repeating character
            while (!queue.isEmpty() && freq[queue.peek() - 'a'] > 1) {
                queue.poll(); // Remove characters with frequency > 1
            }
            
            // Append the first non-repeating character or '#' if none
            if (queue.isEmpty()) {
                result.append('#');
            } else {
                result.append(queue.peek());
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of test cases
        System.out.print("Enter the number of test cases: ");
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        for (int testCase = 1; testCase <= t; testCase++) {
            // Input stream string
            System.out.print("Enter the stream of characters: ");
            String s = scanner.nextLine();

            Q82_First_Non_Repeating_Character_In_A_Stream solution = new Q82_First_Non_Repeating_Character_In_A_Stream();
            String result = solution.FirstNonRepeating(s);

            // Display the result
            System.out.println("First non-repeating characters: " + result);
        }

        scanner.close();
    }
}
