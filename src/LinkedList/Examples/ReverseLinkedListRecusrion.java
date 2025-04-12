package LinkedList.Examples;

// Problem: https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedListRecusrion {


    // Reverse the linked list using recursion
    public ListNode reverseList(ListNode head) {
        // Base case: if head is null (empty list) or has one node
        if (head == null || head.next == null) {
            // Return head as is (no reversal needed)
            return head;
        }

        // Recursively reverse the rest of the list
        ListNode newHead = reverseList(head.next);
        // 'newHead' is the head of the reversed sublist (e.g., for 1->2->3, it’s 3->2)

        // Reverse the link: make the next node point to the current node
        head.next.next = head;
        // For node 1 (head), with next as 2: set 2->next = 1 (creates 2->1)

        // Break the original link to avoid cycles
        head.next = null;
        // Set 1->next = null (1 becomes the tail)

        // Return the new head of the reversed list
        return newHead;
        // 'newHead' remains the head of the fully reversed list
    }


    // Definition of ListNode class
    class ListNode {
        int val;          // Value stored in the node
        ListNode next;    // Reference to the next node

        // Default constructor for dummy nodes
        public ListNode() {
            // Initializes node with default values (val = 0, next = null)
        }

        // Constructor with value
        ListNode(int x) {
            val = x;      // Set the node’s value
            next = null;  // Initialize next pointer to null
        }
    }


    // Helper method to print the linked list
    private void printList(ListNode head) {
        // Start from the head of the list
        ListNode current = head;
        // Traverse until the end
        while (current != null) {
            // Print the current node’s value
            System.out.print(current.val);
            // Add arrow if there’s a next node
            if (current.next != null) {
                System.out.print(" -> ");
            }
            // Move to the next node
            current = current.next;
        }
        // Print newline at the end
        System.out.println();
    }


    // Main function to test the reverseList method
    public static void main(String[] args) {
        // Create an instance of ReverseLinkedList
        ReverseLinkedListRecusrion reverser = new ReverseLinkedListRecusrion();
        // 'reverser' is used to access methods and create ListNode instances

        // Test Case 1: List with multiple nodes: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head1 = reverser.new ListNode(1);
        // Create first node with value 1
        head1.next = reverser.new ListNode(2);
        // Add node with value 2
        head1.next.next = reverser.new ListNode(3);
        // Add node with value 3
        head1.next.next.next = reverser.new ListNode(4);
        // Add node with value 4
        head1.next.next.next.next = reverser.new ListNode(5);
        // Add node with value 5
        // List: 1 -> 2 -> 3 -> 4 -> 5

        // Test Case 2: List with two nodes: 1 -> 2
        ListNode head2 = reverser.new ListNode(1);
        // Create first node with value 1
        head2.next = reverser.new ListNode(2);
        // Add node with value 2
        // List: 1 -> 2

        // Test Case 3: Single node: 1
        ListNode head3 = reverser.new ListNode(1);
        // Create a single node with value 1
        // List: 1

        // Test Case 4: Empty list
        ListNode head4 = null;
        // Initialize an empty list (null)
        // List: empty

        // Run Test Case 1
        System.out.println("Test Case 1: Multiple nodes");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        reverser.printList(head1);
        // Print the input list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode reversed1 = reverser.reverseList(head1);
        // Reverse the list and store result
        System.out.print("Reversed: ");
        // Label for reversed list
        reverser.printList(reversed1);
        // Print the reversed list: 5 -> 4 -> 3 -> 2 -> 1

        // Run Test Case 2
        System.out.println("\nTest Case 2: Two nodes");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        reverser.printList(head2);
        // Print the input list: 1 -> 2
        ListNode reversed2 = reverser.reverseList(head2);
        // Reverse the list and store result
        System.out.print("Reversed: ");
        // Label for reversed list
        reverser.printList(reversed2);
        // Print the reversed list: 2 -> 1

        // Run Test Case 3
        System.out.println("\nTest Case 3: Single node");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        reverser.printList(head3);
        // Print the input list: 1
        ListNode reversed3 = reverser.reverseList(head3);
        // Reverse the list and store result
        System.out.print("Reversed: ");
        // Label for reversed list
        reverser.printList(reversed3);
        // Print the reversed list: 1

        // Run Test Case 4
        System.out.println("\nTest Case 4: Empty list");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        reverser.printList(head4);
        // Print the input list: (empty)
        ListNode reversed4 = reverser.reverseList(head4);
        // Reverse the list and store result
        System.out.print("Reversed: ");
        // Label for reversed list
        reverser.printList(reversed4);
        // Print the reversed list: (empty)
    }

}