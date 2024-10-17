import java.util.Scanner;

/****************************************************************

Following is the class structure of the Node class:

class Node {
    public int data;
    public Node next;

    Node() {
        this.data = 0;
        this.next = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

*****************************************************************/

class Node {
    public int data;
    public Node next;

    // Default constructor
    Node() {
        this.data = 0;
        this.next = null;
    }

    // Constructor with data
    Node(int data) {
        this.data = data;
        this.next = null;
    }

    // Constructor with data and next node reference
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class Q49_Middle_Of_Linked_List {

    // Function to find the middle node of the linked list
    public static Node findMiddle(Node head) {
        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        // Move slow one step and fast two steps until fast reaches the end
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;  // slow will be pointing to the middle node
    }

    // Function to insert nodes into the linked list
    public static Node insertNode(Node head, int data) {
        if (head == null) {
            return new Node(data);
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node(data);
        return head;
    }

    // Function to print the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main function to take multiple test cases input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();  // Number of test cases

        for (int i = 0; i < t; i++) {
            System.out.print("Enter number of nodes for linked list: ");
            int n = sc.nextInt();  // Number of nodes in the current linked list
            Node head = null;

            System.out.println("Enter node values:");
            for (int j = 0; j < n; j++) {
                int value = sc.nextInt();
                head = insertNode(head, value);
            }

            System.out.print("Linked List: ");
            printList(head);

            Node middle = findMiddle(head);
            System.out.println("Middle of the Linked List: " + (middle != null ? middle.data : "No middle (empty list)"));
        }

        sc.close();
    }
}
