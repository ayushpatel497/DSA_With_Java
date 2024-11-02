import java.util.Scanner;

public class Q77_Circular_Queue {
    private int[] queue;
    private int front, rear, size, capacity;

    // Constructor to initialize the circular queue with size `n`
    public Q77_Circular_Queue(int n) {
        queue = new int[n];
        front = -1;
        rear = -1;
        size = 0;
        capacity = n;
    }

    // Enqueue function to add an element to the queue
    public boolean enqueue(int value) {
        if (size == capacity) {
            return false; // Queue is full
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
        return true;
    }

    // Dequeue function to remove an element from the front of the queue
    public int dequeue() {
        if (size == 0) {
            return -1; // Queue is empty
        }
        int removedValue = queue[front];
        front = (front + 1) % capacity;
        size--;
        if (size == 0) {
            front = -1;
            rear = -1;
        }
        return removedValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the circular queue: ");
        int n = scanner.nextInt();
        Q77_Circular_Queue circularQueue = new Q77_Circular_Queue(n);

        System.out.print("Enter number of test cases: ");
        int t = scanner.nextInt();

        // Process each operation based on the test cases
        for (int i = 0; i < t; i++) {
            System.out.print("Choose operation (1: Enqueue, 2: Dequeue): ");
            int operation = scanner.nextInt();

            switch (operation) {
                case 1: // Enqueue
                    System.out.print("Enter value to enqueue: ");
                    int value = scanner.nextInt();
                    if (circularQueue.enqueue(value)) {
                        System.out.println("Enqueued: " + value);
                    } else {
                        System.out.println("Queue is full. Cannot enqueue.");
                    }
                    break;

                case 2: // Dequeue
                    int removed = circularQueue.dequeue();
                    if (removed == -1) {
                        System.out.println("Queue is empty. Cannot dequeue.");
                    } else {
                        System.out.println("Dequeued: " + removed);
                    }
                    break;

                default:
                    System.out.println("Invalid operation.");
                    break;
            }
        }
        
        scanner.close();
    }
}
