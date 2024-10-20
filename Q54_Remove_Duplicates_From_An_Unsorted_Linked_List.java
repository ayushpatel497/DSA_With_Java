import java.util.HashSet;
import java.util.Scanner;

/************************************************************

    Following is the linked list node structure:
    
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

************************************************************/

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }
}

public class Q54_Remove_Duplicates_From_An_Unsorted_Linked_List {

    // Function to remove duplicates from an unsorted linked list
    public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
        if (head == null) return null;

        // Create a set to store seen elements
        HashSet<Integer> seen = new HashSet<>();
        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> prev = null;

        while (current != null) {
            // If we have already seen the current element
            if (seen.contains(current.data)) {
                // Remove current node
                prev.next = current.next;
            } else {
                // Add data to the set and move the previous pointer
                seen.add(current.data);
                prev = current;
            }
            // Move to the next node
            current = current.next;
        }
        return head;
    }

    // Helper function to print the linked list
    public static void printList(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Helper function to create a linked list from an array
    public static LinkedListNode<Integer> createLinkedList(int[] arr) {
        if (arr.length == 0) return null;

        LinkedListNode<Integer> head = new LinkedListNode<>(arr[0]);
        LinkedListNode<Integer> temp = head;

        for (int i = 1; i < arr.length; i++) {
            LinkedListNode<Integer> newNode = new LinkedListNode<>(arr[i]);
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

            System.out.print("Enter the node values: ");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Creating the linked list
            LinkedListNode<Integer> head = createLinkedList(arr);

            // Removing duplicates
            head = removeDuplicates(head);

            // Printing the updated list
            System.out.print("Updated Linked List: ");
            printList(head);
        }

        sc.close();
    }
}
