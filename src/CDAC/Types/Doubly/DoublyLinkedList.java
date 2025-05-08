package CDAC.Types.Doubly;
import java.util.Scanner;

class DoublyList {

    //node is static member class of Doubly  list
    static class Node {
        int data;
        Node next;
        Node prev;

        public Node() {
            data = 0;
            next=null;
            prev=null;
        }

        public Node(int val) {
            data = val;
            next=null;
            prev=null;
        }
    }


    //list class fields
    private Node head;


    //list class methods
    public DoublyList(){

        head=null;

    }

    void displayForward() {

        // Print header for forward list display
        System.out.println("Displaying the Forward list:");  // Indicate that the list will be displayed forward

        // Special case: check if the list is empty
        if (head == null) {                                  // If head is null, the list has no nodes

            // Print message for empty list
            System.out.println("List is empty");              // Inform user that the list is empty

        } else {

            // General case: traverse and print nodes forward
            Node trav = head;                                // Start traversal from the head node

            while (trav != null) {                           // Continue until the end of the list

                // Print current node's data
                System.out.print(trav.data + " -> ");         // Print data followed by arrow for list format

                // Move to the next node
                trav = trav.next;
                // Update trav to the next node
            }

            // Print null to indicate end of list
            System.out.println("null");
            // End the list output with null
        }
    }

    void displayReverse() {

        // Print header for reverse list display
        System.out.println("Displaying the Reverse list:");  // Indicate that the list will be displayed in reverse

        // Special case: check if the list is empty
        if (head == null) {                                  // If head is null, the list has no nodes

            // Print message for empty list
            System.out.println("List is empty");              // Inform user that the list is empty

        } else {

            // General case: traverse to last node
            Node trav = head;                                // Start traversal from the head node

            while (trav.next != null) {                      // Continue until the last node is reached

                // Move to the next node
                trav = trav.next;
                // Update trav to the next node
            }

            // Traverse and print nodes backward
            while (trav != null) {                           // Continue until the beginning of the list

                // Print current node's data
                System.out.print(trav.data + " -> ");         // Print data followed by arrow for list format
               
                // Move to the previous node
                trav = trav.prev;
                // Update trav to the previous node
            }

            // Print null to indicate end of list
            System.out.println("null");
            // End the list output with null
        }
    }

    void addLast(int val) {

        // Create a new node with the given value
        Node newNode = new Node(val);                     // Initialize new node with data, null next, and null prev

        // Special case: empty list
        if (head == null) {
            // Check if the list has no nodes
            head = newNode;                               // Set head to the new node
            return;                                       // Exit the method
        }

        // General case: traverse to the last node
        Node trav = head;

        // Start traversal from the head node
        while (trav.next != null) {                       // Continue until the last node is reached
            trav = trav.next;                             // Move to the next node
        }

        // Link the new node to the last node
        trav.next = newNode;

        // Set last node's next to the new node
        // Link the last node to the new node as its previous
        newNode.prev = trav;
        // Set new node's prev to the last node
    }

    void addFirst(int val) {
        // Create a new node with the given value
        Node newNode = new Node(val);                     // Initialize new node with data, null next, and null prev
        // Special case: empty list
        if (head == null) {                               // Check if the list has no nodes
            head = newNode;                               // Set head to the new node
            return;                                       // Exit the method
        }
        // General case: non-empty list
        newNode.next = head;                              // Link new node's next to current head
        newNode.prev = null;                              // Set new node's prev to null (new head has no previous)
        head.prev = newNode;                              // Link current head's prev to new node
        head = newNode;                                   // Update head to the new node
    }

    void addAtPos(int val, int pos) {
        // Create a new node with the given value
        Node newNode = new Node(val);                     // Initialize new node with data, null next, and null prev
        // Special case: empty list
        if (head == null) {                               // Check if the list has no nodes
            if (pos == 1) {                               // If position is 1, add as the only node
                head = newNode;                           // Set head to the new node
                return;                                   // Exit the method
            } else {                                      // If position is not 1, it’s invalid
                throw new RuntimeException("Invalid position: List is empty"); // Throw exception
            }
        }
        // Validate position (pos must be >= 1)
        if (pos < 1) {                                    // Check if position is invalid (negative or zero)
            throw new RuntimeException("Invalid position: Position must be at least 1"); // Throw exception
        }
        // Special case: pos = 1 (add at beginning)
        if (pos == 1) {                                   // If position is 1, add at the start
            addFirst(val);                                // Call addFirst to handle insertion
            return;                                       // Exit the method
        }
        // General case: traverse to pos-1
        Node trav = head;                                 // Start traversal from head
        int i = 1;                                        // Initialize loop counter
        for (; i < pos - 1 && trav.next != null; i++) {   // Traverse to node at pos-1 or end of list
            trav = trav.next;                             // Move to the next node
        }
        // Check if position is invalid (beyond list length)
        if (trav.next == null && i < pos - 1) {           // If traversal ended early, pos is too large
            throw new RuntimeException("Invalid position: Position exceeds list length"); // Throw exception
        }
        // Insert new node after trav
        newNode.next = trav.next;                         // Link new node's next to trav's next
        newNode.prev = trav;                              // Link new node's prev to trav
        if (trav.next != null) {                          // If there’s a node after trav
            trav.next.prev = newNode;                     // Link next node's prev to new node
        }
        trav.next = newNode;                              // Link trav's next to new node
    }

    public void deleteFirst() {
        // Special case: empty list
        if (head == null) {                               // Check if the list has no nodes
            throw new RuntimeException("List is empty");   // Throw exception for empty list
        }
        // Special case: single node
        if (head.next == null) {                          // Check if the list has only one node
            head = null;                                  // Set head to null to empty the list
            return;                                       // Exit the method
        }
        // General case: multiple nodes
        head = head.next;                                 // Move head to the next node
        head.prev = null;                                 // Set new head's prev to null
    }

    public void deleteLast() {
        // Special case: empty list
        if (head == null) {                               // Check if the list has no nodes
            throw new RuntimeException("List is empty");   // Throw exception for empty list
        }
        // Special case: single node
        if (head.next == null) {                          // Check if the list has only one node
            head = null;                                  // Set head to null to empty the list
            return;                                       // Exit the method
        }
        // General case: multiple nodes
        Node trav = head;                                 // Start traversal from head
        while (trav.next.next != null) {                  // Traverse to the second-to-last node
            trav = trav.next;                             // Move to the next node
        }
        trav.next = null;                                 // Remove last node by setting next to null
        // Note: prev of last node is already handled (trav is the new last node)
    }

    public void deleteAtPos(int pos) {
        // Special case: empty list
        if (head == null) {                               // Check if the list has no nodes
            throw new RuntimeException("List is empty");   // Throw exception for empty list
        }
        // Validate position
        if (pos < 1) {                                    // Check if position is invalid (negative or zero)
            throw new RuntimeException("Invalid position: Position must be at least 1"); // Throw exception
        }
        // Special case: position 1
        if (pos == 1) {                                   // If position is 1, delete first node
            deleteFirst();                                // Call deleteFirst to handle deletion
            return;                                       // Exit the method
        }
        // General case: traverse to pos-1
        Node trav = head;                                 // Start traversal from head
        for (int i = 1; i < pos - 1 && trav.next != null; i++) { // Traverse to node at pos-1 or end
            trav = trav.next;                             // Move to the next node
        }
        // Check if position is invalid
        if (trav.next == null) {                          // If trav is last node or beyond, pos is invalid
            throw new RuntimeException("Invalid position: Position exceeds list length"); // Throw exception
        }
        // Delete node at pos
        Node temp = trav.next;                            // Store node to delete
        trav.next = temp.next;                            // Link trav to node after temp
        if (temp.next != null) {                          // If there’s a node after temp
            temp.next.prev = trav;                        // Update its prev to trav
        }
    }

    public void deleteAll() {
        // Clear the list
        head = null;                                      // Set head to null to make all nodes unreachable
        // All nodes will be garbage-collected by Java
    }

}

public class DoublyLinkedList {
    public static void main(String[] args) {
        // Declare variables for user input
        int choice, val, pos;                              // Store menu choice, value, and position
        // Create a new doubly linked list
        DoublyList list = new DoublyList();                // Instantiate the DoublyList object
        // Create Scanner for user input
        Scanner sc = new Scanner(System.in);               // Initialize Scanner for reading input
        // Menu loop
        do {
            // Display menu options
            System.out.println("\n\n0--->Exit\n1--->Forward Display\n2--->Reverse Display\n3--->Add First\n4--->Add Last\n5--->Add at a Pos\n6--->Delete First\n7--->Delete Last\n8--->Delete at a Pos\n9--->Delete All"); // Print menu
            // Prompt for user choice
            System.out.println("Enter Your choice:");       // Ask user to enter a choice
            // Read user choice
            choice = sc.nextInt();                         // Store the user's menu selection
            // Process user choice
            switch (choice) {
                case 1: // Forward Display
                    list.displayForward();                  // Display the list in forward order
                    break;
                case 2: // Reverse Display
                    list.displayReverse();                  // Display the list in reverse order
                    break;
                case 3: // Add First (unimplemented)
                     System.out.println("Enter new Element value");
                     val = sc.nextInt();
                     list.addFirst(val);
                    break;
                case 4: // Add Last
                    System.out.println("Enter new Element value"); // Prompt for value to add
                    val = sc.nextInt();                    // Read the value
                    list.addLast(val);                     // Add the value to the end of the list
                    break;
                case 5: // Add at Pos (unimplemented)
                     System.out.println("Enter new Element value");
                     val = sc.nextInt();
                     System.out.println("Enter new Element Position");
                     pos = sc.nextInt();
                     list.addAtPos(val, pos);
                    break;
                case 6: // Delete First (unimplemented)
                     try {
                         list.deleteFirst();
                         System.out.println("First element deleted");
                     } catch (RuntimeException e) {
                         System.out.println(e.getMessage());
                     }
                    break;
                case 7: // Delete Last (unimplemented)
                     try {
                         list.deleteLast();
                         System.out.println("Last element deleted");
                     } catch (RuntimeException e) {
                         System.out.println(e.getMessage());
                     }
                    break;
                case 8: // Delete at Pos (unimplemented)
                     System.out.println("Enter position to delete");
                     pos = sc.nextInt();
                     try {
                         list.deleteAtPos(pos);
                         System.out.println("Element at position " + pos + " deleted");
                     } catch (RuntimeException e) {
                         System.out.println(e.getMessage());
                     }
                    break;
                case 9: // Delete All (unimplemented)
                   list.deleteAll();
                    break;
            }
        } while (choice != 0);                            // Continue until user chooses to exit
                                              // Free Scanner resources
    }
}