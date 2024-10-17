import java.util.Scanner;

/*
	Following is the structure of the Singly Linked List.	
	class LinkedListNode<T> 
    {
    	T data;
    	LinkedListNode<T> next;
    	public LinkedListNode(T data) 
        {
        	this.data = data;
    	}
	}
*/

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;
    
    // Constructor to initialize the node with data
    public LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }
}

public class Q48_Reverse_Linked_List {
    
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) {
        // If the linked list is empty or has only one node, return head as it is
        if (head == null || head.next == null) {
            return head;
        }
        
        // Initialize three pointers to reverse the list
        LinkedListNode<Integer> prev = null; // To store the previous node
        LinkedListNode<Integer> current = head; // Current node starting from the head
        LinkedListNode<Integer> next = null; // To store the next node temporarily
        
        while (current != null) {
            next = current.next; // Store the next node
            current.next = prev; // Reverse the link (current node's next points to previous node)
            prev = current; // Move prev one step ahead to current
            current = next; // Move current one step ahead to next node
        }
        
        // After the loop, prev will be the new head of the reversed list
        return prev;
    }

    // Main method to take input and test the reverseLinkedList function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of elements in the linked list
        System.out.print("Enter number of elements in the linked list: ");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("Empty Linked List");
        }

        // Create the linked list from user input
        System.out.println("Enter the elements of the linked list:");
        LinkedListNode<Integer> head = new LinkedListNode<>(sc.nextInt());
        LinkedListNode<Integer> temp = head;
        for (int i = 1; i < n; i++) {
            temp.next = new LinkedListNode<>(sc.nextInt());
            temp = temp.next;
        }

        // Reverse the linked list
        head = reverseLinkedList(head);

        // Print the reversed linked list
        System.out.println("Reversed Linked List:");
        temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        sc.close();
    }
}
