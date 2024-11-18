import java.util.*;

public class Q129_Merge_K_Sorted_Lists {

    // Definition of LinkedListNode
    static class LinkedListNode<T> {
        int data;
        LinkedListNode<T> next;

        public LinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to merge K sorted linked lists
    public static LinkedListNode<Integer> mergeKLists(LinkedListNode<Integer>[] listArray) {
        if (listArray == null || listArray.length == 0) return null;

        // Min-heap to store the nodes based on their values
        PriorityQueue<LinkedListNode<Integer>> minHeap = new PriorityQueue<>((a, b) -> a.data - b.data);

        // Add the head of each list to the heap
        for (LinkedListNode<Integer> head : listArray) {
            if (head != null) {
                minHeap.add(head);
            }
        }

        // Dummy node to act as the start of the merged list
        LinkedListNode<Integer> dummy = new LinkedListNode<>(0);
        LinkedListNode<Integer> current = dummy;

        // Merge lists
        while (!minHeap.isEmpty()) {
            LinkedListNode<Integer> smallestNode = minHeap.poll(); // Extract smallest node
            current.next = smallestNode; // Add it to the merged list
            current = current.next; // Move the pointer

            if (smallestNode.next != null) {
                minHeap.add(smallestNode.next); // Add the next node from the same list
            }
        }

        return dummy.next;
    }

    // Helper function to create linked lists dynamically from user input
    private static LinkedListNode<Integer>[] createDynamicTestCases(Scanner sc) {
        System.out.print("Enter the number of linked lists (K): ");
        int k = sc.nextInt();

        @SuppressWarnings("unchecked")
        LinkedListNode<Integer>[] listArray = new LinkedListNode[k];

        for (int i = 0; i < k; i++) {
            System.out.print("Enter the number of elements in list " + (i + 1) + ": ");
            int n = sc.nextInt();
            System.out.print("Enter the elements of list " + (i + 1) + " in sorted order: ");
            LinkedListNode<Integer> dummy = new LinkedListNode<>(0);
            LinkedListNode<Integer> current = dummy;

            for (int j = 0; j < n; j++) {
                int data = sc.nextInt();
                current.next = new LinkedListNode<>(data);
                current = current.next;
            }

            listArray[i] = dummy.next;
        }

        return listArray;
    }

    // Helper function to print the linked list
    private static void printList(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create dynamic test cases
        LinkedListNode<Integer>[] listArray = createDynamicTestCases(sc);

        // Merge all lists
        LinkedListNode<Integer> mergedHead = mergeKLists(listArray);

        // Print the merged list
        System.out.print("Merged Sorted List: ");
        printList(mergedHead);

        sc.close();
    }
}
