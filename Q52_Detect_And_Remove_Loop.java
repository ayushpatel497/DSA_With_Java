import java.util.Scanner;

/*****************************************************
  
  Following is the structure of Node.
  public static class Node {
    
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

*****************************************************/

public class Q52_Detect_And_Remove_Loop {

    // Node class
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to detect and remove the loop
    public static Node removeLoop(Node head) {
        if (head == null || head.next == null) return head;

        Node slow = head, fast = head;
        
        // Detect loop using Floyd's Cycle Detection
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // Loop detected
                break;
            }
        }

        if (slow == fast) { // There is a loop
            slow = head;
            if (slow == fast) { // If loop is at the head
                while (fast.next != slow) {
                    fast = fast.next;
                }
            } else {
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
            }
            fast.next = null; // Break the loop
        }
        return head;
    }

    // Helper function to print the list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Helper function to create a linked list with a loop
    public static Node createLinkedListWithLoop(int[] arr, int pos) {
        Node head = new Node(arr[0]);
        Node temp = head;
        Node loopNode = null;

        if (pos == 0) loopNode = head;

        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
            if (i == pos) loopNode = temp;
        }

        if (loopNode != null) {
            temp.next = loopNode;
        }

        return head;
    }

    // Main function to take multiple test cases
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

            System.out.print("Enter the position to create a loop (-1 for no loop): ");
            int pos = sc.nextInt();

            Node head = createLinkedListWithLoop(arr, pos);

            // Removing the loop from the linked list
            head = removeLoop(head);

            // Printing the updated list after removing the loop
            System.out.print("Updated Linked List: ");
            printList(head);
        }

        sc.close();
    }
}
