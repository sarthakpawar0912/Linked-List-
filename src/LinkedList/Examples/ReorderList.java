package LinkedList.Examples;

// Problem: https://leetcode.com/problems/reorder-list/
public class ReorderList {


    // Reorder the linked list: L0 -> Ln -> L1 -> Ln-1 -> ...
    public void reorderList(ListNode head) {
        // If list is empty or has one node, no reordering needed
        if (head == null || head.next == null) {
            // Return as is
            return;
        }


        // Step 1: Find the middle node of the list
        ListNode mid = middleNode(head);
        // 'mid' points to the second half’s starting node

        // Step 2: Reverse the second half of the list
        ListNode secondHalf = reverseList(mid);
        // 'secondHalf' is the head of the reversed second half

        // Step 3: Split the list into two halves
        ListNode firstHalf = head;    // Points to the first half
        ListNode temp = head;         // Temporary pointer to find the end of first half
        while (temp.next != mid) {    // Move to node before mid
            temp = temp.next;
        }
        temp.next = null;             // Disconnect first half from second half


        // Step 4: Merge the first and reversed second halves alternately
        while (firstHalf != null && secondHalf != null) {
            // Save next node of first half
            ListNode tempFirst = firstHalf.next;
            // Connect first half node to second half node
            firstHalf.next = secondHalf;
            // Move first half pointer
            firstHalf = tempFirst;

            // Save next node of second half (if first half moved)
            if (firstHalf != null) {
                ListNode tempSecond = secondHalf.next;
                // Connect second half node to next first half node
                secondHalf.next = firstHalf;
                // Move second half pointer
                secondHalf = tempSecond;
            }
        }


        // Step 5: Ensure the tail’s next is null (if any nodes remain)
        if (firstHalf != null) {
            firstHalf.next = null;  // Terminate list if first half has extra node
        }
        // Note: secondHalf being non-null is handled naturally by the merge
    }


    // Find the middle node of the list using slow and fast pointers
    public ListNode middleNode(ListNode head) {
        // Initialize slow pointer to head
        ListNode slow = head;
        // 'slow' moves one step at a time

        // Initialize fast pointer to head
        ListNode fast = head;
        // 'fast' moves two steps at a time


        // Move pointers until fast reaches the end
        while (fast != null && fast.next != null) {
            // Move slow one step
            slow = slow.next;
            // Move fast two steps
            fast = fast.next.next;
        }

        // Return the slow pointer, which is at the middle
        return slow;
        // For odd length, it’s the middle; for even, it’s the second middle
    }



    // Reverse the linked list iteratively
    public ListNode reverseList(ListNode head) {
        // Initialize previous node as null (will become the new tail)
        ListNode prev = null;
        // 'prev' tracks the node that will be the next node’s predecessor

        // Initialize current node as head (start of the list)
        ListNode current = head;
        // 'current' is the node we’re processing

        // Continue until we reach the end of the list
        while (current != null) {
            // Store the next node to avoid losing it
            ListNode next = current.next;
            // 'next' saves the reference to the rest of the list

            // Reverse the link: point current’s next to previous
            current.next = prev;
            // This flips the direction (e.g., 1->2 becomes 1->null)

            // Move prev to current (current becomes the new previous)
            prev = current;
            // 'prev' advances to prepare for the next iteration

            // Move current to next (process the next node)
            current = next;
            // 'current' moves forward to continue reversal
        }

        // After loop, prev is the new head of the reversed list
        return prev;
        // Return the head of the reversed list (original tail)
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


    // Main function to test the reorderList method
    public static void main(String[] args) {
        // Create an instance of ReorderList
        ReorderList reorderer = new ReorderList();
        // 'reorderer' is used to access methods and create ListNode instances

        // Test Case 1: List: 1 -> 2 -> 3 -> 4
        ListNode head1 = reorderer.new ListNode(1);
        // Create first node with value 1
        head1.next = reorderer.new ListNode(2);
        // Add node with value 2
        head1.next.next = reorderer.new ListNode(3);
        // Add node with value 3
        head1.next.next.next = reorderer.new ListNode(4);
        // Add node with value 4
        // List: 1 -> 2 -> 3 -> 4


        // Test Case 2: List: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head2 = reorderer.new ListNode(1);
        // Create first node with value 1
        head2.next = reorderer.new ListNode(2);
        // Add node with value 2
        head2.next.next = reorderer.new ListNode(3);
        // Add node with value 3
        head2.next.next.next = reorderer.new ListNode(4);
        // Add node with value 4
        head2.next.next.next.next = reorderer.new ListNode(5);
        // Add node with value 5
        // List: 1 -> 2 -> 3 -> 4 -> 5

        // Test Case 3: Single node: 1
        ListNode head3 = reorderer.new ListNode(1);
        // Create a single node with value 1
        // List: 1

        // Test Case 4: List: 1 -> 2
        ListNode head4 = reorderer.new ListNode(1);
        // Create first node with value 1
        head4.next = reorderer.new ListNode(2);
        // Add node with value 2
        // List: 1 -> 2

        // Run Test Case 1
        System.out.println("Test Case 1: List: 1 -> 2 -> 3 -> 4");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        reorderer.printList(head1);
        // Print the input list: 1 -> 2 -> 3 -> 4
        reorderer.reorderList(head1);
        // Reorder the list
        System.out.print("Reordered: ");
        // Label for reordered list
        reorderer.printList(head1);
        // Print the reordered list: 1 -> 4 -> 2 -> 3

        // Run Test Case 2
        System.out.println("\nTest Case 2: List: 1 -> 2 -> 3 -> 4 -> 5");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        reorderer.printList(head2);
        // Print the input list: 1 -> 2 -> 3 -> 4 -> 5
        reorderer.reorderList(head2);
        // Reorder the list
        System.out.print("Reordered: ");
        // Label for reordered list
        reorderer.printList(head2);
        // Print the reordered list: 1 -> 5 -> 2 -> 4 -> 3

        // Run Test Case 3
        System.out.println("\nTest Case 3: List: 1");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        reorderer.printList(head3);
        // Print the input list: 1
        reorderer.reorderList(head3);
        // Reorder the list
        System.out.print("Reordered: ");
        // Label for reordered list
        reorderer.printList(head3);
        // Print the reordered list: 1

        // Run Test Case 4
        System.out.println("\nTest Case 4: List: 1 -> 2");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        reorderer.printList(head4);
        // Print the input list: 1 -> 2
        reorderer.reorderList(head4);
        // Reorder the list
        System.out.print("Reordered: ");
        // Label for reordered list
        reorderer.printList(head4);
        // Print the reordered list: 1 -> 2
    }
}


/*
How It Works:
Edge Case: If empty or single node, return.
Step 1: Find Middle: Use middleNode to find the second half’s start.
Step 2: Reverse Second Half: Reverse from mid using reverseList.
Step 3: Split: Disconnect first half from second half by setting the node before mid’s next to null.
Step 4: Merge:
Use firstHalf and secondHalf pointers.
Alternate connections: firstHalf -> secondHalf -> nextFirstHalf -> nextSecondHalf.
Continue until one half is exhausted.
Step 5: Terminate: If firstHalf has an extra node (odd length), set its next to null.
Example (for 1 -> 2 -> 3 -> 4):
Middle: mid = 3 (second half: 3 -> 4).
Reverse: secondHalf = 4 -> 3.
Split: 1 -> 2 -> null, 4 -> 3.
Merge:
firstHalf = 1, secondHalf = 4.
1.next = 4, firstHalf = 2.
4.next = 2, secondHalf = 3.
2.next = 3, firstHalf = null, secondHalf = null.
Result: 1 -> 4 -> 2 -> 3.
 */