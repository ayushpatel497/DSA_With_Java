import java.util.Scanner;
import java.util.Arrays;

public class Q84_K_Queues_In_An_Array {

    public static class KQueues {
        private int[] arr;      // Array to store elements of all k queues
        private int[] front;    // Array to store indexes of front elements of each queue
        private int[] rear;     // Array to store indexes of rear elements of each queue
        private int[] next;     // Array to manage the next element or next free slot
        private int free;       // Start index of the free list

        // Constructor to initialize data structures
        public KQueues(int k, int n) {
            arr = new int[n];
            front = new int[k];
            rear = new int[k];
            next = new int[n];

            // Initialize all queues as empty
            Arrays.fill(front, -1);
            Arrays.fill(rear, -1);

            // Initialize the next array and free slot
            for (int i = 0; i < n - 1; i++) {
                next[i] = i + 1;
            }
            next[n - 1] = -1;
            free = 0;
        }

        // Check if a particular queue is empty
        private boolean isEmpty(int i) {
            return front[i] == -1;
        }

        // Check if all queues together are full
        private boolean isFull() {
            return free == -1;
        }

        // Enqueue an item in the j-th queue
        public void enqueue(int item, int j) {
            if (isFull()) {
                System.out.println("Queue overflow");
                return;
            }

            int insertAt = free;      // Index at which to insert new item
            free = next[insertAt];     // Update free to next free slot

            if (isEmpty(j)) {          // If queue j is empty, set both front and rear to insertAt
                front[j] = insertAt;
            } else {                   // Otherwise, link the new element to the rear of queue j
                next[rear[j]] = insertAt;
            }

            rear[j] = insertAt;        // Update rear to the new last element
            arr[insertAt] = item;      // Insert the item in the array
            next[insertAt] = -1;       // Mark the end of the queue
            System.out.println("Enqueued " + item + " to queue " + j);
        }

        // Dequeue an item from the i-th queue
        public int dequeue(int i) {
            if (isEmpty(i)) {
                System.out.println("Queue underflow");
                return -1;
            }

            int frontIndex = front[i]; // Index of the front element of queue i
            int item = arr[frontIndex]; // Get the item at the front of the queue
            front[i] = next[frontIndex]; // Update front to next element in the queue

            if (front[i] == -1) {       // If the queue is now empty, update rear
                rear[i] = -1;
            }

            next[frontIndex] = free;    // Add the index back to the free list
            free = frontIndex;          // Update free to the new free slot

            System.out.println("Dequeued " + item + " from queue " + i);
            return item;                // Return dequeued item
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the queues with the desired size and number of queues
        System.out.print("Enter number of queues: ");
        int numQueues = scanner.nextInt();
        System.out.print("Enter size of array: ");
        int arraySize = scanner.nextInt();

        KQueues kQueues = new KQueues(numQueues, arraySize);

        // Get the number of test cases
        System.out.print("Enter number of test cases: ");
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            System.out.println("\nTest Case " + (t + 1) + ":");
            System.out.print("Enter number of operations: ");
            int operations = scanner.nextInt();

            for (int op = 0; op < operations; op++) {
                System.out.print("Enter operation (1 for enqueue, 2 for dequeue): ");
                int operation = scanner.nextInt();
                if (operation == 1) {
                    System.out.print("Enter value to enqueue and queue index (0 to " + (numQueues - 1) + "): ");
                    int value = scanner.nextInt();
                    int queueIndex = scanner.nextInt();
                    kQueues.enqueue(value, queueIndex);
                } else if (operation == 2) {
                    System.out.print("Enter queue index to dequeue from (0 to " + (numQueues - 1) + "): ");
                    int queueIndex = scanner.nextInt();
                    int dequeuedValue = kQueues.dequeue(queueIndex);
                    if (dequeuedValue != -1) {
                        System.out.println("Dequeued value: " + dequeuedValue);
                    }
                } else {
                    System.out.println("Invalid operation.");
                }
            }
        }
        scanner.close();
    }
}
