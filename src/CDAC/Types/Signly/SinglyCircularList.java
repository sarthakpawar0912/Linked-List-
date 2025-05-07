package CDAC.Types.Signly;
import java.util.Scanner;

class SinglyCircularLinkedList {

    // Node class
    static class Node {

        // Node class fields
        private Object data; // Stores the data value of the node
        private Node next;   // Reference to the next node in the list


        // Node class methods
        public Node() {
            data = 0;        // Initialize data to 0
            next = null;     // Initialize next to null
        }


        public Node(int val) {
            data = val;      // Initialize data with the provided value
            next = null;     // Initialize next to null
        }

    }

    // List class Fields
    private Node head;       // Reference to the head node of the circular list

    // List class Methods
    public SinglyCircularLinkedList() {
        head = null;         // Initialize head to null (empty list)
    }

    public boolean isEmpty() {
        return head == null; // Return true if the list is empty (head is null)
    }


    public void display() {

        System.out.println("Displaying the list:"); // Print header for list output

        // Special case: if list is empty, print message and return
        if (isEmpty()) {
            System.out.println("List is empty");    // Inform user the list has no nodes
            return;                                 // Exit the method
        }

        // General case: traverse and print all nodes in the circular list
        Node trav = head;                           // Start traversal from head
        do {
            System.out.print(trav.data+"->");          // Print current node's data
            trav = trav.next;                       // Move to the next node
        } while (trav != head);                     // Continue until back at head (circular loop)
    
    }


    public void addLast(int val) {

        // Create and initialize a new node with the given value
        Node newNode = new Node(val);
        // Special case: if list is empty
        if (head == null) {
            head = newNode;           // Set head to the new node
            newNode.next = newNode;   // Make the new node point to itself to form a circular list
            return;                   // Exit the method
        }
        // General case: traverse to the last node (whose next points to head)
        Node trav = head;             // Start traversal from head
        while (trav.next != head) {   // Continue until the last node is found
            trav = trav.next;         // Move to the next node
        }
        // Link the new node to head to maintain circular structure
        newNode.next = head;          // New node's next points to head
        // Link the last node to the new node
        trav.next = newNode;          // Last node's next points to the new node
    }

    public void addFirst(int val) {
        // Create a new node with the given value
        Node newNode = new Node(val);              // Initialize new node with data and null next
        // Special case: if list is empty
        if (head == null) {                        // Check if the list has no nodes
            head = newNode;                        // Set head to the new node
            newNode.next = newNode;                // Make new node point to itself to form a circular list
            return;                                // Exit the method
        }
        // General case: traverse to the last node (whose next points to head)
        Node trav = head;                          // Start traversal from head
        while (trav.next != head) {                // Continue until the last node is found
            trav = trav.next;                      // Move to the next node
        }
        // Link the new node to the current head
        newNode.next = head;                       // New node's next points to current head
        // Update the last node to point to the new node
        trav.next = newNode;                       // Last node's next points to new node
        // Update head to the new node
        head = newNode;                            // Make the new node the new head
    }

    public void addAtPos(int val, int pos) {
        // Create a new node with the given value
        Node newNode = new Node(val);                     // Initialize new node with data and null next
        // Special case: empty list
        if (head == null) {                               // Check if the list has no nodes
            if (pos == 1) {                               // If position is 1, add as the only node
                head = newNode;                           // Set head to the new node
                newNode.next = newNode;                   // Make new node point to itself to form a circular list
            } else {                                      // If position is not 1, it’s invalid
                System.out.println("Invalid position: List is empty"); // Print error message
            }
            return;                                       // Exit the method
        }
        // Validate position (pos must be >= 1)
        if (pos < 1) {                                    // Check if position is invalid (negative or zero)
            System.out.println("Invalid position: Position must be at least 1"); // Print error message
            return;                                       // Exit the method
        }
        // Special case: pos = 1 (add at beginning)
        if (pos == 1) {                                   // If position is 1, add at the start
            Node trav = head;                             // Start traversal from head to find last node
            while (trav.next != head) {                   // Continue until the last node is found
                trav = trav.next;                         // Move to the next node
            }
            newNode.next = head;                          // New node's next points to current head
            trav.next = newNode;                          // Last node's next points to new node
            head = newNode;                               // Update head to the new node
            return;                                       // Exit the method
        }
        // General case: traverse to pos-1
        Node trav = head;                                 // Start traversal from head
        for (int i = 1; i < pos - 1; i++) {               // Traverse to the node at pos-1
            trav = trav.next;                             // Move to the next node
            if (trav == head) {                           // If we loop back to head, position is too large
                System.out.println("Invalid position: Position exceeds list length"); // Print error message
                return;                                   // Exit the method
            }
        }
        // Insert new node after trav
        newNode.next = trav.next;                    // New node's next points to trav's next
        trav.next = newNode;                              // Trav's next points to new node
    }


    public void deleteFirst() {
        // Special case: empty list
        if (head == null) {                               // Check if the list has no nodes
            throw new RuntimeException("List is empty");   // Throw exception for empty list
        }
        // Special case: single node
        if (head.next == head) {                          // Check if the list has only one node
            head = null;                                  // Set head to null to empty the list
            return;                                       // Exit the method
        }
        // General case: multiple nodes
        Node trav = head;                                 // Start traversal from head
        while (trav.next != head) {                       // Continue until the last node is found
            trav = trav.next;                             // Move to the next node
        }
        // Update head to the next node
        head = head.next;                                 // Skip the first node by moving head
        // Update last node's next to new head
        trav.next = head;                                 // Last node's next points to new head
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
        // Special case: position 1 (delete first)
        if (pos == 1) {                                   // If position is 1, delete the first node
            deleteFirst();                                // Call deleteFirst to handle circularity
            return;                                       // Exit the method
        }
        // General case: traverse to pos-1
        Node trav = head;                                 // Start traversal from head
        for (int i = 1; i < pos - 1; i++) {               // Traverse to the node at pos-1
            trav = trav.next;                             // Move to the next node
            if (trav == head) {                           // If we loop back to head, position is too large
                throw new RuntimeException("Invalid position: Position exceeds list length"); // Throw exception
            }
        }
        // Check if next node exists (avoid deleting head in invalid cases)
        if (trav.next == head && pos > 2) {               // If trav is last node and pos is too large
            throw new RuntimeException("Invalid position: Position exceeds list length"); // Throw exception
        }
        // Delete node at pos by skipping it
        trav.next = trav.next.next;                       // Update trav's next to skip the node at pos
    }

    public void deleteLast() {
        // Special case: empty list
        if (head == null) {                               // Check if the list has no nodes
            throw new RuntimeException("List is empty");   // Throw exception for empty list
        }
        // Special case: single node
        if (head.next == head) {                          // Check if the list has only one node
            head = null;                                  // Set head to null to empty the list
            return;                                       // Exit the method
        }
        // General case: multiple nodes
        Node trav = head;                                 // Start traversal from head
        while (trav.next.next != head) {                  // Continue until the second-to-last node is found
            trav = trav.next;                             // Move to the next node
        }
        // Remove last node by linking to head
        trav.next = head;                                 // Update second-to-last node's next to head
    }

    public void delAll() {
        // Clear the list by setting head to null
        head = null;                                      // Set head to null to make all nodes unreachable
        // All nodes will be garbage-collected by Java
    }



}






public class SinglyCircularList  {


    public static void main(String[] args) {

        int choice,val,pos;

        SinglyCircularLinkedList list=new SinglyCircularLinkedList();

        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("\n\n0--->Exit \n1--->Display\n2--->Add First\n3--->Add Last\n4--->Add at a Pos\n5--->Delete First\n6--->Delete Last\n7--->Delete at a Pos \n8--->Delete All");

            System.out.println("Enter Your choice:");

            choice=sc.nextInt();

            switch (choice){

                case 1://Display
                   list.display();
                    break;

                case 2://Add First
                    System.out.println("Enter new Element value");
                    val=sc.nextInt();
                    list.addFirst(val);
                    break;

                case 3://Add last
                    System.out.println("Enter new Element value");
                    val=sc.nextInt();
                    list.addLast(val);
                    break;

                case 4://Add at POS
                    System.out.println("Enter new Element value");
                    val=sc.nextInt();
                    System.out.println("Enter new Element Position");
                    pos=sc.nextInt();
                    list.addAtPos(val,pos);
                    break;

                case 5: // Delete First
                    try {
                        list.deleteFirst();
                        System.out.println("First element deleted");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6: // Delete Last
                    try {
                        list.deleteLast();
                        System.out.println("Last element deleted");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 7: // Delete at POS
                    System.out.println("Enter position to delete");
                    pos = sc.nextInt();
                    try {
                        list.deleteAtPos(pos);
                        System.out.println("Element at position " + pos + " deleted");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 8://Del All
                  list.delAll();
                    break;

            }

        }while (choice!=0);
    }

}
