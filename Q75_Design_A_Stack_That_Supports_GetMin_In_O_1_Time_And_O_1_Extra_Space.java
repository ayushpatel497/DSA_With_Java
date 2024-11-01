import java.util.Scanner;
import java.util.Stack;

public class Q75_Design_A_Stack_That_Supports_GetMin_In_O_1_Time_And_O_1_Extra_Space {
    static class SpecialStack {
        Stack<Integer> stack = new Stack<>();
        int minElement;

        // Push an element onto the stack
        void push(int data) {
            if (stack.isEmpty()) {
                stack.push(data);
                minElement = data;
            } else if (data < minElement) {
                // Transform value for new minimum
                stack.push(2 * data - minElement);
                minElement = data;
            } else {
                stack.push(data);
            }
        }

        // Pop an element from the stack
        void pop() {
            if (stack.isEmpty()) {
                System.out.println("Stack is empty");
                return;
            }

            int top = stack.pop();
            if (top < minElement) {
                // Retrieve the previous minimum
                minElement = 2 * minElement - top;
            }
        }

        // Get the top element of the stack
        int top() {
            if (stack.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }

            int top = stack.peek();
            return (top < minElement) ? minElement : top;
        }

        // Get the minimum element in the stack
        int getMin() {
            if (stack.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return minElement;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SpecialStack specialStack = new SpecialStack();

        System.out.println("Enter the number of queries:");
        int q = scanner.nextInt();

        while (q-- > 0) {
            System.out.println("Enter query type (1: push, 2: pop, 3: top, 4: getMin):");
            int queryType = scanner.nextInt();

            switch (queryType) {
                case 1: // push
                    System.out.println("Enter value to push:");
                    int value = scanner.nextInt();
                    specialStack.push(value);
                    System.out.println("Pushed " + value);
                    break;

                case 2: // pop
                    specialStack.pop();
                    System.out.println("Popped top element.");
                    break;

                case 3: // top
                    int topValue = specialStack.top();
                    if (topValue != -1) System.out.println("Top element is: " + topValue);
                    break;

                case 4: // getMin
                    int minValue = specialStack.getMin();
                    if (minValue != -1) System.out.println("Minimum element is: " + minValue);
                    break;

                default:
                    System.out.println("Invalid query type.");
            }
        }

        scanner.close();
    }
}
