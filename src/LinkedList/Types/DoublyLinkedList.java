package LinkedList.Types;

public class DoublyLinkedList {
    Node head; // The starting point of the list, initially null

    // Insert a new node with value `val` at the beginning of the list
    public void insertFirst(int val) {
        Node node = new Node(val); // Create a new node with the given value
        node.next = head;         // Point the new node's next to the current head
        node.prev = null;         // Since it's the first node, its previous is null
        if (head != null) {       // If the list isn't empty
            head.prev = node;     // Update the old head's previous to point to the new node
        }
        head = node;              // Make the new node the new head
    }

    // Display the list forward and backward
    public void display() {
        Node node = head;         // Start from the head
        Node last = null;         // To track the last node for reverse printing
        System.out.print("Forward: ");
        while (node != null) {    // Traverse until the end of the list
            System.out.print(node.val + " -> "); // Print current node's value
            last = node;          // Keep track of the last node
            node = node.next;     // Move to the next node
        }
        System.out.println("END"); // Indicate the end of forward traversal

        System.out.print("Reverse: ");
        while (last != null) {    // Traverse backward from the last node
            System.out.print(last.val + " -> "); // Print current node's value
            last = last.prev;     // Move to the previous node
        }
        System.out.println("START"); // Indicate the start of the list in reverse
    }

    // Find the first node with the given value
    public Node find(int value) {
        Node node = head;         // Start from the head
        while (node != null) {    // Traverse the list
            if (node.val == value) { // If the current node's value matches
                return node;      // Return the node
            }
            node = node.next;     // Move to the next node
        }
        return null;              // Return null if value not found
    }

    // Insert a new node with value `val` at the end of the list
    public void insertLast(int val) {
        Node node = new Node(val); // Create a new node with the given value
        node.next = null;         // Since it's the last node, its next is null
        if (head == null) {       // If the list is empty
            node.prev = null;     // Its previous is null
            head = node;          // Make it the head
            return;               // Exit the method
        }
        Node last = head;         // Start from the head to find the last node
        while (last.next != null) { // Traverse to the end
            last = last.next;     // Move to the next node
        }
        last.next = node;         // Link the last node to the new node
        node.prev = last;         // Set the new node's previous to the old last node
    }

    // Insert a new node with value `val` after the first occurrence of `after`
    public void insert(int after, int val) {
        Node p = find(after);     // Find the node with value `after`
        if (p == null) {          // If the node doesn't exist
            System.out.println("Node with value " + after + " does not exist");
            return;               // Exit the method
        }
        Node node = new Node(val); // Create a new node with the given value
        node.next = p.next;       // Link new node's next to p's next
        node.prev = p;            // Link new node's prev to p
        p.next = node;            // Update p's next to point to the new node
        if (node.next != null) {  // If the new node isn't the last node
            node.next.prev = node; // Update the next node's prev to point to the new node
        }
    }

    // Inner Node class representing each element in the list
    private class Node {
        int val;                  // Value stored in the node
        Node next;                // Reference to the next node
        Node prev;                // Reference to the previous node

        public Node(int val) {    // Constructor for creating a node with a value
            this.val = val;       // Initialize the value
        }

        public Node(int val, Node next, Node prev) { // Constructor with all fields
            this.val = val;       // Initialize the value
            this.next = next;     // Initialize the next pointer
            this.prev = prev;     // Initialize the previous pointer
        }
    }
}