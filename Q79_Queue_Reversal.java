import java.util.*;

public class Q79_Queue_Reversal {
    
    // Function to reverse the queue
    public Queue<Integer> rev(Queue<Integer> q) {
        // Stack to store elements temporarily
        Stack<Integer> stack = new Stack<>();
        
        // Step 1: Dequeue all elements from the queue and push them onto the stack
        while (!q.isEmpty()) {
            stack.push(q.remove());
        }
        
        // Step 2: Pop all elements from the stack and enqueue them back to the queue
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
        
        return q; // Queue is now reversed
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Q79_Queue_Reversal queueReversal = new Q79_Queue_Reversal();
        
        // Input the number of test cases
        System.out.print("Enter number of test cases: ");
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            // Input the number of elements in the queue for this test case
            System.out.print("Enter number of elements in queue: ");
            int n = scanner.nextInt();
            
            Queue<Integer> queue = new LinkedList<>();
            
            System.out.println("Enter the elements of the queue:");
            for (int i = 0; i < n; i++) {
                queue.add(scanner.nextInt());
            }
            
            // Display original queue
            System.out.println("Original Queue: " + queue);
            
            // Reversing the queue
            Queue<Integer> reversedQueue = queueReversal.rev(queue);
            
            // Display reversed queue
            System.out.println("Reversed Queue: " + reversedQueue);
        }
        
        scanner.close();
    }
}
