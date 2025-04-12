package LinkedList.Types;

public class SignlyLinkedList {

    private Node head;    // Points to the first node in the list
    private Node tail;    // Points to the last node in the list for efficient end operations
    private int size;     // Tracks the number of nodes in the list

    // Constructor to initialize an empty list
    public SignlyLinkedList() {
        this.size = 0;    // Set size to 0 since the list starts empty
        this.head = null; // Initialize head as null (no nodes yet)
        this.tail = null; // Initialize tail as null (no nodes yet)
    }

    // Insert a node at the beginning of the list
    public void insertFirst(int val) {
        Node node = new Node(val); // Create a new node with the given value
        node.next = head;          // Link the new node to the current head
        head = node;               // Update head to point to the new node
        if (tail == null) {        // If the list was empty
            tail = head;           // Set tail to the new node (only one node exists)
        }
        size++;                    // Increment the size of the list
    }

    // Display the list from head to end
    public void display() {
        Node temp = head;          // Start from the head
        while (temp != null) {     // Traverse until the end (null)
            System.out.print(temp.value + " -> "); // Print the current node's value
            temp = temp.next;      // Move to the next node
        }
        System.out.println("END"); // Indicate the end of the list
    }


    // Insert a node at the end of the list
    public void insertLast(int val) {
        if (tail == null) {        // If the list is empty
            insertFirst(val);      // Use insertFirst to handle the first node
            return;                // Exit the method
        }
        Node node = new Node(val); // Create a new node with the given value
        tail.next = node;          // Link the current tail to the new node
        tail = node;               // Update tail to the new node
        size++;                    // Increment the size
    }

    // Insert a node at a specific index (0-based)
    public void insert(int val, int index) {
        if (index == 0) {          // If inserting at the beginning
            insertFirst(val);      // Use insertFirst
            return;                // Exit the method
        }
        if (index == size) {       // If inserting at the end
            insertLast(val);       // Use insertLast
            return;                // Exit the method
        }
        Node temp = head;          // Start from the head
        for (int i = 1; i < index; i++) { // Traverse to the node before the index
            temp = temp.next;      // Move to the next node
        }
        Node node = new Node(val, temp.next); // Create a new node pointing to temp's next
        temp.next = node;          // Link the previous node to the new node
        size++;                    // Increment the size
    }

    // Delete the last node and return its value
    public int deleteLast() {
        if (size <= 1) {           // If the list has 0 or 1 node
            return deleteFirst();  // Use deleteFirst to handle it
        }
        Node secondLast = get(size - 2); // Get the second-to-last node
        int val = tail.value;      // Store the tail's value to return
        tail = secondLast;         // Update tail to the second-to-last node
        tail.next = null;          // Disconnect the old tail
        size--;                    // Decrement the size
        return val;                // Return the deleted value
    }

    // Find a node with a specific value
    public Node find(int value) {
        Node node = head;          // Start from the head
        while (node != null) {     // Traverse the list
            if (node.value == value) { // If the value matches
                return node;       // Return the node
            }
            node = node.next;      // Move to the next node
        }
        return null;               // Return null if not found
    }

    // Get the node at a specific index (0-based)
    public Node get(int index) {
        Node node = head;          // Start from the head
        for (int i = 0; i < index; i++) { // Traverse to the desired index
            node = node.next;      // Move to the next node
        }
        return node;               // Return the node at the index
    }

    // Delete the first node and return its value
    public int deleteFirst() {
        int val = head.value;      // Store the head's value to return
        head = head.next;          // Move head to the next node
        if (head == null) {        // If the list is now empty
            tail = null;           // Update tail to null
        }
        size--;                    // Decrement the size
        return val;                // Return the deleted value
    }

    // Delete a node at a specific index and return its value
    public int delete(int index) {
        if (index == 0) {          // If deleting the first node
            return deleteFirst();  // Use deleteFirst
        }
        if (index == size - 1) {   // If deleting the last node
            return deleteLast();   // Use deleteLast
        }
        Node prev = get(index - 1); // Get the node before the one to delete
        int val = prev.next.value;  // Store the value of the node to delete
        prev.next = prev.next.next; // Bypass the node being deleted
        size--;                    // Decrement the size
        return val;                // Return the deleted value
    }

    // Public method to insert a node recursively at a specific index
    public void insertRec(int val, int index) {
        head = insertRec(val, index, head); // Start recursion from head and update head
        if (index == size - 1) {            // If inserted at the end
            tail = get(size - 1);           // Update tail to the new last node
        }
    }

    // Private recursive method to insert a node
    private Node insertRec(int val, int index, Node node) {
        if (index == 0) {                   // Base case: reached the insertion point
            Node temp = new Node(val, node); // Create a new node linking to the current node
            size++;                         // Increment the size
            return temp;                    // Return the new node as the new head of this segment
        }
        node.next = insertRec(val, index - 1, node.next); // Recursively move to the next node
        return node;                        // Return the current node after linking
    }

    // Inner class representing a node in the list
    private class Node {
        private int value;              // Value stored in the node
        private Node next;              // Reference to the next node

        // Constructor for a node with only a value
        public Node(int value) {
            this.value = value;         // Initialize the value
            this.next = null;           // Next is null by default
        }

        // Constructor for a node with a value and next reference
        public Node(int value, Node next) {
            this.value = value;         // Initialize the value
            this.next = next;           // Set the next reference
        }
    }


}