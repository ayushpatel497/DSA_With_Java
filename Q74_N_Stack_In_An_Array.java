import java.util.Scanner;

public class Q74_N_Stack_In_An_Array {

    private int[] arr;      // Array to store elements of stacks
    private int[] top;      // Array to store the top of each stack
    private int[] next;     // Array to store the next index for free slots or links between elements of stacks
    private int free;       // Pointer to the next free slot in the array

    // Initialize your data structure.
    public Q74_N_Stack_In_An_Array(int N, int S) {
        arr = new int[S];
        top = new int[N];
        next = new int[S];
        
        // Initialize all stacks as empty
        for (int i = 0; i < N; i++) {
            top[i] = -1;
        }

        // Initialize the free list
        free = 0;
        for (int i = 0; i < S - 1; i++) {
            next[i] = i + 1;
        }
        next[S - 1] = -1;  // End of free list
    }

    // Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack, and false otherwise.
    public boolean push(int x, int m) {
        // Check for stack overflow
        if (free == -1) {
            return false; // No space left in the array
        }

        // Get the index for insertion from the free list
        int index = free;

        // Update free to the next available slot
        free = next[index];

        // Insert the element into the array
        arr[index] = x;

        // Update the next array to link the new element with the previous top of the stack
        next[index] = top[m - 1];

        // Update the top of the stack to point to the new index
        top[m - 1] = index;

        return true;
    }

    // Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise returns the popped element.
    public int pop(int m) {
        // Check if the stack is empty
        if (top[m - 1] == -1) {
            return -1;
        }

        // Get the index of the top element of the Mth stack
        int index = top[m - 1];

        // Update the top to the next element in the stack
        top[m - 1] = next[index];

        // Add this index to the free list
        next[index] = free;
        free = index;

        // Return the popped element
        return arr[index];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for test cases
        System.out.println("Enter the number of test cases:");
        int t = scanner.nextInt();

        while (t-- > 0) {
            System.out.println("Enter the number of stacks (N) and the size of array (S):");
            int N = scanner.nextInt();
            int S = scanner.nextInt();

            Q74_N_Stack_In_An_Array nStacks = new Q74_N_Stack_In_An_Array(N, S);

            System.out.println("Enter the number of operations:");
            int operations = scanner.nextInt();

            while (operations-- > 0) {
                System.out.println("Enter type of operation (1 for push, 2 for pop):");
                int type = scanner.nextInt();

                if (type == 1) {
                    System.out.println("Enter value to push and stack number:");
                    int x = scanner.nextInt();
                    int m = scanner.nextInt();
                    boolean success = nStacks.push(x, m);
                    System.out.println(success ? "Pushed " + x + " into stack " + m : "Push failed, stack " + m + " is full");
                } else if (type == 2) {
                    System.out.println("Enter stack number to pop from:");
                    int m = scanner.nextInt();
                    int result = nStacks.pop(m);
                    System.out.println(result != -1 ? "Popped " + result + " from stack " + m : "Pop failed, stack " + m + " is empty");
                } else {
                    System.out.println("Invalid operation type.");
                }
            }
        }

        scanner.close();
    }
}
