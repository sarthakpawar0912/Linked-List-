package LinkedList.Types;

public class CircularLinkedList {
    private Node head;  // Reference to the first node in the list
    private Node tail;  // Reference to the last node in the list

    // Constructor to initialize an empty circular linked list
    public CircularLinkedList() {
        this.head = null;  // Initially, the head is null (empty list)
        this.tail = null;  // Initially, the tail is null (empty list)
    }

    // Insert a new node with value `val` at the end of the list
    public void insert(int val) {
        Node node = new Node(val);  // Create a new node with the given value
        if (head == null) {         // If the list is empty
            head = node;            // Set the new node as the head
            tail = node;            // Set the new node as the tail
            node.next = head;       // Make it circular by pointing to itself
            return;                 // Exit the method
        }
        tail.next = node;           // Link the current tail to the new node
        node.next = head;           // Make the new node point to head (circular)
        tail = node;                // Update the tail to the new node
    }

    // Display the circular linked list
    public void display() {
        Node node = head;           // Start from the head
        if (head != null) {         // Check if the list is not empty
            do {
                System.out.print(node.val + " -> "); // Print the current node's value
                node = node.next;                    // Move to the next node
            } while (node != head);                  // Continue until we loop back to head
            System.out.println("HEAD");              // Indicate the circular connection
        } else {
            System.out.println("List is empty");     // Handle empty list case
        }
    }

    // Inner Node class representing each element in the list
    private class Node {
        int val;                // Value stored in the node
        Node next;              // Reference to the next node

        // Constructor to create a node with a value
        public Node(int val) {
            this.val = val;     // Initialize the value
            this.next = null;   // Initially, next is null
        }
    }


    public void delete(int val){
     Node node=head;
     if(node == null){
         return;
     }
     if(node.val==val){
         head=head.next;
         tail.next=head;
         return;
     }

     do {
         Node n= node.next;
         if(n.val==val){
             node.next=n.next;
             break;
         }
         node=node.next;
     }while (node !=head);
    }

}