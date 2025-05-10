package LinkedList.Examples;

public class MergeTwoSortedLL {

    private Node head;    // Points to the first node in the list
    private Node tail;    // Points to the last node in the list
    private int size;     // Tracks the number of nodes in the list

    // Constructor to initialize an empty list
    public MergeTwoSortedLL() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    // Insert a node at the beginning of the list
    public void insertFirst(int val) {

        Node node = new Node(val);

        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    // Insert a node at the end of the list
    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    // Insert a node at a specific index
    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    // Display the list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // Static method to merge two sorted linked lists
    public static MergeTwoSortedLL mergeTwoSortedLL(MergeTwoSortedLL first, MergeTwoSortedLL second) {
        Node f = first.head;
        Node s = second.head;

        MergeTwoSortedLL result = new MergeTwoSortedLL();
        while (f != null && s != null) {
            if (f.value < s.value) {
                result.insertLast(f.value);
                f = f.next;
            } else {
                result.insertLast(s.value);
                s = s.next;
            }
        }

        while (f != null) {
            result.insertLast(f.value);
            f = f.next;
        }

        while (s != null) {
            result.insertLast(s.value);
            s = s.next;
        }

        return result;
    }

    // Inner class for list nodes
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create first sorted linked list
        MergeTwoSortedLL list1 = new MergeTwoSortedLL();
        list1.insertLast(1);
        list1.insertLast(3);
        list1.insertLast(3);
        list1.insertLast(3);
        list1.insertLast(3);
        list1.insertLast(5);

        // Create second sorted linked list
        MergeTwoSortedLL list2 = new MergeTwoSortedLL();
        list2.insertLast(2);
        list2.insertLast(4);
        list2.insertLast(4);
        list2.insertLast(6);
        list2.insertLast(6);

        list1.display();
        list2.display();
        // Merge both lists
        MergeTwoSortedLL mergedList = MergeTwoSortedLL.mergeTwoSortedLL(list1, list2);

        // Display result
        System.out.println("Merged Linked List:");
        mergedList.display();
    }
}
