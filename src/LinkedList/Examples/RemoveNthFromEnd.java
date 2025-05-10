package LinkedList.Examples;
public class RemoveNthFromEnd {

    // Definition for singly-linked list
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Function to remove the nth node from end of the list
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Step 1: Find total length of the linked list
        int length = 0;
        ListNode temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // Step 2: If we need to remove the head node itself
        if (n == length) {
            return head.next;
        }

        // Step 3: Find the node just before the one to be deleted
        int target = length - n;
        ListNode current = head;

        for (int i = 1; i < target; i++) {
            current = current.next;
        }

        // Step 4: Skip the target node
        current.next = current.next.next;

        // Step 5: Return the head as the starting point of the list
        return head;
    }



        public static void main(String[] args) {
            RemoveNthFromEnd solution = new RemoveNthFromEnd();

            // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
            RemoveNthFromEnd.ListNode head = solution.new ListNode(1);
            head.next = solution.new ListNode(2);
            head.next.next = solution.new ListNode(3);
            head.next.next.next = solution.new ListNode(4);
            head.next.next.next.next = solution.new ListNode(5);

            // Print original list
            System.out.println("Original List:");
            printList(head);

            // Remove nth node from end (e.g., n = 2)
            int n = 2;
            head = solution.removeNthFromEnd(head, n);

            // Print modified list
            System.out.println("List after removing " + n + "th node from end:");
            printList(head);
        }

        // Helper function to print the linked list
        public static void printList(RemoveNthFromEnd.ListNode head) {
            RemoveNthFromEnd.ListNode current = head;
            while (current != null) {
                System.out.print(current.val);
                if (current.next != null) {
                    System.out.print(" -> ");
                }
                current = current.next;
            }
            System.out.println();
        }
    }
