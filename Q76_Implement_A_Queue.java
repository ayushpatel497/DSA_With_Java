import java.util.LinkedList;
import java.util.Scanner;

public class Q76_Implement_A_Queue {
    private LinkedList<Integer> queue;

    // Constructor to initialize the queue
    public Q76_Implement_A_Queue() {
        queue = new LinkedList<>();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Add an element to the end of the queue
    public void enqueue(int data) {
        queue.addLast(data);
    }

    // Remove an element from the front of the queue
    public int dequeue() {
        if (isEmpty()) {
            return -1; // Return -1 if the queue is empty
        }
        return queue.removeFirst();
    }

    // Get the element at the front of the queue without removing it
    public int front() {
        if (isEmpty()) {
            return -1; // Return -1 if the queue is empty
        }
        return queue.getFirst();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Q76_Implement_A_Queue myQueue = new Q76_Implement_A_Queue();

        System.out.print("Enter number of test cases: ");
        int t = scanner.nextInt();

        // Processing each test case
        for (int i = 0; i < t; i++) {
            System.out.print("Choose operation (1: Enqueue, 2: Dequeue, 3: Front, 4: isEmpty): ");
            int operation = scanner.nextInt();

            switch (operation) {
                case 1: // Enqueue
                    System.out.print("Enter number to enqueue: ");
                    int data = scanner.nextInt();
                    myQueue.enqueue(data);
                    System.out.println("Enqueued: " + data);
                    break;

                case 2: // Dequeue
                    int removed = myQueue.dequeue();
                    if (removed == -1) {
                        System.out.println("Queue is empty. Cannot dequeue.");
                    } else {
                        System.out.println("Dequeued: " + removed);
                    }
                    break;

                case 3: // Front
                    int front = myQueue.front();
                    if (front == -1) {
                        System.out.println("Queue is empty. No front element.");
                    } else {
                        System.out.println("Front element: " + front);
                    }
                    break;

                case 4: // isEmpty
                    System.out.println("Is queue empty? " + myQueue.isEmpty());
                    break;

                default:
                    System.out.println("Invalid operation.");
                    break;
            }
        }
        
        scanner.close();
    }
}
