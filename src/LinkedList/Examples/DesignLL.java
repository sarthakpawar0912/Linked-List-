package LinkedList.Examples;

//https://leetcode.com/problems/design-linked-list/description/

class ListNode {

    int val;  // Value of the node
    ListNode next;  // Reference to the next node

    ListNode(int x) {
        val = x;  // Initialize the value of the node
        next = null;  // Initially, the next node is null
    }
}

class MyLinkedList {

    ListNode head;  // The head of the linked list (dummy node)
    int size;  // The size of the linked list

    // Constructor to initialize the linked list
    MyLinkedList() {
        head = new ListNode(0);  // Create a dummy head node to simplify the logic
        size = 0;  // Initially, the list is empty
    }

    // Get the value of the node at the specified index
    public int get(int index) {
        // Return -1 if the index is invalid (out of bounds)
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode curr = head;  // Start from the head (dummy node)

        // Traverse to the index-th node
        for (int i = 0; i <= index; i++) {
            curr = curr.next;  // Move to the next node
        }
        return curr.val;  // Return the value of the node at the specified index
    }

    // Add a node at the head of the linked list
    public void addAtHead(int val) {
        addAtIndex(0, val);  // Add the new node at index 0 (head)
    }

    // Add a node at the tail of the linked list
    public void addAtTail(int val) {
        addAtIndex(size, val);  // Add the new node at the end (size-th index)
    }

    // Add a node at a specific index
    public void addAtIndex(int index, int val) {
        // If the index is out of bounds, do nothing
        if (index < 0 || index > size) {
            return;
        }

        ListNode curr = head;  // Start from the head (dummy node)
        size++;  // Increment the size of the list

        // Traverse to the node just before the desired index
        for (int i = 0; i < index; i++) {
            curr = curr.next;  // Move to the next node
        }

        // Create the new node with the given value
        ListNode newNode = new ListNode(val);
        newNode.next = curr.next;  // Set the new node's next to the current node's next
        curr.next = newNode;  // Link the current node to the new node
    }

    // Delete the node at the specified index
    public void deleteAtIndex(int index) {
        // If the index is out of bounds, do nothing
        if (index < 0 || index >= size) {
            return;
        }

        ListNode curr = head;  // Start from the head (dummy node)
        size--;  // Decrease the size of the list

        // Traverse to the node just before the node to be deleted
        for (int i = 0; i < index; i++) {
            curr = curr.next;  // Move to the next node
        }

        // Skip the node to be deleted
        curr.next = curr.next.next;  // Link the current node to the node after the one to be deleted
    }
}

public class DesignLL {

    public static void main(String[] args) {
        // Create a new MyLinkedList object
        MyLinkedList myLinkedList = new MyLinkedList();

        // Add nodes to the list
        myLinkedList.addAtHead(1);  // Linked list becomes: 1
        myLinkedList.addAtTail(3);  // Linked list becomes: 1 -> 3
        myLinkedList.addAtIndex(1, 2);  // Linked list becomes: 1 -> 2 -> 3
        System.out.println(myLinkedList.get(1));  // Expected output: 2 (node at index 1)

        // Delete a node at index 1
        myLinkedList.deleteAtIndex(1);  // Linked list becomes: 1 -> 3
        System.out.println(myLinkedList.get(1));  // Expected output: 3 (node at index 1)
    }
}

