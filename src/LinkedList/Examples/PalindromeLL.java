package LinkedList.Examples;

// Problem: https://leetcode.com/problems/palindrome-linked-list/
public class PalindromeLL {


    // Check if the linked list is a palindrome
    public boolean isPalindrome(ListNode head) {
        // If list is empty or has one node, it’s a palindrome
        if (head == null || head.next == null) {
            // Return true since no comparison is needed
            return true;
        }

        // Find the middle node of the list
        ListNode mid = middleNode(head);
        // 'mid' points to the middle node (second middle for even length)

        // Reverse the second half of the list
        ListNode headSecond = reverseList(mid);
        // 'headSecond' is the head of the reversed second half

        // Save the head of the second half to restore later (optional)
        ListNode rereverseHead = headSecond;
        // 'rereverseHead' will be used to restore the list

        // Pointers to compare first and second halves
        ListNode p1 = head;      // Points to start of first half
        ListNode p2 = headSecond; // Points to start of reversed second half

        // Compare both halves
        boolean isPalindrome = true; // Flag to track if it’s a palindrome

        while (p2 != null) {        // Only check until second half ends
            // If values don’t match, it’s not a palindrome
            if (p1.val != p2.val) {
                isPalindrome = false; // Set flag to false
                break;                // Exit loop on mismatch
            }
            // Move to next nodes in both halves
            p1 = p1.next;
            p2 = p2.next;
        }

        // Restore the list by reversing the second half back (optional)
        reverseList(rereverseHead);
        // This step is not required by LeetCode but preserves original list

        // Return whether the list is a palindrome
        return isPalindrome;

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

    // Main function to test the isPalindrome method
    public static void main(String[] args) {
        // Create an instance of PalindromeLL
        PalindromeLL checker = new PalindromeLL();
        // 'checker' is used to access methods and create ListNode instances

        // Test Case 1: Palindrome: 1 -> 2 -> 2 -> 1
        ListNode head1 = checker.new ListNode(1);
        // Create first node with value 1
        head1.next = checker.new ListNode(2);
        // Add node with value 2
        head1.next.next = checker.new ListNode(2);
        // Add node with value 2
        head1.next.next.next = checker.new ListNode(1);
        // Add node with value 1
        // List: 1 -> 2 -> 2 -> 1

        // Test Case 2: Not a palindrome: 1 -> 2 -> 3 -> 4
        ListNode head2 = checker.new ListNode(1);
        // Create first node with value 1
        head2.next = checker.new ListNode(2);
        // Add node with value 2
        head2.next.next = checker.new ListNode(3);
        // Add node with value 3
        head2.next.next.next = checker.new ListNode(4);
        // Add node with value 4
        // List: 1 -> 2 -> 3 -> 4

        // Test Case 3: Single node: 1
        ListNode head3 = checker.new ListNode(1);
        // Create a single node with value 1
        // List: 1

        // Test Case 4: Empty list
        ListNode head4 = null;
        // Initialize an empty list (null)
        // List: empty

        // Run Test Case 1
        System.out.println("Test Case 1: List: 1 -> 2 -> 2 -> 1");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        checker.printList(head1);
        // Print the input list: 1 -> 2 -> 2 -> 1
        boolean result1 = checker.isPalindrome(head1);
        // Check if it’s a palindrome
        System.out.println("Is Palindrome: " + result1);
        // Print result: true
        System.out.print("Restored List: ");
        // Label for restored list
        checker.printList(head1);
        // Print the restored list: 1 -> 2 -> 2 -> 1

        // Run Test Case 2
        System.out.println("\nTest Case 2: List: 1 -> 2 -> 3 -> 4");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        checker.printList(head2);
        // Print the input list: 1 -> 2 -> 3 -> 4
        boolean result2 = checker.isPalindrome(head2);
        // Check if it’s a palindrome
        System.out.println("Is Palindrome: " + result2);
        // Print result: false
        System.out.print("Restored List: ");
        // Label for restored list
        checker.printList(head2);
        // Print the restored list: 1 -> 2 -> 3 -> 4

        // Run Test Case 3
        System.out.println("\nTest Case 3: List: 1");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        checker.printList(head3);
        // Print the input list: 1
        boolean result3 = checker.isPalindrome(head3);
        // Check if it’s a palindrome
        System.out.println("Is Palindrome: " + result3);
        // Print result: true
        System.out.print("Restored List: ");
        // Label for restored list
        checker.printList(head3);
        // Print the restored list: 1

        // Run Test Case 4
        System.out.println("\nTest Case 4: Empty list");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        checker.printList(head4);
        // Print the input list: (empty)
        boolean result4 = checker.isPalindrome(head4);
        // Check if it’s a palindrome
        System.out.println("Is Palindrome: " + result4);
        // Print result: true
        System.out.print("Restored List: ");
        // Label for restored list
        checker.printList(head4);
        // Print the restored list: (empty)
    }
}

/*
How It Works:
Edge Case: If list is empty (head = null) or single node (head.next = null), return true.
Step 1: Find Middle:
Use middleNode to locate the middle (second middle for even length).
Step 2: Reverse Second Half:
Reverse the list starting from mid using reverseList.
headSecond points to the new head of the reversed second half.
Step 3: Compare Halves:
Use p1 (first half) and p2 (reversed second half).
Compare values node-by-node until p2 ends (second half is shorter or equal in length).
If any mismatch, set isPalindrome = false and break.
Step 4: Restore List (optional):
Reverse the second half back to restore the original list (not required by LeetCode).
Step 5: Return:
Return isPalindrome, indicating if the list is a palindrome.
Why This Approach?:
O(1) space (excluding the list itself), as it modifies the list in-place.
O(n) time by splitting, reversing, and comparing.
Restoring the list is a bonus for practical use.
Example (for 1 -> 2 -> 2 -> 1):
Middle: mid = 2 (second) (list splits as 1 -> 2 and 2 -> 1).
Reverse: headSecond = reverseList(2 -> 1) = 1 -> 2.
Compare: p1 = 1 -> 2, p2 = 1 -> 2:
1 == 1, 2 == 2, all match.
Restore: reverseList(1 -> 2) = 2 -> 1, list becomes 1 -> 2 -> 2 -> 1.
Return: true.
 */