package LinkedList.Examples;

public class CycleQuestion {
    // Inner class representing a node in the singly linked list (for standalone use)
    class ListNode {
        int val;              // Value stored in the node
        ListNode next;        // Reference to the next node

        // Constructor to initialize a node with a value
        ListNode(int x) {
            val = x;          // Set the value
            next = null;      // Next is null by default
        }
    }

    // Detect if the linked list has a cycle (LeetCode Problem 141)
    public boolean hasCycle(ListNode head) {
        // If list is empty or has one node, no cycle possible
        if (head == null || head.next == null) {
            return false;     // Return false as there’s no cycle
        }

        ListNode fast = head; // Fast pointer starts at head
        ListNode slow = head; // Slow pointer starts at head

        // Traverse the list with fast moving twice as fast as slow
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // Move fast pointer two steps
            slow = slow.next;      // Move slow pointer one step
            if (fast == slow) {    // If fast meets slow, a cycle exists
                return true;       // Return true indicating a cycle
            }
        }
        // If fast reaches the end (null), no cycle exists
        return false;              // Return false indicating no cycle
    }

    // Find the length of the cycle in the linked list, if one exists
    public int lengthCycle(ListNode head) {
        // If list is empty or has one node, no cycle possible
        if (head == null || head.next == null) {
            return 0;              // Return 0 as there’s no cycle
        }

        ListNode fast = head;      // Fast pointer starts at head
        ListNode slow = head;      // Slow pointer starts at head

        // Step 1: Detect cycle using Floyd’s algorithm
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // Move fast pointer two steps
            slow = slow.next;      // Move slow pointer one step
            if (fast == slow) {    // If fast meets slow, cycle detected
                // Step 2: Calculate the length of the cycle
                ListNode temp = slow; // Temporary pointer to traverse cycle
                int length = 0;       // Counter for cycle length
                do {
                    temp = temp.next; // Move temp one step around the cycle
                    length++;         // Increment length
                } while (temp != slow); // Continue until temp returns to slow
                return length;        // Return the cycle length
            }
        }
        // If fast reaches the end (null), no cycle exists
        return 0;                     // Return 0 indicating no cycle
    }










    // Main method to test the functionality (optional for LeetCode)
    public static void main(String[] args) {
        CycleQuestion cycle = new CycleQuestion();

        // Create a list with a cycle: 1 -> 2 -> 3 -> 4 -> 2 (cycle at 2)
        ListNode head = cycle.new ListNode(1);
        head.next = cycle.new ListNode(2);
        head.next.next = cycle.new ListNode(3);
        head.next.next.next = cycle.new ListNode(4);
        head.next.next.next.next = head.next; // Create cycle by linking 4 back to 2

        // Test hasCycle
        boolean hasCycle = cycle.hasCycle(head);
        System.out.println("Has Cycle: " + hasCycle); // Output: Has Cycle: true

        // Test lengthCycle
        int cycleLength = cycle.lengthCycle(head);
        System.out.println("Cycle Length: " + cycleLength); // Output: Cycle Length: 3

        // Test a list without a cycle: 1 -> 2 -> 3
        ListNode headNoCycle = cycle.new ListNode(1);
        headNoCycle.next = cycle.new ListNode(2);
        headNoCycle.next.next = cycle.new ListNode(3);

        boolean hasCycle2 = cycle.hasCycle(headNoCycle);
        System.out.println("Has Cycle (No Cycle List): " + hasCycle2); // Output: Has Cycle: false

        int cycleLength2 = cycle.lengthCycle(headNoCycle);
        System.out.println("Cycle Length (No Cycle List): " + cycleLength2); // Output: Cycle Length: 0
    }
}