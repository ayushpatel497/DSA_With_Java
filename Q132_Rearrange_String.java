import java.util.*;

public class Q132_Rearrange_String {

    public static String reArrangeString(String s) {
        // Frequency map for each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // PriorityQueue to store characters based on their frequencies (max heap)
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(frequencyMap.entrySet());

        StringBuilder result = new StringBuilder();
        Map.Entry<Character, Integer> prev = null;

        while (!maxHeap.isEmpty()) {
            // Get the character with the highest frequency
            Map.Entry<Character, Integer> current = maxHeap.poll();

            // Append the character to the result
            result.append(current.getKey());

            // Decrease its frequency
            current.setValue(current.getValue() - 1);

            // Re-add the previous character (if it still has remaining frequency)
            if (prev != null && prev.getValue() > 0) {
                maxHeap.offer(prev);
            }

            // Update the previous character to the current one
            prev = current;
        }

        // If the result length is not the same as the input, it's not possible
        if (result.length() != s.length()) {
            return "not possible";
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline

        while (t-- > 0) {
            System.out.print("Enter the string: ");
            String s = sc.nextLine();

            String result = reArrangeString(s);
            System.out.println("Re-arranged string: " + result);
        }

        sc.close();
    }
}
