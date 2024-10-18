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
 };

 *****************************************************************/

 import java.util.Scanner;

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
 
 public class Q51_Circularly_Linked {
 
     public static boolean isCircular(Node head) {
         // Case 1: An empty list is circular by definition
         if (head == null) {
             return true;
         }
 
         // Use two pointers (slow and fast pointer technique)
         Node slow = head;
         Node fast = head;
 
         // Traverse the linked list with slow and fast pointers
         while (fast != null && fast.next != null) {
             slow = slow.next;           // move slow pointer by 1 step
             fast = fast.next.next;      // move fast pointer by 2 steps
 
             // If slow and fast pointers meet, it means there's a cycle
             if (slow == fast) {
                 return true;
             }
         }
 
         // If we reach a null, it means the list is not circular
         return false;
     }
 
     // Helper method to create a non-circular linked list
     public static Node createNonCircularList(int[] data) {
         if (data.length == 0) {
             return null;
         }
 
         Node head = new Node(data[0]);
         Node temp = head;
         for (int i = 1; i < data.length; i++) {
             temp.next = new Node(data[i]);
             temp = temp.next;
         }
 
         return head;
     }
 
     // Helper method to create a circular linked list
     public static Node createCircularList(int[] data) {
         if (data.length == 0) {
             return null;
         }
 
         Node head = new Node(data[0]);
         Node temp = head;
         for (int i = 1; i < data.length; i++) {
             temp.next = new Node(data[i]);
             temp = temp.next;
         }
         // Make the list circular
         temp.next = head;
 
         return head;
     }
 
     // Main method for testing multiple test cases
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
 
         System.out.print("Enter number of test cases: ");
         int testCases = sc.nextInt();  // Number of test cases
 
         while (testCases-- > 0) {
             System.out.print("Enter number of elements in the linked list: ");
             int n = sc.nextInt();  // Size of the list
 
             int[] data = new int[n];
             System.out.println("Enter elements of the linked list:");
             for (int i = 0; i < n; i++) {
                 data[i] = sc.nextInt();
             }
 
             System.out.print("Is the linked list circular (y/n): ");
             char circular = sc.next().charAt(0);
 
             Node head;
             if (circular == 'y') {
                 head = createCircularList(data);
             } else {
                 head = createNonCircularList(data);
             }
 
             System.out.println("Is Circular: " + isCircular(head));
         }
 
         sc.close();
     }
 }
 