import java.util.*;

public class Q81_Reverse_First_K_Elements_Of_Queue {

    // Function to reverse first k elements of a queue
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Stack<Integer> stack = new Stack<>();

        // Step 1: Push first k elements from the queue into the stack
        for (int i = 0; i < k; i++) {
            stack.push(q.remove());
        }

        // Step 2: Pop elements from the stack and add them back to the queue
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }

        // Step 3: Move the rest of the elements (q.size() - k) to the back to maintain order
        for (int i = 0; i < q.size() - k; i++) {
            q.add(q.remove());
        }

        return q;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of test cases
        System.out.print("Enter the number of test cases: ");
        int t = scanner.nextInt();

        for (int testCase = 1; testCase <= t; testCase++) {
            // Input queue size and the value of k
            System.out.print("Enter the size of the queue: ");
            int n = scanner.nextInt();
            System.out.print("Enter the number of elements to reverse (k): ");
            int k = scanner.nextInt();

            Queue<Integer> queue = new LinkedList<>();
            System.out.println("Enter the elements of the queue:");
            for (int i = 0; i < n; i++) {
                queue.add(scanner.nextInt());
            }

            // Reverse the first k elements of the queue
            Q81_Reverse_First_K_Elements_Of_Queue solution = new Q81_Reverse_First_K_Elements_Of_Queue();
            Queue<Integer> result = solution.modifyQueue(queue, k);

            // Display the result
            System.out.println("Modified queue: " + result);
        }

        scanner.close();
    }
}
