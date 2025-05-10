package LinkedList.Examples;

//problem:142:https://leetcode.com/problems/linked-list-cycle-ii/
public class detectCycle {


    class ListNode {
        int val;              // Value stored in the node
        ListNode next;        // Reference to the next node

        // Constructor to initialize a node with a value
        ListNode(int x) {
            val = x;          // Set the value
            next = null;      // Next is null by default
        }
    }


//    public int lengthCycle(ListNode head) {
//        // If list is empty or has one node, no cycle possible
//        if (head == null || head.next == null) {
//            return 0;              // Return 0 as there’s no cycle
//        }
//
//        ListNode fast = head;      // Fast pointer starts at head
//        ListNode slow = head;      // Slow pointer starts at head
//
//        // Step 1: Detect cycle using Floyd’s algorithm
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next; // Move fast pointer two steps
//            slow = slow.next;      // Move slow pointer one step
//            if (fast == slow) {    // If fast meets slow, cycle detected
//                // Step 2: Calculate the length of the cycle
//                ListNode temp = slow; // Temporary pointer to traverse cycle
//                int length = 0;       // Counter for cycle length
//                do {
//                    temp = temp.next; // Move temp one step around the cycle
//                    length++;         // Increment length
//                } while (temp != slow); // Continue until temp returns to slow
//                return length;        // Return the cycle length
//            }
//        }
//        // If fast reaches the end (null), no cycle exists
//        return 0;                     // Return 0 indicating no cycle
//    }


    public ListNode detectCycle(ListNode head) {
        int length = 0;
        ListNode fast = head; // Fast pointer starts at head
        ListNode slow = head; // Slow pointer starts at head

        // Traverse the list with fast moving twice as fast as slow
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // Move fast pointer two steps
            slow = slow.next;      // Move slow pointer one step
            if (fast == slow) {    // If fast meets slow, a cycle exists
             //   length = lengthCycle(slow);
                break;// Return true indicating a cycle
            }
        }

        if(length==0){
            return null;
        }



        // find start node
        ListNode f = head;
        ListNode s = head;

        while (length > 0) {
            s = s.next;
            length--;
        }
        //keep moving both forward
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return s;

    }


    public static void main(String[] args) {

        detectCycle cycle = new detectCycle();

        // Create a list with a cycle: 1 -> 2 -> 3 -> 4 -> 2 (cycle at 2)
        ListNode head = cycle.new ListNode(1);
        head.next = cycle.new ListNode(2);
        head.next.next = cycle.new ListNode(3);
        head.next.next.next = cycle.new ListNode(4);
        head.next.next.next.next = head.next; // Create cycle by linking 4 back to 2
    }

}