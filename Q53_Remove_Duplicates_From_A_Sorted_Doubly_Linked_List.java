import java.util.Scanner;

/********************************************************

    Following is the class structure of the Node class:
    
    class Node
    {
        public:
            int data;
            Node next;
            Node(int data)
            {
                this.data = data;
                this.next = null;
            }
    };

********************************************************/

public class Q53_Remove_Duplicates_From_A_Sorted_Doubly_Linked_List {
    
    // Node class representing a singly linked list node
    public static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to remove duplicates from a sorted singly linked list
    public static Node uniqueSortedList(Node head) {
        if (head == null) return null;

        Node current = head;

        // Traverse through the list
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                // Duplicate found, remove the next node
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
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

    // Helper function to create a singly linked list from array
    public static Node createLinkedList(int[] arr) {
        if (arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node temp = head;

        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = temp.next;
        }

        return head;
    }

    // Main function to handle multiple test cases
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            System.out.print("Enter the number of nodes: ");
            int n = sc.nextInt();
            int[] arr = new int[n];

            System.out.print("Enter the node values (sorted): ");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Creating the singly linked list
            Node head = createLinkedList(arr);

            // Removing duplicates
            head = uniqueSortedList(head);

            // Printing the updated list
            System.out.print("Updated Linked List: ");
            printList(head);
        }

        sc.close();
    }
}
