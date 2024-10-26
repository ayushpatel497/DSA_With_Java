import java.util.PriorityQueue;
import java.util.Scanner;

/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node child;

     Node() {
         this.data = 0;
         this.next = null;
         this.child = null;
     }

     Node(int data) {
         this.data = data;
         this.next = null;
         this.child = null;
     }

     Node(int data, Node next, Node child) {
         this.data = data;
         this.next = next;
         this.child = child;
     }
 }

 *****************************************************************/

class Node {
    public int data;
    public Node next;
    public Node child;

    Node() {
        this.data = 0;
        this.next = null;
        this.child = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
        this.child = null;
    }

    Node(int data, Node next, Node child) {
        this.data = data;
        this.next = next;
        this.child = child;
    }
}

public class Q61_Flatten_A_Linked_List {

    public static Node flattenLinkedList(Node head) {
        // Pointer for iterating through the main list
        Node pointer = head;
        Node result = null;

        // Min-heap (priority queue) to store nodes in sorted order by their `data` values.
        // Using a lambda for custom comparator to compare nodes based on their `data` field.
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.data, b.data));

        // Add all the main list nodes to the heap
        while (pointer != null) {
            pq.add(pointer);  // Add each node in the main list to the heap
            pointer = pointer.next;  // Move to the next node in the main list
        }

        // Process the min-heap until it’s empty, building the flattened list in sorted order
        while (!pq.isEmpty()) {
            // Remove the node with the smallest value from the heap
            Node temp = pq.poll();

            // If `temp` has a child list, add the head of that list to the heap
            if (temp.child != null) {
                pq.add(temp.child);
            }

            // Initialize result list if this is the first node
            if (result == null) {
                result = temp;  // Set `result` as the head of the flattened list
                pointer = temp;  // Set `pointer` to track the current end of the flattened list
                pointer.next = null;  // Clear `next` pointer for flattened structure
            } else {
                // Attach the `temp` node to the flattened list
                pointer.child = temp;  // Append `temp` as `child` to maintain the flattened list
                pointer = temp;  // Move pointer to the end of the flattened list
                pointer.next = null;  // Clear `next` pointer for flattened structure
            }
        }

        return result;
    }

    // Function to print the flattened linked list in sequence
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.child;  // Move to the next node in the flattened structure (following `child`)
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input the number of test cases
        System.out.println("Enter number of test cases:");
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            System.out.println("Enter the number of nodes in the main list:");
            int n = scanner.nextInt();
            
            Node head = null, current = null;
            
            // Input the main list nodes and their child nodes
            System.out.println("Enter the main list nodes and their child nodes (use -1 for no child):");
            for (int i = 0; i < n; i++) {
                int data = scanner.nextInt();
                int childData = scanner.nextInt();

                // Create a new node for the main list
                Node newNode = new Node(data);
                if (head == null) {
                    head = newNode;  // Set head if it’s the first node
                } else {
                    current.next = newNode;  // Link the current node to the new node
                }
                current = newNode;  // Move current pointer to the new node

                // Add child nodes if they exist
                if (childData != -1) {
                    newNode.child = new Node(childData);
                    Node child = newNode.child;

                    System.out.println("Enter additional child nodes for node with data " + childData + " (use -1 to end):");
                    while ((childData = scanner.nextInt()) != -1) {
                        child.next = new Node(childData);
                        child = child.next;
                    }
                }
            }

            // Flatten the list and store the head of the flattened list
            Node flattenedHead = flattenLinkedList(head);

            // Print the flattened list
            System.out.println("Flattened sorted list:");
            printList(flattenedHead);
        }

        scanner.close();
    }
}
