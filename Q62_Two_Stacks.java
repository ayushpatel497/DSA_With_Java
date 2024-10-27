import java.util.Scanner;

public class Q62_Two_Stacks {
    
    private int[] arr; // Array to store elements of both stacks
    private int size; // Total size of the array
    private int top1; // Top index of stack1
    private int top2; // Top index of stack2

    // Initialize TwoStack with given size `s`
    public Q62_Two_Stacks(int s) {
        size = s;
        arr = new int[size];
        top1 = -1; // Stack 1 starts from the left end
        top2 = size; // Stack 2 starts from the right end
    }

    // Push in stack 1
    public void push1(int num) {
        if (top1 < top2 - 1) { // Check for overflow
            arr[++top1] = num;
        }
    }

    // Push in stack 2
    public void push2(int num) {
        if (top1 < top2 - 1) { // Check for overflow
            arr[--top2] = num;
        }
    }

    // Pop from stack 1 and return the popped element
    public int pop1() {
        if (top1 >= 0) {
            return arr[top1--];
        } else {
            return -1; // Underflow condition
        }
    }

    // Pop from stack 2 and return the popped element
    public int pop2() {
        if (top2 < size) {
            return arr[top2++];
        } else {
            return -1; // Underflow condition
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of test cases: ");
        int t = scanner.nextInt();

        while (t-- > 0) {
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();
            Q62_Two_Stacks twoStacks = new Q62_Two_Stacks(size);

            System.out.print("Enter number of operations: ");
            int n = scanner.nextInt();

            System.out.println("Enter operations (push1, push2, pop1, pop2) followed by numbers if applicable:");
            for (int i = 0; i < n; i++) {
                String operation = scanner.next();

                switch (operation) {
                    case "push1":
                        int num1 = scanner.nextInt();
                        twoStacks.push1(num1);
                        System.out.println("Pushed " + num1 + " to stack 1.");
                        break;

                    case "push2":
                        int num2 = scanner.nextInt();
                        twoStacks.push2(num2);
                        System.out.println("Pushed " + num2 + " to stack 2.");
                        break;

                    case "pop1":
                        int popped1 = twoStacks.pop1();
                        System.out.println("Popped from stack 1: " + popped1);
                        break;

                    case "pop2":
                        int popped2 = twoStacks.pop2();
                        System.out.println("Popped from stack 2: " + popped2);
                        break;

                    default:
                        System.out.println("Invalid operation");
                        break;
                }
            }
            System.out.println(); // Blank line after each test case for clarity
        }
        scanner.close();
    }
}
