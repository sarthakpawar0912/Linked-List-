package LinkedList.Examples;

// Problem: https://leetcode.com/problems/rotate-list/
public class RotateRightLL {

    // Rotate the linked list to the right by k places

    public ListNode rotateRight(ListNode head, int k) {

        // Step 1: Handle edge cases
        // If list is empty, has one node, or k is 0, no rotation needed
        if (head == null || head.next == null || k <= 0) {
            // Return the head as is
            return head;
        }

        // Step 2: Compute the length of the list and find the last node
        ListNode last = head;   // Pointer to traverse to the last node
        int length = 1;         // Initialize length (counting head)
        while (last.next != null) { // Traverse until the last node
            last = last.next;   // Move to next node
            length++;           // Increment length
        }
        // After loop, 'last' points to the tail, and 'length' is the total number of nodes

        // Step 3: Connect the last node to the head, forming a circular list
        last.next = head;
        // Now the list is a ring: e.g., 1 -> 2 -> 3 -> 4 -> 5 -> 1...

        // Step 4: Normalize k to handle cases where k > length
        int rotations = k % length; // Effective rotations needed
        // If rotations = 0, list would return to original state after full cycles
        if (rotations == 0) {
            // Break the ring and return original head
            last.next = null;
            return head;
        }

        // Step 5: Calculate steps to skip to find the new last node
        int skip = length - rotations; // Number of nodes to skip from head
        // 'skip' positions us at the node before the new head

        // Step 6: Traverse to the new last node
        ListNode newLast = head; // Pointer to find the new last node
        for (int i = 0; i < skip - 1; i++) { // Move skip-1 steps
            newLast = newLast.next; // Advance to next node
        }
        // After loop, 'newLast' is the node before the new head

        // Step 7: Break the ring and set the new head
        head = newLast.next;    // New head is the node after newLast
        newLast.next = null;    // Break the ring by setting newLast’s next to null

        // Step 8: Return the new head of the rotated list
        return head;
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

    // Main function to test the rotateRight method
    public static void main(String[] args) {
        // Create an instance of RotateRightLL
        RotateRightLL rotator = new RotateRightLL();
        // 'rotator' is used to access methods and create ListNode instances

        // Test Case 1: List: 1 -> 2 -> 3 -> 4 -> 5, k = 2
        ListNode head1 = rotator.new ListNode(1);
        head1.next = rotator.new ListNode(2);
        head1.next.next = rotator.new ListNode(3);
        head1.next.next.next = rotator.new ListNode(4);
        head1.next.next.next.next = rotator.new ListNode(5);
        // List: 1 -> 2 -> 3 -> 4 -> 5

        // Test Case 2: List: 0 -> 1 -> 2, k = 4
        ListNode head2 = rotator.new ListNode(0);
        head2.next = rotator.new ListNode(1);
        head2.next.next = rotator.new ListNode(2);
        // List: 0 -> 1 -> 2

        // Test Case 3: Single node: 1, k = 1
        ListNode head3 = rotator.new ListNode(1);
        // List: 1

        // Test Case 4: Empty list, k = 1
        ListNode head4 = null;
        // List: empty

        // Run Test Case 1
        System.out.println("Test Case 1: List: 1 -> 2 -> 3 -> 4 -> 5, k = 2");
        System.out.print("Input: ");
        rotator.printList(head1);
        ListNode rotated1 = rotator.rotateRight(head1, 2);
        System.out.print("Rotated: ");
        rotator.printList(rotated1);
        // Expected: 4 -> 5 -> 1 -> 2 -> 3

        // Run Test Case 2
        System.out.println("\nTest Case 2: List: 0 -> 1 -> 2, k = 4");
        System.out.print("Input: ");
        rotator.printList(head2);
        ListNode rotated2 = rotator.rotateRight(head2, 4);
        System.out.print("Rotated: ");
        rotator.printList(rotated2);
        // Expected: 2 -> 0 -> 1

        // Run Test Case 3
        System.out.println("\nTest Case 3: List: 1, k = 1");
        System.out.print("Input: ");
        rotator.printList(head3);
        ListNode rotated3 = rotator.rotateRight(head3, 1);
        System.out.print("Rotated: ");
        rotator.printList(rotated3);
        // Expected: 1

        // Run Test Case 4
        System.out.println("\nTest Case 4: Empty list, k = 1");
        System.out.print("Input: ");
        rotator.printList(head4);
        ListNode rotated4 = rotator.rotateRight(head4, 1);
        System.out.print("Rotated: ");
        rotator.printList(rotated4);
        // Expected: (empty)
    }
}


/*
How It Works:
Step 1: Edge Cases:
If head is null (empty list), head.next is null (single node), or k <= 0, no rotation is needed—return head.
Step 2: Compute Length:
Start last at head, count nodes while moving to the tail.
After loop, last is the tail, length is the total number of nodes.
Step 3: Form Ring:
Connect last.next = head, making the list circular (e.g., 1 -> 2 -> 3 -> 1...).
Step 4: Normalize k:
Compute rotations = k % length to handle large k.
If rotations = 0, break the ring and return the original head.
Step 5: Calculate Skip:
skip = length - rotations: Number of nodes to traverse from the start to reach the new last node.
Step 6: Find New Last:
Move newLast skip - 1 steps from head to position it before the new head.
Step 7: Break Ring:
Set head = newLast.next (new head).
Set newLast.next = null to break the ring.
Step 8: Return: Return the new head.
Why This Approach?:
O(n) time, O(1) space by using the ring method.
Handles large k efficiently with modulo.
Example (for 1 -> 2 -> 3 -> 4 -> 5, k = 2):
Length: last = 5, length = 5.
Ring: 5.next = 1, list becomes 1 -> 2 -> 3 -> 4 -> 5 -> 1....
Normalize: rotations = 2 % 5 = 2.
Skip: skip = 5 - 2 = 3.
Traverse: newLast = head, move 2 steps (i = 0 to 1): newLast = 3.
Break: head = 3.next = 4, 3.next = null.
Result: 4 -> 5 -> 1 -> 2 -> 3.
 */