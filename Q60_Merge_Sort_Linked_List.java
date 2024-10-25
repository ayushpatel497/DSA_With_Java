import java.util.Scanner;

/********************************************************************

    Following is the representation of the Singly Linked List Node:

    class Node<T> {
        T data;
        Node<T> next;
        
        public Node(T data) {
            this.data = data;
        }
    }

********************************************************************/

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}

public class Q60_Merge_Sort_Linked_List {

    public static Node<Integer> mergeSort(Node<Integer> head) {
        // Base case: if head is null or only one node, return head
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Split the linked list into two halves
        Node<Integer> mid = findMiddle(head);
        Node<Integer> secondHalf = mid.next;
        mid.next = null;

        // Step 2: Recursively sort both halves
        Node<Integer> left = mergeSort(head);
        Node<Integer> right = mergeSort(secondHalf);

        // Step 3: Merge the sorted halves
        return merge(left, right);
    }

    // Helper function to find the middle of the linked list
    private static Node<Integer> findMiddle(Node<Integer> head) {
        Node<Integer> slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper function to merge two sorted linked lists
    private static Node<Integer> merge(Node<Integer> left, Node<Integer> right) {
        Node<Integer> dummy = new Node<>(0);
        Node<Integer> tail = dummy;

        while (left != null && right != null) {
            if (left.data <= right.data) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        // Attach remaining nodes if any
        if (left != null) tail.next = left;
        if (right != null) tail.next = right;

        return dummy.next;
    }

    // Function to print linked list
    public static void printList(Node<Integer> head) {
        Node<Integer> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Function to create a linked list from an array
    public static Node<Integer> createLinkedList(int[] arr) {
        Node<Integer> head = new Node<>(arr[0]);
        Node<Integer> tail = head;
        for (int i = 1; i < arr.length; i++) {
            tail.next = new Node<>(arr[i]);
            tail = tail.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take number of test cases
        System.out.println("Enter number of test cases:");
        int t = scanner.nextInt();

        while (t-- > 0) {
            // Take the size of the linked list
            System.out.println("Enter the size of the linked list:");
            int n = scanner.nextInt();

            int[] arr = new int[n];
            System.out.println("Enter the elements of the linked list:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            // Create linked list
            Node<Integer> head = createLinkedList(arr);

            // Apply merge sort
            head = mergeSort(head);

            // Print sorted linked list
            System.out.println("Sorted Linked List:");
            printList(head);
        }

        scanner.close();
    }
}
