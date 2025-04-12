import LinkedList.Types.CircularLinkedList;
import LinkedList.Types.DoublyLinkedList;
import LinkedList.Types.SignlyLinkedList;

public class Main {
    public static void main(String[] args) {
     // Create a new singly linked list instance
           SignlyLinkedList list = new SignlyLinkedList();

          // Insert nodes at the beginning
           list.insertFirst(3);   // List: 3
           list.insertFirst(5);   // List: 5 -> 3
           list.insertFirst(7);   // List: 7 -> 5 -> 3
           list.insertFirst(12);  // List: 12 -> 7 -> 5 -> 3
           list.insertFirst(56);  // List: 56 -> 12 -> 7 -> 5 -> 3
           list.insertFirst(89);  // List: 89 -> 56 -> 12 -> 7 -> 5 -> 3
           list.insertFirst(45);  // List: 45 -> 89 -> 56 -> 12 -> 7 -> 5 -> 3

           // Insert a node at the end
           list.insertLast(99);   // List: 45 -> 89 -> 56 -> 12 -> 7 -> 5 -> 3 -> 99

                            // Insert a node at index 3 (0-based indexing)
                            list.insert(100, 3);   // List: 45 -> 89 -> 56 -> 100 -> 12 -> 7 -> 5 -> 3 -> 99

                            // Display the current list
                            list.display();        // Output: 45 -> 89 -> 56 -> 100 -> 12 -> 7 -> 5 -> 3 -> 99 -> END

                            // Delete the first node and print its value
                            System.out.println(list.deleteFirst()); // Output: 45
                            list.display();        // Output: 89 -> 56 -> 100 -> 12 -> 7 -> 5 -> 3 -> 99 -> END

                            // Delete the last node and print its value
                            System.out.println(list.deleteLast());  // Output: 99
                            list.display();        // Output: 89 -> 56 -> 100 -> 12 -> 7 -> 5 -> 3 -> END

                            // Delete node at index 4 and print its value
                            System.out.println(list.delete(4));     // Output: 7
                            list.display();        // Output: 89 -> 56 -> 100 -> 12 -> 5 -> 3 -> END

                            // Insert a node recursively at index 3
                            list.insertRec(7, 3);  // List: 89 -> 56 -> 100 -> 7 -> 12 -> 5 -> 3 -> END
                            list.display();        // Output: 89 -> 56 -> 100 -> 7 -> 12 -> 5 -> 3 -> END






         //Doubly LinkedList
        // Create a new doubly linked list instance
        DoublyLinkedList list1 = new DoublyLinkedList();

        // Insert elements at the beginning
        list1.insertFirst(3);  // List: 3
        list1.insertFirst(5);  // List: 5 -> 3
        list1.insertFirst(8);  // List: 8 -> 5 -> 3
        list1.insertFirst(9);  // List: 9 -> 8 -> 5 -> 3
        list1.insertFirst(18); // List: 18 -> 9 -> 8 -> 5 -> 3

        // Insert elements at the end
        list1.insertLast(99);  // List: 18 -> 9 -> 8 -> 5 -> 3 -> 99
        list1.insertLast(66);  // List: 18 -> 9 -> 8 -> 5 -> 3 -> 99 -> 66

        // Insert 65 after the first occurrence of 66
        list1.insert(66, 65);  // List: 18 -> 9 -> 8 -> 5 -> 3 -> 99 -> 66 -> 65

        // Display the list forward and backward
        list1.display();


        // Create a new circular linked list instance
        CircularLinkedList list2 = new CircularLinkedList();

        // Insert elements into the circular linked list
        list2.insert(23);  // List: 23 (circular: 23 -> 23)
        list2.insert(3);   // List: 23 -> 3 (circular: 3 -> 23)
        list2.insert(34);  // List: 23 -> 3 -> 34 (circular: 34 -> 23)
        list2.insert(67);  // List: 23 -> 3 -> 34 -> 67 (circular: 67 -> 23)
        list2.insert(98);  // List: 23 -> 3 -> 34 -> 67 -> 98 (circular: 98 -> 23)
        list2.insert(11);  // List: 23 -> 3 -> 34 -> 67 -> 98 -> 11 (circular: 11 -> 23)

        list2.display();

        list2.delete(98);
        // Display the circular linked list
        list2.display();





    }
}