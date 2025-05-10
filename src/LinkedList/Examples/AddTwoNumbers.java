package LinkedList.Examples;

public class AddTwoNumbers {

    // Definition for singly-linked list
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    // Function to add two numbers represented as reversed linked lists
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Pointers to traverse both lists
        ListNode first = l1;

        ListNode second = l2;

        // Initialize carry to 0 for digit-wise addition
        int carry = 0;

        // Head and tail to build the result list
        ListNode head = null;

        ListNode tail = null;

        // Traverse both lists
        while (first != null || second != null || carry != 0) {

            int sum = carry;

            // Add value from first list if available
            if (first != null) {
               
                sum += first.val;

                first = first.next;
            }

            // Add value from second list if available
            if (second != null) {
                sum += second.val;
                second = second.next;
            }

            // Calculate new digit and new carry
            int digit = sum % 10;

            carry = sum / 10;

            // Create a new node for this digit
            ListNode newNode = new ListNode(digit);

            // If this is the first node, set head and tail to it
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                // Else attach it to the tail and move tail forward
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Return the head of the resulting list
        return head;
    }

    // Main function to test the addTwoNumbers method
    public static void main(String[] args) {

        AddTwoNumbers solution = new AddTwoNumbers();

        // Create first linked list: 2 -> 4 -> 3 (represents 342)
        ListNode l1 = solution.new ListNode(2);
        l1.next = solution.new ListNode(4);
        l1.next.next = solution.new ListNode(3);

        // Create second linked list: 5 -> 6 -> 4 (represents 465)
        ListNode l2 = solution.new ListNode(5);
        l2.next = solution.new ListNode(6);
        l2.next.next = solution.new ListNode(4);

        // Print input lists
        System.out.println("First Number:");
        printList(l1);

        System.out.println("Second Number:");
        printList(l2);

        // Add the two numbers
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print result
        System.out.println("Sum:");
        printList(result);

    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {

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
}