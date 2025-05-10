package CDAC.Examples;


class SinglyList{

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

    public Node head;

    public SinglyList() {
        head = null;
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

//   public void reverse() {
//        // Consider current list as old and new list as empty
//        if (head == null || head.next == head) return; // Empty or single node case
//
//        Node oldhead = head;  // Head of the old list
//        head = null;          // New list starts empty
//        Node temp = null;     // Temporary node
//        Node tail = head;     // Track original head (becomes tail after reversal)
//
//        // Traverse until back at original head
//        do {
//            // Delete first (temp) from old list
//            temp = oldhead;
//            oldhead = oldhead.next;
//            // Add first to new list
//            temp.next = head;
//            head = temp;
//        } while (oldhead != tail); // Repeat until old list is finished
//
//        // Restore circular structure
//        tail.next = head;          // Original head (now tail) points to new head
//        head = temp;               // Update head to new first node
//    }

    private Node recReverse(Node h){
        if(h.next==h) {
            head=h;
            return h;};

        Node t=recReverse(h.next);
        t.next=h;
        h.next=null;
        return h;
    }
    public void recReverse() {
        if(head!=null){
        recReverse(head);}
    }


}



public class LinkedListMain {
    public static void main(String[] args) {
        SinglyList list=new SinglyList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);

        list.display();
       // list.reverse();
        list.recReverse();
        list.display();
    }
}
