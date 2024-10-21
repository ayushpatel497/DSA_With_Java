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

 import java.util.Scanner;

 public class Q55_Sort_Linked_List_Of_0s_1s_2s {
 
     // Definition of the Node class
     static class Node {
         int data;
         Node next;
 
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
 
     // Function to sort the linked list of 0s, 1s, and 2s
     public static Node sortList(Node head) {
         if (head == null) return null;
 
         // Count the number of 0s, 1s, and 2s
         int count0 = 0, count1 = 0;
         Node temp = head;
 
         // Count the occurrences of 0, 1, and 2
         while (temp != null) {
             if (temp.data == 0) count0++;
             else if (temp.data == 1) count1++;
             else continue;
             temp = temp.next;
         }
 
         // Update the linked list based on the counts
         temp = head;
         while (temp != null) {
             if (count0 > 0) {
                 temp.data = 0;
                 count0--;
             } else if (count1 > 0) {
                 temp.data = 1;
                 count1--;
             } else {
                 temp.data = 2;
             }
             temp = temp.next;
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
 
     // Helper function to create a linked list from an array
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
 
     // Main function to take input for multiple test cases
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.print("Enter the number of test cases: ");
         int t = sc.nextInt();
 
         while (t-- > 0) {
             System.out.print("Enter the number of nodes: ");
             int n = sc.nextInt();
             int[] arr = new int[n];
 
             System.out.print("Enter the node values (0s, 1s, and 2s): ");
             for (int i = 0; i < n; i++) {
                 arr[i] = sc.nextInt();
             }
 
             // Creating the linked list
             Node head = createLinkedList(arr);
 
             // Sorting the list of 0s, 1s, and 2s
             head = sortList(head);
 
             // Printing the sorted list
             System.out.print("Sorted Linked List: ");
             printList(head);
         }
 
         sc.close();
     }
 }
 