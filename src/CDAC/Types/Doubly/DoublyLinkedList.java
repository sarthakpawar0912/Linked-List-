package CDAC.Types.Doubly;


import java.util.Scanner;


class DoublyList {

    //node is static member class of Doubly  list
    static class Node {

        int data;
      Node next;
        Node prev;

        public Node() {
            data = 0;
            next=null;
            prev=null;
        }

        public Node(int val) {
            data = val;
            next=null;
            prev=null;
        }
    }

    //list class fields
    private Node head;

    //list class methods
    public DoublyList(){
        head=null;
    }


    void displayForward(){

        System.out.println("Displaying the Forward  list:");

        if (head == null) {

            System.out.println("List is empty");

        }
        else {

            Node trav = head;
            while (trav != null) {
                System.out.print(trav.data + " -> ");
                trav = trav.next;
            }
            System.out.println("null");

        }
    }

    void displayReverse(){

        System.out.println("Displaying the Reverse list:");

        if (head == null) {

            System.out.println("List is empty");

        }
        else {

            Node trav = head;
            while (trav.next != null) {
                trav = trav.next;
            }

            while (trav != null) {
                System.out.print(trav.data + " -> ");
                trav = trav.prev;
            }
            System.out.println("null");

        }
    }





}















public class DoublyLinkedList {
    public class SinglyLinkedList {

        public static void main(String[] args) {

            int choice,val,pos;

        DoublyList list=new DoublyList();

            Scanner sc = new Scanner(System.in);

            do{
                System.out.println("\n\n0--->Exit \n1--->Forward Display\n 2--->Reverse Display\n3--->Add First\n4--->Add Last\n5--->Add at a Pos\n6--->Delete First\n7--->Delete Last\n8--->Delete at a Pos \n9--->Delete All");

                System.out.println("Enter Your choice:");

                choice=sc.nextInt();

                switch (choice){

                    case 1://Display
                        list.displayForward();
                        break;

                    case 2://Display
                        list.displayReverse();
                        break;

                    case 3://Add First
//                        System.out.println("Enter new Element value");
//                        val=sc.nextInt();
//                        list.addFirst(val);
                        break;

                    case 4://Add last
//                        System.out.println("Enter new Element value");
//                        val=sc.nextInt();
//                        list.addLast(val);
                        break;

                    case 5://Add at POS
//                        System.out.println("Enter new Element value");
//                        val=sc.nextInt();
//                        System.out.println("Enter new Element Position");
//                        pos=sc.nextInt();
//                        list.addAtPos(val,pos);
                        break;

                    case 6: // Delete First
//                        try {
//                            list.deleteFirst();
//                            System.out.println("First element deleted");
//                        } catch (RuntimeException e) {
//                            System.out.println(e.getMessage());
//                        }
                        break;

                    case 7: // Delete Last
//                        try {
//                            list.deleteLast();
//                            System.out.println("Last element deleted");
//                        } catch (RuntimeException e) {
//                            System.out.println(e.getMessage());
//                        }
                        break;

                    case 8: // Delete at POS
//                        System.out.println("Enter position to delete");
//                        pos = sc.nextInt();
//                        try {
//                            list.deleteAtPos(pos);
//                            System.out.println("Element at position " + pos + " deleted");
//                        } catch (RuntimeException e) {
//                            System.out.println(e.getMessage());
//                        }
                        break;

                    case 9://Del All
//                        list.delAll();
                       break;

                }

            }while (choice!=0);
        }
    }
}
