package LinkedList.Examples;

// Problem: https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedListRecusrion {

    // Definition of ListNode class
    class ListNode {
        int val;          // Value stored in the node
        ListNode next;    // Reference to the next node

        public ListNode() {}

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Reverse the linked list using recursion
    public ListNode reverseList(ListNode node) {
        // Base case: if the list is empty or has only one node, return the node itself
        if (node == null || node.next == null) {
            return node; // This becomes the new head of the reversed list
        }

        // Recursive call: reverse the rest of the linked list starting from the next node
        ListNode newHead = reverseList(node.next);

        // At this point, the list from node.next to the end is already reversed

        // Reverse the current node's pointer
        node.next.next = node; // Make the next node point back to the current node (i.e., node)

        node.next = null; // Break the current node's original forward link to avoid cycles

        // Return the head of the reversed list (remains same for all recursion levels)
        return newHead;
    }

    // Helper method to print the linked list
    private void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    // Main function to test the reverseList method
    public static void main(String[] args) {
        ReverseLinkedListRecusrion reverser = new ReverseLinkedListRecusrion();

        // Test Case 1: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head1 = reverser.new ListNode(1);
        head1.next = reverser.new ListNode(2);
        head1.next.next = reverser.new ListNode(3);
        head1.next.next.next = reverser.new ListNode(4);
        head1.next.next.next.next = reverser.new ListNode(5);

        // Test Case 2: 1 -> 2
        ListNode head2 = reverser.new ListNode(1);
        head2.next = reverser.new ListNode(2);

        // Test Case 3: 1
        ListNode head3 = reverser.new ListNode(1);

        // Test Case 4: Empty list
        ListNode head4 = null;

        // Run Test Case 1
        System.out.println("Test Case 1: Multiple nodes");
        System.out.print("Input: ");
        reverser.printList(head1);
        ListNode reversed1 = reverser.reverseList(head1);
        System.out.print("Reversed: ");
        reverser.printList(reversed1);

        // Run Test Case 2
        System.out.println("\nTest Case 2: Two nodes");
        System.out.print("Input: ");
        reverser.printList(head2);
        ListNode reversed2 = reverser.reverseList(head2);
        System.out.print("Reversed: ");
        reverser.printList(reversed2);

        // Run Test Case 3
        System.out.println("\nTest Case 3: Single node");
        System.out.print("Input: ");
        reverser.printList(head3);
        ListNode reversed3 = reverser.reverseList(head3);
        System.out.print("Reversed: ");
        reverser.printList(reversed3);

        // Run Test Case 4
        System.out.println("\nTest Case 4: Empty list");
        System.out.print("Input: ");
        reverser.printList(head4);
        ListNode reversed4 = reverser.reverseList(head4);
        System.out.print("Reversed: ");
        reverser.printList(reversed4);
    }
}
