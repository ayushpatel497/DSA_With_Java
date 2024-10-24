import java.util.HashMap;
import java.util.Scanner;

/*
class Node {
    int data;
    Node next, random;

    Node(int d) {
        data = d;
        next = random = null;
    }
}
*/
class Node {
    int data;
    Node next, random;

    Node(int d) {
        data = d;
        next = random = null;
    }
}

public class Q59_Clone_A_Linked_List_With_Next_And_Random_Pointer {
    
    // Function to clone a linked list with next and random pointers
    Node copyList(Node head) {
        if (head == null) return null;

        // Step 1: Create new nodes and insert them between original nodes
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.data);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // Step 2: Assign random pointers to the newly created nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the cloned list from the original list
        curr = head;
        Node cloneHead = curr.next;
        Node temp = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = temp.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
            curr = curr.next;
        }

        // Return the head of the cloned list
        return cloneHead;
    }

    // Helper function to print a linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "(");
            System.out.print(temp.random != null ? temp.random.data : "null");
            System.out.print(") -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Function to take input and return head of the linked list
    public static Node createLinkedList(int[] arr, int[] randomIndexes) {
        if (arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node temp = head;
        HashMap<Integer, Node> nodeMap = new HashMap<>();
        nodeMap.put(0, head);

        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
            nodeMap.put(i, temp);
        }

        // Set the random pointers based on randomIndexes
        temp = head;
        for (int i = 0; i < arr.length; i++) {
            if (randomIndexes[i] != -1) {
                temp.random = nodeMap.get(randomIndexes[i]);
            }
            temp = temp.next;
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
            int[] randomIndexes = new int[n];

            // Take linked list data values
            System.out.println("Enter the linked list values:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            // Take the random pointers' indexes (-1 for null)
            System.out.println("Enter the random pointers' indexes (-1 for null):");
            for (int i = 0; i < n; i++) {
                randomIndexes[i] = scanner.nextInt();
            }

            // Create the linked list
            Node head = createLinkedList(arr, randomIndexes);

            // Clone the linked list
            Q59_Clone_A_Linked_List_With_Next_And_Random_Pointer solution = new Q59_Clone_A_Linked_List_With_Next_And_Random_Pointer();
            Node clonedHead = solution.copyList(head);

            // Print both original and cloned lists
            System.out.println("Original List:");
            printList(head);

            System.out.println("Cloned List:");
            printList(clonedHead);
        }

        scanner.close();
    }
}
