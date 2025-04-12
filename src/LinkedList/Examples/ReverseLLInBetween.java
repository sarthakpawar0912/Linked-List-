package LinkedList.Examples;

// Problem: https://leetcode.com/problems/reverse-linked-list-ii/
public class ReverseLLInBetween {


    // Reverse the sublist from position left to right (1-indexed)
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // If left equals right, no reversal needed
        if (left == right) {
            // Return the list as is
            return head;
        }

        // If list is empty or single node, no reversal possible
        if (head == null || head.next == null) {
            // Return the list as is
            return head;
        }

        // Initialize pointers to traverse to the left-1 position
        ListNode prev = null;   // Node before the sublist (left-1)
        ListNode current = head; // Current node being processed

        // Skip the first left-1 nodes to reach the node at position left
        for (int i = 1; i < left && current != null; i++) {
            // Move prev to current
            prev = current;
            // Move current to next node
            current = current.next;
        }

        // Save pointers for reconnection
        ListNode last = prev;      // Points to node before sublist (left-1)
        ListNode newEnd = current; // Will become the tail of reversed sublist

        // Reverse the sublist from left to right
        ListNode next = null; // To store the next node
        for (int i = 0; i <= right - left && current != null; i++) {
            // Save the next node to avoid losing it
            next = current.next;
            // Reverse the link: point current’s next to prev
            current.next = prev;
            // Move prev to current
            prev = current;
            // Move current to next
            current = next;
        }

        // Reconnect the reversed sublist to the rest of the list
        if (last != null) {
            // If last is not null, connect last to the new head of reversed sublist
            last.next = prev;
        } else {
            // If last is null, the sublist started at head, so update head
            head = prev;
        }

        // Connect the end of reversed sublist to the remaining list
        newEnd.next = current;

        // Return the head of the modified list
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

    // Main function to test the reverseBetween method
    public static void main(String[] args) {
        // Create an instance of ReverseLLInBetween
        ReverseLLInBetween reverser = new ReverseLLInBetween();
        // 'reverser' is used to access methods and create ListNode instances

        // Test Case 1: List: 1 -> 2 -> 3 -> 4 -> 5, left=2, right=4
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

        // Test Case 2: List: 1 -> 2 -> 3 -> 4 -> 5, left=1, right=4
        ListNode head2 = reverser.new ListNode(1);
        // Create first node with value 1
        head2.next = reverser.new ListNode(2);
        // Add node with value 2
        head2.next.next = reverser.new ListNode(3);
        // Add node with value 3
        head2.next.next.next = reverser.new ListNode(4);
        // Add node with value 4
        head2.next.next.next.next = reverser.new ListNode(5);
        // Add node with value 5
        // List: 1 -> 2 -> 3 -> 4 -> 5

        // Test Case 3: Single node: 1, left=1, right=1
        ListNode head3 = reverser.new ListNode(1);
        // Create a single node with value 1
        // List: 1


        // Run Test Case 1
        System.out.println("Test Case 1: List: 1 -> 2 -> 3 -> 4 -> 5, left=2, right=4");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        reverser.printList(head1);
        // Print the input list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode reversed1 = reverser.reverseBetween(head1, 2, 4);
        // Reverse sublist from position 2 to 4
        System.out.print("Reversed: ");
        // Label for reversed list
        reverser.printList(reversed1);
        // Print the reversed list: 1 -> 4 -> 3 -> 2 -> 5

        // Run Test Case 2
        System.out.println("\nTest Case 2: List: 1 -> 2 -> 3 -> 4 -> 5, left=1, right=4");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        reverser.printList(head2);
        // Print the input list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode reversed2 = reverser.reverseBetween(head2, 1, 4);
        // Reverse sublist from position 1 to 4
        System.out.print("Reversed: ");
        // Label for reversed list
        reverser.printList(reversed2);
        // Print the reversed list: 4 -> 3 -> 2 -> 1 -> 5

        // Run Test Case 3
        System.out.println("\nTest Case 3: List: 1, left=1, right=1");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        reverser.printList(head3);
        // Print the input list: 1
        ListNode reversed3 = reverser.reverseBetween(head3, 1, 1);
        // Reverse sublist from position 1 to 1
        System.out.print("Reversed: ");
        // Label for reversed list
        reverser.printList(reversed3);
        // Print the reversed list: 1

    }

}




/*


How It Works:
Edge Cases:
If left == right, no reversal is needed (return head).
If list is empty or single node, return head.
Step 1: Reach the Left Position:
Traverse to the node at position left using current.
Keep prev pointing to the node at left-1 (or null if left=1).
Loop runs left-1 times to position current at the start of the sublist.
Step 2: Save Connection Points:
last = prev: Points to the node before the sublist (for reconnection).
newEnd = current: Points to the node at left, which will become the tail of the reversed sublist.
Step 3: Reverse the Sublist:
Reverse right - left + 1 nodes using three pointers (prev, current, next).
For each node:
Save next = current.next.
Set current.next = prev (reverse the link).
Move prev = current, current = next.
After reversal, prev is the new head of the reversed sublist, current is the node after right.
Step 4: Reconnect:
If last != null, set last.next = prev to connect the pre-sublist part to the reversed sublist.
If last == null (i.e., left=1), update head = prev.
Set newEnd.next = current to connect the reversed sublist’s tail to the remaining list.
Return: The head of the modified list.
Why Iterative?:
Matches your request for iteration (like the previous problem).
O(1) space complexity (excluding input), efficient for linked lists.
Straightforward pointer manipulation.
Example (for 1 -> 2 -> 3 -> 4 -> 5, left=2, right=4):
Step 1: Traverse to left=2:
prev = 1, current = 2.
Step 2: Save: last = 1, newEnd = 2.
Step 3: Reverse 2 -> 3 -> 4 (3 nodes, right - Integrative Review left + 1 = 4-2+1):
Initial: prev = 1, current = 2, next = 3.
Iter 1: next = 3, 2.next = 1, prev = 2, current = 3.
Iter 2: next = 4, 3.next = 2, prev = 3, current = 4.
Iter 3: next = 5, 4.next = 3, prev = 4, current = 5.
Reversed sublist: 4 -> 3 -> 2.
Step 4: Reconnect:
last.next = prev: 1.next = 4 (connects 1 -> 4).
newEnd.next = current: 2.next = 5 (connects 2 -> 5).
List: 1 -> 4 -> 3 -> 2 -> 5.
Return: head = 1.
 */