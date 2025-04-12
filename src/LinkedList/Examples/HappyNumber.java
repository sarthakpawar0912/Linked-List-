package LinkedList.Examples;

// Problem: Detect if a linked list has a cycle
public class HappyNumber {

    // Definition for singly-linked list node
    class ListNode {
        int val;          // Value stored in the node
        ListNode next;    // Reference to the next node

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Method to detect cycle in linked list using Floyd's algorithm
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;  // No cycle possible with 0 or 1 node
        }

        ListNode slow = head;  // Tortoise - moves one step
        ListNode fast = head;  // Hare - moves two steps

        // Traverse the list
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move one step
            fast = fast.next.next;     // Move two steps
            if (slow == fast) {        // If they meet, there's a cycle
                return true;
            }
        }

        return false;  // No cycle found if fast reaches end
    }

    // Main function to test cycle detection
    public static void main(String[] args) {
        HappyNumber cycleDetector = new HappyNumber();

        // Test Case 1: Create a list with a cycle: 1 -> 2 -> 3 -> 4 -> 2
        ListNode head1 = cycleDetector.new ListNode(1);
        head1.next = cycleDetector.new ListNode(2);
        head1.next.next = cycleDetector.new ListNode(3);
        head1.next.next.next = cycleDetector.new ListNode(4);
        head1.next.next.next.next = head1.next; // Create cycle by linking 4 back to 2

        // Test Case 2: Create a list without a cycle: 1 -> 2 -> 3 -> 4
        ListNode head2 = cycleDetector.new ListNode(1);
        head2.next = cycleDetector.new ListNode(2);
        head2.next.next = cycleDetector.new ListNode(3);
        head2.next.next.next = cycleDetector.new ListNode(4);

        // Test Case 3: Single node
        ListNode head3 = cycleDetector.new ListNode(1);

        // Test Case 4: Empty list
        ListNode head4 = null;

        // Run tests
        System.out.println("Test 1 (has cycle): " + cycleDetector.hasCycle(head1));
        System.out.println("Test 2 (no cycle): " + cycleDetector.hasCycle(head2));
        System.out.println("Test 3 (single node): " + cycleDetector.hasCycle(head3));
        System.out.println("Test 4 (empty list): " + cycleDetector.hasCycle(head4));
    }
}