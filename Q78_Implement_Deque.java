import java.util.Scanner;

public class Q78_Implement_Deque {
    private int[] deque;
    private int front, rear, size, capacity;

    // Initialize the deque with given capacity `n`
    public Q78_Implement_Deque(int n) {
        deque = new int[n];
        front = -1;
        rear = -1;
        size = 0;
        capacity = n;
    }

    // Pushes 'x' in the front of the deque
    public boolean pushFront(int x) {
        if (isFull()) {
            return false; // Deque is full
        }
        if (front == -1) { // First element addition
            front = rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity;
        }
        deque[front] = x;
        size++;
        return true;
    }

    // Pushes 'x' in the back of the deque
    public boolean pushRear(int x) {
        if (isFull()) {
            return false; // Deque is full
        }
        if (rear == -1) { // First element addition
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        deque[rear] = x;
        size++;
        return true;
    }

    // Pops an element from the front of the deque
    public int popFront() {
        if (isEmpty()) {
            return -1; // Deque is empty
        }
        int removed = deque[front];
        front = (front + 1) % capacity;
        size--;
        if (size == 0) { // Reset deque when empty
            front = -1;
            rear = -1;
        }
        return removed;
    }

    // Pops an element from the back of the deque
    public int popRear() {
        if (isEmpty()) {
            return -1; // Deque is empty
        }
        int removed = deque[rear];
        rear = (rear - 1 + capacity) % capacity;
        size--;
        if (size == 0) { // Reset deque when empty
            front = -1;
            rear = -1;
        }
        return removed;
    }

    // Returns the front element
    public int getFront() {
        return isEmpty() ? -1 : deque[front];
    }

    // Returns the rear element
    public int getRear() {
        return isEmpty() ? -1 : deque[rear];
    }

    // Checks if deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Checks if deque is full
    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the capacity of the deque: ");
        int n = scanner.nextInt();
        Q78_Implement_Deque deque = new Q78_Implement_Deque(n);

        System.out.print("Enter number of operations: ");
        int t = scanner.nextInt();

        // Test case handling
        for (int i = 0; i < t; i++) {
            System.out.println("\nChoose operation: ");
            System.out.println("1: pushFront, 2: pushRear, 3: popFront, 4: popRear, 5: getFront, 6: getRear, 7: isEmpty, 8: isFull");
            int operation = scanner.nextInt();

            switch (operation) {
                case 1: // pushFront
                    System.out.print("Enter value to push at front: ");
                    int x1 = scanner.nextInt();
                    System.out.println(deque.pushFront(x1) ? "Pushed " + x1 + " at front" : "Deque is full. Cannot push at front.");
                    break;

                case 2: // pushRear
                    System.out.print("Enter value to push at rear: ");
                    int x2 = scanner.nextInt();
                    System.out.println(deque.pushRear(x2) ? "Pushed " + x2 + " at rear" : "Deque is full. Cannot push at rear.");
                    break;

                case 3: // popFront
                    int removedFront = deque.popFront();
                    System.out.println(removedFront == -1 ? "Deque is empty. Cannot pop from front." : "Popped from front: " + removedFront);
                    break;

                case 4: // popRear
                    int removedRear = deque.popRear();
                    System.out.println(removedRear == -1 ? "Deque is empty. Cannot pop from rear." : "Popped from rear: " + removedRear);
                    break;

                case 5: // getFront
                    int front = deque.getFront();
                    System.out.println(front == -1 ? "Deque is empty. No front element." : "Front element: " + front);
                    break;

                case 6: // getRear
                    int rear = deque.getRear();
                    System.out.println(rear == -1 ? "Deque is empty. No rear element." : "Rear element: " + rear);
                    break;

                case 7: // isEmpty
                    System.out.println(deque.isEmpty() ? "Deque is empty." : "Deque is not empty.");
                    break;

                case 8: // isFull
                    System.out.println(deque.isFull() ? "Deque is full." : "Deque is not full.");
                    break;

                default:
                    System.out.println("Invalid operation.");
                    break;
            }
        }
        scanner.close();
    }
}
