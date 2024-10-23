import java.util.Scanner;

/* Node class for Linked List

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Q58_Add_Number_Linked_Lists {

    // Function to add two numbers represented by linked lists.
    static Node addTwoLists(Node num1, Node num2) {
        // Reverse the input lists to start addition from the least significant digits
        num1 = reverseList(num1);
        num2 = reverseList(num2);

        Node sumHead = null;
        Node temp = null;
        int carry = 0;

        // Add the digits and handle the carry
        while (num1 != null || num2 != null || carry != 0) {
            int sum = carry;

            if (num1 != null) {
                sum += num1.data;
                num1 = num1.next;
            }

            if (num2 != null) {
                sum += num2.data;
                num2 = num2.next;
            }

            carry = sum / 10;
            sum = sum % 10;

            Node newNode = new Node(sum);
            if (sumHead == null) {
                sumHead = newNode;
            } else {
                temp.next = newNode;
            }
            temp = newNode;
        }

        // Reverse the sum list back to the correct order
        return reverseList(sumHead);
    }

    // Function to reverse a linked list
    static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    // Helper function to create linked list from an array of values
    public static Node createLinkedList(int[] values) {
        if (values.length == 0) return null;

        Node head = new Node(values[0]);
        Node current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }

        return head;
    }

    // Helper function to print a linked list
    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main function to handle multiple test cases
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the number of test cases
        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            // Input the first number as a linked list
            System.out.print("Enter number of digits in first number: ");
            int n1 = sc.nextInt();
            int[] num1Array = new int[n1];
            System.out.println("Enter the digits of first number: ");
            for (int i = 0; i < n1; i++) {
                num1Array[i] = sc.nextInt();
            }

            // Input the second number as a linked list
            System.out.print("Enter number of digits in second number: ");
            int n2 = sc.nextInt();
            int[] num2Array = new int[n2];
            System.out.println("Enter the digits of second number: ");
            for (int i = 0; i < n2; i++) {
                num2Array[i] = sc.nextInt();
            }

            // Create linked lists for the two numbers
            Node num1 = createLinkedList(num1Array);
            Node num2 = createLinkedList(num2Array);

            // Add the two linked lists
            Node sumList = addTwoLists(num1, num2);

            // Output the result
            System.out.print("Sum of numbers: ");
            printLinkedList(sumList);
        }

        sc.close();
    }
}
