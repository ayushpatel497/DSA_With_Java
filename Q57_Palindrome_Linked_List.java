import java.util.Scanner;

/* Structure of class Node */
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Q57_Palindrome_Linked_List {

    // Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find the middle of the linked list
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        Node secondHalf = reverseList(slow);

        // Step 3: Compare the first half and the reversed second half
        Node firstHalf = head;
        Node temp = secondHalf;
        while (temp != null) {
            if (firstHalf.data != temp.data) {
                return false;  // Not a palindrome
            }
            firstHalf = firstHalf.next;
            temp = temp.next;
        }

        // Step 4 (optional): Restore the second half (reverse it back)
        reverseList(secondHalf);

        return true;  // It's a palindrome
    }

    // Function to reverse a linked list
    private Node reverseList(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;  // New head of the reversed list
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
        Q57_Palindrome_Linked_List obj = new Q57_Palindrome_Linked_List();

        // Input the number of test cases
        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            // Input the number of nodes in the linked list
            System.out.print("Enter number of nodes: ");
            int n = sc.nextInt();

            int[] values = new int[n];
            System.out.println("Enter the nodes' values: ");
            for (int i = 0; i < n; i++) {
                values[i] = sc.nextInt();
            }

            // Create the linked list
            Node head = createLinkedList(values);

            // Check if the linked list is a palindrome
            if (obj.isPalindrome(head)) {
                System.out.println("The linked list is a palindrome.");
            } else {
                System.out.println("The linked list is not a palindrome.");
            }
        }

        sc.close();
    }
}
