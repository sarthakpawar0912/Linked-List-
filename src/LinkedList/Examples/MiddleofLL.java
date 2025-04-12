package LinkedList.Examples;

// Problem: https://leetcode.com/problems/middle-of-the-linked-list/
public class MiddleofLL {


    class ListNode {
        int val;              // Value stored in the node
        ListNode next;        // Reference to the next node

        // Constructor to initialize a node with a value
        ListNode(int x) {
            val = x;          // Set the value
            next = null;      // Next is null by default
        }
    }


    public ListNode middleNode(ListNode head) {
        ListNode s = head;  // Slow pointer
        ListNode f = head;  // Fast pointer

        // Move fast pointer twice as fast as slow pointer
        while (f != null && f.next != null) {
            s = s.next;      // Move one step
            f = f.next.next; // Move two steps
        }
        return s;  // Slow pointer will be at the middle
    }


    // Helper method to print the list from a given node
    private void printList(ListNode node) {
        ListNode current = node;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        MiddleofLL middleFinder = new MiddleofLL();

        // Test Case 1: List with odd length: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head1 = middleFinder.new ListNode(1);
        head1.next = middleFinder.new ListNode(2);
        head1.next.next = middleFinder.new ListNode(3);
        head1.next.next.next = middleFinder.new ListNode(4);
        head1.next.next.next.next = middleFinder.new ListNode(5);

        // Test Case 2: List with even length: 1 -> 2 -> 3 -> 4
        ListNode head2 = middleFinder.new ListNode(1);
        head2.next = middleFinder.new ListNode(2);
        head2.next.next = middleFinder.new ListNode(3);
        head2.next.next.next = middleFinder.new ListNode(4);

        // Test Case 3: Single node: 1
        ListNode head3 = middleFinder.new ListNode(1);

        // Find and print middle nodes
        System.out.println("Test 1 - List: 1 2 3 4 5");
        ListNode middle1 = middleFinder.middleNode(head1);
        System.out.print("Middle node onwards: ");
        middleFinder.printList(middle1);

        System.out.println("Test 2 - List: 1 2 3 4");
        ListNode middle2 = middleFinder.middleNode(head2);
        System.out.print("Middle node onwards: ");
        middleFinder.printList(middle2);

        System.out.println("Test 3 - List: 1");
        ListNode middle3 = middleFinder.middleNode(head3);
        System.out.print("Middle node onwards: ");
        middleFinder.printList(middle3);
    }

}