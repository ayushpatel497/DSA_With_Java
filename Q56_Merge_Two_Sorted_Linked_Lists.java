import java.util.*;

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

public class Q56_Merge_Two_Sorted_Linked_Lists {

    // Node structure for the linked list
    static class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to merge two sorted linked lists
    public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
        // If either of the lists is empty, return the other
        if (first == null) return second;
        if (second == null) return first;

        // Pointer for the result list
        LinkedListNode<Integer> mergedHead;

        // Initialize the mergedHead with the smaller value
        if (first.data <= second.data) {
            mergedHead = first;
            first = first.next;
        } else {
            mergedHead = second;
            second = second.next;
        }

        // Pointer to build the merged list
        LinkedListNode<Integer> current = mergedHead;

        // Traverse through both lists and merge them in sorted order
        while (first != null && second != null) {
            if (first.data <= second.data) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }

        // Append the remaining nodes from the non-empty list
        if (first != null) {
            current.next = first;
        } else {
            current.next = second;
        }

        return mergedHead;
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

    // Helper function to print a linked list
    public static void printLinkedList(LinkedListNode<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {
            // First sorted linked list
            System.out.print("Enter the number of nodes for the first list: ");
            int n1 = sc.nextInt();
            int[] arr1 = new int[n1];
            System.out.print("Enter the elements of the first list: ");
            for (int i = 0; i < n1; i++) {
                arr1[i] = sc.nextInt();
            }
            LinkedListNode<Integer> first = createLinkedList(arr1);

            // Second sorted linked list
            System.out.print("Enter the number of nodes for the second list: ");
            int n2 = sc.nextInt();
            int[] arr2 = new int[n2];
            System.out.print("Enter the elements of the second list: ");
            for (int i = 0; i < n2; i++) {
                arr2[i] = sc.nextInt();
            }
            LinkedListNode<Integer> second = createLinkedList(arr2);

            // Merging the two sorted lists
            LinkedListNode<Integer> mergedList = sortTwoLists(first, second);

            // Print the merged linked list
            System.out.print("Merged Linked List: ");
            printLinkedList(mergedList);
        }

        sc.close();
    }
}
