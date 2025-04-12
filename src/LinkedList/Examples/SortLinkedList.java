package LinkedList.Examples;

// Problem: https://leetcode.com/problems/sort-list/description/
public class SortLinkedList {


    // Sort the linked list using merge sort
    public ListNode sortList(ListNode head) {
        // Check if the list is empty or has only one node
        if (head == null || head.next == null) {
            // If true, the list is already sorted, return as is
            return head;
        }

        // Find the middle node to split the list into two halves
        ListNode mid = getMid(head);
        // 'mid' now points to the start of the second half, and the list is split

        // Recursively sort the left half (from head to before mid)
        ListNode left = sortList(head);
        // 'left' is the sorted left half

        // Recursively sort the right half (from mid)
        ListNode right = sortList(mid);
        // 'right' is the sorted right half

        // Merge the two sorted halves into one sorted list
        return merge(left, right);
        // Return the head of the merged sorted list
    }


    // Merge two sorted lists into a single sorted list
    ListNode merge(ListNode list1, ListNode list2) {
        // Create a dummy node to serve as the head of the merged list
        ListNode dummyHead = new ListNode();
        // 'dummyHead' simplifies list construction by avoiding edge cases

        // Initialize tail to point to dummyHead for building the merged list
        ListNode tail = dummyHead;
        // 'tail' keeps track of the last node in the merged list

        // Continue while both lists have nodes
        while (list1 != null && list2 != null) {
            // Compare values of the current nodes in list1 and list2
            if (list1.val < list2.val) {
                // If list1's value is smaller, append list1's node to the merged list
                tail.next = list1;
                // Move to the next node in list1
                list1 = list1.next;
                // Update tail to the newly added node
                tail = tail.next;
            } else {
                // If list2's value is smaller or equal, append list2's node
                tail.next = list2;
                // Move to the next node in list2
                list2 = list2.next;
                // Update tail to the newly added node
                tail = tail.next;
            }
        }

        // If list1 has remaining nodes, append them
        // If list2 has remaining nodes, append them instead
        tail.next = (list1 != null) ? list1 : list2;
        // This handles any leftover nodes from either list

        // Return the head of the merged list (skip the dummy node)
        return dummyHead.next;
    }


    // Find the middle node and split the list into two halves
    ListNode getMid(ListNode head) {
        // Initialize midPrev to null (will track the node before the middle)
        ListNode midPrev = null;
        // 'midPrev' helps in splitting the list later

        // Continue while head and head.next are not null
        while (head != null && head.next != null) {
            // Move midPrev one step: first to head, then to next node
            midPrev = (midPrev == null) ? head : midPrev.next;
            // Move head two steps (fast pointer)
            head = head.next.next;
            // This ensures midPrev reaches the node before the middle
        }

        // Set mid to the start of the second half
        ListNode mid = midPrev.next;
        // 'mid' points to the middle node (or second middle for even length)

        // Split the list by setting midPrev.next to null
        midPrev.next = null;
        // This breaks the link, creating two separate lists

        // Return the head of the second half
        return mid;
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


    // Main function to test the sorting
    public static void main(String[] args) {

        // Create an instance of SortLinkedList
        SortLinkedList sorter = new SortLinkedList();
        // 'sorter' is used to access methods and create ListNode instances

        // Test Case 1: Unsorted list: 4 -> 2 -> 1 -> 3
        ListNode head1 = sorter.new ListNode(4);
        // Create first node with value 4
        head1.next = sorter.new ListNode(2);
        // Add node with value 2
        head1.next.next = sorter.new ListNode(1);
        // Add node with value 1
        head1.next.next.next = sorter.new ListNode(3);
        // Add node with value 3
        // List: 4 -> 2 -> 1 -> 3


        // Test Case 2: Unsorted list with negatives: -1 -> 5 -> 3 -> 4 -> 0
        ListNode head2 = sorter.new ListNode(-1);
        // Create first node with value -1
        head2.next = sorter.new ListNode(5);
        // Add node with value 5
        head2.next.next = sorter.new ListNode(3);
        // Add node with value 3
        head2.next.next.next = sorter.new ListNode(4);
        // Add node with value 4
        head2.next.next.next.next = sorter.new ListNode(0);
        // Add node with value 0
        // List: -1 -> 5 -> 3 -> 4 -> 0


        // Test Case 3: Single node: 1
        ListNode head3 = sorter.new ListNode(1);
        // Create a single node with value 1
        // List: 1


        // Test Case 4: Empty list
        ListNode head4 = null;
        // Initialize an empty list (null)
        // List: empty

        // Run Test Case 1
        System.out.println("Test Case 1: Unsorted list");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        sorter.printList(head1);
        // Print the input list: 4 -> 2 -> 1 -> 3
        ListNode sorted1 = sorter.sortList(head1);
        // Sort the list and store result
        System.out.print("Sorted: ");
        // Label for sorted list
        sorter.printList(sorted1);
        // Print the sorted list: 1 -> 2 -> 3 -> 4

        // Run Test Case 2
        System.out.println("\nTest Case 2: Unsorted list with negatives");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        sorter.printList(head2);
        // Print the input list: -1 -> 5 -> 3 -> 4 -> 0
        ListNode sorted2 = sorter.sortList(head2);
        // Sort the list and store result
        System.out.print("Sorted: ");
        // Label for sorted list
        sorter.printList(sorted2);
        // Print the sorted list: -1 -> 0 -> 3 -> 4 -> 5

        // Run Test Case 3
        System.out.println("\nTest Case 3: Single node");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        sorter.printList(head3);
        // Print the input list: 1
        ListNode sorted3 = sorter.sortList(head3);
        // Sort the list and store result
        System.out.print("Sorted: ");
        // Label for sorted list
        sorter.printList(sorted3);
        // Print the sorted list: 1

        // Run Test Case 4
        System.out.println("\nTest Case 4: Empty list");
        // Print test case description
        System.out.print("Input: ");
        // Label for input list
        sorter.printList(head4);
        // Print the input list: (empty)
        ListNode sorted4 = sorter.sortList(head4);
        // Sort the list and store result
        System.out.print("Sorted: ");
        // Label for sorted list
        sorter.printList(sorted4);
        // Print the sorted list: (empty)
    }
}