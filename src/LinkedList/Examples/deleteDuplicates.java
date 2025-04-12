package LinkedList.Examples;

public class deleteDuplicates {

    private Node head;    // Points to the first node in the list
    private Node tail;    // Points to the last node in the list
    private int size;     // Tracks the number of nodes in the list

    // Constructor to initialize an empty list
    public deleteDuplicates() {
        this.size = 0;    // Initialize size to 0 (empty list)
        this.head = null; // Initialize head to null (no nodes)
        this.tail = null; // Initialize tail to null (no nodes)
    }


    // Insert a node at the beginning of the list
    public void insertFirst(int val) {
        Node node = new Node(val);           // Create a new node with the given value
        node.next = head;                    // Link new node to current head
        head = node;                         // Update head to new node
        if (tail == null) {                  // If list was empty
            tail = head;                     // Set tail to new node (single node case)
        }
        size++;                              // Increment size
    }

    // Display the list from head to end
    public void display() {
        Node temp = head;                    // Start from the head
        while (temp != null) {               // Traverse until the end
            System.out.print(temp.value + " -> "); // Print current node's value
            temp = temp.next;                // Move to next node
        }
        System.out.println("END");           // Indicate end of the list
    }

    // Insert a node at the end of the list
    public void insertLast(int val) {
        if (tail == null) {                  // If list is empty
            insertFirst(val);                // Use insertFirst for first node
            return;                          // Exit method
        }
        Node node = new Node(val);           // Create a new node with the given value
        tail.next = node;                    // Link current tail to new node
        tail = node;                         // Update tail to new node
        size++;                              // Increment size
    }

    // Insert a node at a specific index (0-based)
    public void insert(int val, int index) {
        if (index == 0) {                    // If inserting at start
            insertFirst(val);                // Use insertFirst
            return;                          // Exit method
        }
        if (index == size) {                 // If inserting at end
            insertLast(val);                 // Use insertLast
            return;                          // Exit method
        }
        Node temp = head;                    // Start from head
        for (int i = 1; i < index; i++) {    // Traverse to node before index
            temp = temp.next;                // Move to next node
        }
        Node node = new Node(val, temp.next); // Create new node linking to temp's next
        temp.next = node;                    // Link previous node to new node
        size++;                              // Increment size
    }

    // Inner class representing a node in the list
    private class Node {
        private int value;                   // Value stored in the node
        private Node next;                   // Reference to the next node

        // Constructor for a node with only a value
        public Node(int value) {
            this.value = value;              // Initialize value
            this.next = null;                // Next is null by default
        }

        // Constructor for a node with a value and next reference
        public Node(int value, Node next) {
            this.value = value;              // Initialize value
            this.next = next;                // Set next reference
        }
    }


    // Remove duplicates from a sorted linked list
    public void duplicates() {
        if (head == null || head.next == null) { // Check if list is empty or has one node
            return;                              // No duplicates possible, exit
        }
        Node node = head;                        // Start from the head
        while (node != null && node.next != null) { // Traverse until end or second-to-last node
            if (node.value == node.next.value) { // If current node equals next node (duplicate)
                node.next = node.next.next;      // Skip the duplicate by updating next pointer
                size--;                          // Decrease size since a node is removed
            } else {                             // If no duplicate
                node = node.next;                // Move to the next node
            }
        }
        tail = node;                             // Update tail to the last node
        // No need to set tail.next = null since it's already null at the end
    }

    // Merge two sorted linked lists into a new sorted list
    public static deleteDuplicates merge(deleteDuplicates first, deleteDuplicates second) {
        Node f = first.head;                     // Pointer to head of first list
        Node s = second.head;                    // Pointer to head of second list
        deleteDuplicates ans = new deleteDuplicates(); // New list to store merged result

        // Merge while both lists have nodes
        while (f != null && s != null) {
            if (f.value < s.value) {             // If first list's value is smaller
                ans.insertLast(f.value);         // Add it to the result
                f = f.next;                      // Move to next node in first list
            } else {                             // If second list's value is smaller or equal
                ans.insertLast(s.value);         // Add it to the result
                s = s.next;                      // Move to next node in second list
            }
        }

        // Append remaining nodes from first list, if any
        while (f != null) {
            ans.insertLast(f.value);             // Add remaining first list node
            f = f.next;                          // Move to next node
        }

        // Append remaining nodes from second list, if any
        while (s != null) {
            ans.insertLast(s.value);             // Add remaining second list node
            s = s.next;                          // Move to next node
        }

        return ans;                              // Return the merged list
    }


    // Main method to test the functionality
    public static void main(String[] args) {
//        deleteDuplicates duplicates = new deleteDuplicates(); // Create new list instance
//
//        // Insert sorted elements with duplicates
//        duplicates.insertLast(1);            // List: 1
//        duplicates.insertLast(1);            // List: 1 -> 1
//        duplicates.insertLast(2);            // List: 1 -> 1 -> 2
//        duplicates.insertLast(3);            // List: 1 -> 1 -> 2 -> 3
//        duplicates.insertLast(3);            // List: 1 -> 1 -> 2 -> 3 -> 3
//        duplicates.insertLast(4);            // List: 1 -> 1 -> 2 -> 3 -> 3 -> 4
//        duplicates.insertLast(4);            // List: 1 -> 1 -> 2 -> 3 -> 3 -> 4 -> 4
//        duplicates.insertLast(5);            // List: 1 -> 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
//
//        // Display list before removing duplicates
//        duplicates.display();                // Output: 1 -> 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5 -> END
//
//        // Remove duplicates
//        duplicates.duplicates();             // Process list to remove duplicates
//
//        // Display list after removing duplicates
//        duplicates.display();                // Output: 1 -> 2 -> 3 -> 4 -> 5 -> END

        deleteDuplicates first=new deleteDuplicates();
        deleteDuplicates second=new deleteDuplicates();

        first.insertLast(1);
        first.insertLast(3);
        first.insertLast(4);

        first.display();
        second.insertLast(2);
        second.insertLast(4);
        second.insertLast(6);
        second.insertLast(8);
        second.display();
        deleteDuplicates ans=deleteDuplicates.merge(first,second);
        ans.display();

    }

}