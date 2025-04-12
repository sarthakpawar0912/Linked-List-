package LinkedList.Examples;

// Problem: https://leetcode.com/problems/reverse-linked-list/
public class ReverseLLUsingIteration {


    // Reverse the linked list using iteration
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

            // Reverse the link: point current node’s next to previous
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


    // Main function to test the reverseList method
    public static void main(String[] args) {
        // Create an instance of ReverseLLUsingIteration
        ReverseLLUsingIteration reverser = new ReverseLLUsingIteration();
        // 'reverser' is used to access methods and create ListNode instances

        // Test Case 1: List with multiple nodes: 1 -> 2 -> 3 -> 4 -> 5
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


        // Test Case 2: List with two nodes: 1 -> 2
        ListNode head2 = reverser.new ListNode(1);
        // Create first node with value 1
        head2.next = reverser.new ListNode(2);
        // Add node with value 2
        // List: 1 -> 2

        // Test Case 3: Single node: 1
        ListNode head3 = reverser.new ListNode(1);
        // Create a single node with value 1
        // List: 1

        // Test Case 4: Empty list
        ListNode head4 = null;
        // Initialize an empty list (null)
        // List: empty

        // Run Test Case 1
        System.out.println("Test Case 1: Multiple nodes");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        reverser.printList(head1);
        // Print the input list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode reversed1 = reverser.reverseList(head1);
        // Reverse the list and store result
        System.out.print("Reversed: ");
        // Label for reversed list
        reverser.printList(reversed1);
        // Print the reversed list: 5 -> 4 -> 3 -> 2 -> 1

        // Run Test Case 2
        System.out.println("\nTest Case 2: Two nodes");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        reverser.printList(head2);
        // Print the input list: 1 -> 2
        ListNode reversed2 = reverser.reverseList(head2);
        // Reverse the list and store result
        System.out.print("Reversed: ");
        // Label for reversed list
        reverser.printList(reversed2);
        // Print the reversed list: 2 -> 1

        // Run Test Case 3
        System.out.println("\nTest Case 3: Single node");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        reverser.printList(head3);
        // Print the input list: 1
        ListNode reversed3 = reverser.reverseList(head3);
        // Reverse the list and store result
        System.out.print("Reversed: ");
        // Label for reversed list
        reverser.printList(reversed3);
        // Print the reversed list: 1

        // Run Test Case 4
        System.out.println("\nTest Case 4: Empty list");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        reverser.printList(head4);
        // Print the input list: (empty)
        ListNode reversed4 = reverser.reverseList(head4);
        // Reverse the list and store result
        System.out.print("Reversed: ");
        // Label for reversed list
        reverser.printList(reversed4);
        // Print the reversed list: (empty)
    }
}

/*Let’s create a complete solution for reversing a singly-linked list using an iterative approach, addressing the LeetCode #206 - Reverse Linked List problem (https://leetcode.com/problems/reverse-linked-list/). Your provided code has a good start but contains several issues:

It assumes class-level fields head, size, and a return type of void, which doesn’t align with the standard problem requirement (returning the new ListNode head).
The method name reverse() lacks a parameter, and head is not defined.
The check size < 2 is unnecessary since we can directly check the list’s structure.
It lacks a complete class structure, ListNode definition, and a main function for testing.
I’ll fix these issues, provide a correct iterative implementation, and include detailed comments explaining each line. The solution will be a single file with a clear structure, including a main function with test cases to demonstrate the reversal process.

Problem Overview
Problem: Reverse a singly-linked list.
Input: Head of a linked list (e.g., 1 -> 2 -> 3 -> 4 -> 5).
Output: Head of the reversed list (e.g., 5 -> 4 -> 3 -> 2 -> 1).
Constraints:
The list may be empty.
Number of nodes: [0, 5000].
Node values: [-5000, 5000].
Approach: Use iteration to reverse the list by adjusting next pointers, keeping track of previous, current, and next nodes.
Complete Code with Iterative Solution
Below is the complete file with an iterative solution, detailed comments for every line, and a main function with test cases to make the reversal process easy to understand.

java

Collapse

Wrap

Copy
package LinkedList.Examples;

// Problem: https://leetcode.com/problems/reverse-linked-list/
public class ReverseLLUsingIteration {

    // Reverse the linked list using iteration
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

            // Reverse the link: point current node’s next to previous
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

    // Main function to test the reverseList method
    public static void main(String[] args) {
        // Create an instance of ReverseLLUsingIteration
        ReverseLLUsingIteration reverser = new ReverseLLUsingIteration();
        // 'reverser' is used to access methods and create ListNode instances

        // Test Case 1: List with multiple nodes: 1 -> 2 -> 3 -> 4 -> 5
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

        // Test Case 2: List with two nodes: 1 -> 2
        ListNode head2 = reverser.new ListNode(1);
        // Create first node with value 1
        head2.next = reverser.new ListNode(2);
        // Add node with value 2
        // List: 1 -> 2

        // Test Case 3: Single node: 1
        ListNode head3 = reverser.new ListNode(1);
        // Create a single node with value 1
        // List: 1

        // Test Case 4: Empty list
        ListNode head4 = null;
        // Initialize an empty list (null)
        // List: empty

        // Run Test Case 1
        System.out.println("Test Case 1: Multiple nodes");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        reverser.printList(head1);
        // Print the input list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode reversed1 = reverser.reverseList(head1);
        // Reverse the list and store result
        System.out.print("Reversed: ");
        // Label for reversed list
        reverser.printList(reversed1);
        // Print the reversed list: 5 -> 4 -> 3 -> 2 -> 1

        // Run Test Case 2
        System.out.println("\nTest Case 2: Two nodes");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        reverser.printList(head2);
        // Print the input list: 1 -> 2
        ListNode reversed2 = reverser.reverseList(head2);
        // Reverse the list and store result
        System.out.print("Reversed: ");
        // Label for reversed list
        reverser.printList(reversed2);
        // Print the reversed list: 2 -> 1

        // Run Test Case 3
        System.out.println("\nTest Case 3: Single node");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        reverser.printList(head3);
        // Print the input list: 1
        ListNode reversed3 = reverser.reverseList(head3);
        // Reverse the list and store result
        System.out.print("Reversed: ");
        // Label for reversed list
        reverser.printList(reversed3);
        // Print the reversed list: 1

        // Run Test Case 4
        System.out.println("\nTest Case 4: Empty list");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        reverser.printList(head4);
        // Print the input list: (empty)
        ListNode reversed4 = reverser.reverseList(head4);
        // Reverse the list and store result
        System.out.print("Reversed: ");
        // Label for reversed list
        reverser.printList(reversed4);
        // Print the reversed list: (empty)
    }
}
Detailed Explanation of Each Component
ListNode Class
java

Collapse

Wrap

Copy
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
Purpose: Defines the structure of a linked list node.
Fields:
val: Stores an integer value (e.g., 1, 2, etc.).
next: Points to the next node or null if it’s the last node.
Constructors:
No-arg: Creates a dummy node (val = 0, next = null). Not used here but included for completeness.
With value: Creates a node with a specified value and next = null.
Role: Forms the linked list chain (e.g., 1 -> 2 -> 3).
reverseList(ListNode head)
java

Collapse

Wrap

Copy
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

        // Reverse the link: point current node’s next to previous
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
Purpose: Reverses the linked list iteratively and returns the new head.
How It Works:
Uses three pointers:
prev: Points to the previous node (starts as null, becomes the new tail).
current: The node being processed (starts at head).
next: Saves the next node to avoid losing the list.
Loop:
Save current.next in next.
Reverse the link: Set current.next = prev.
Advance pointers: prev = current, current = next.
End: When current becomes null, prev is the new head (original last node).
Edge Cases:
Empty list (head = null): Returns null.
Single node (head.next = null): Loop runs once, returns head.
Why Iterative?:
Avoids recursion stack overhead (O(1) space vs. O(n) for recursive).
Straightforward: Processes nodes sequentially, flipping links.
Example (for 1 -> 2 -> 3):
Initial: prev = null, current = 1, next = 2.
Iteration 1:
next = 2.
1.next = null (was 2).
prev = 1, current = 2, next = 3.
List: 1 -> null, 2 -> 3.
Iteration 2:
next = 3.
2.next = 1 (was 3).
prev = 2, current = 3, next = null.
List: 2 -> 1 -> null, 3.
Iteration 3:
next = null.
3.next = 2 (was null).
prev = 3, current = null.
List: 3 -> 2 -> 1 -> null.
Return prev = 3 (head of 3 -> 2 -> 1).*/