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

public class Q50_Reverse_List_In_K_Groups {

    // Function to reverse nodes in k-group
    public static Node kReverse(Node head, int k) {
        // Base case: if head is null or k is 1, no need to reverse
        if (head == null || k == 1) {
            return head;
        }

        // Initialize pointers
        Node dummy = new Node(0);
        dummy.next = head;
        Node current = dummy, prev = dummy, next = dummy;

        // Count the total number of nodes in the list
        int count = 0;
        while (current.next != null) {
            current = current.next;
            count++;
        }

        // Loop over the list, reversing every group of k nodes
        while (count >= k) {
            current = prev.next;
            next = current.next;
            for (int i = 1; i < k; i++) {
                current.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = current.next;
            }
            prev = current;
            count -= k;
        }

        return dummy.next; // Returning the new head of the list
    }

    // Helper function to print the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Helper function to insert a node at the end
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

    // Main function to take multiple test cases input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.print("Enter the number of nodes for the linked list: ");
            int n = sc.nextInt();

            System.out.print("Enter the value of k: ");
            int k = sc.nextInt();

            Node head = null;
            System.out.println("Enter node values:");
            for (int j = 0; j < n; j++) {
                int value = sc.nextInt();
                head = insertNode(head, value);
            }

            System.out.print("Original List: ");
            printList(head);

            head = kReverse(head, k);

            System.out.print("Reversed List in groups of " + k + ": ");
            printList(head);
        }

        sc.close();
    }
}
