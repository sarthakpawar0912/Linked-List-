package CDAC.Types.Signly;
import java.util.Scanner;

 class SinglyList{

     //node is static member class of Singly list
    static class Node{

        //Node class fields
        int data;
        Node next;

        //Node member class
        public Node() {
            data=0;
            next=null;
        }

        public Node(int val) {
           data=val;
           next=null;
        }

    }

    //list class fields
    private  Node head;

    public SinglyList() {
        this.head = null;
    }

    void display(){

        System.out.println("Displaying the list:");

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


    void  addLast(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node trav = head;
            while (trav.next != null) { // Check if next node exists
                trav = trav.next;
            }
            trav.next = newNode; // Add new node at the end
        }
    }

    void addFirst(int val) {
        //create new node  and init it
        Node newNode=new Node(val);
        //new node next should point to head
        newNode.next=head;
        //head should point to new node
        head=newNode;
    }

    void addAtPos(int val, int pos) {
        // Create new node
        Node newNode = new Node(val);

        // Special case: empty list
        if (head == null) {
            if (pos == 1) {
                head = newNode; // Add as first node
            } else {
                System.out.println("Invalid position: List is empty");
            }
            return;
        }

        // Special case: pos = 1 (add at beginning)
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // Traverse to pos-1 or until end of list
        Node trav = head;
        for (int i = 1; i < pos - 1 && trav != null; i++) {
            trav = trav.next;
        }

        // Check if position is invalid (trav is null or pos is too large)
        if (trav == null) {
            System.out.println("Invalid position: Position exceeds list length");
            return;
        }

        // Insert new node
        newNode.next = trav.next;
        trav.next = newNode;
    }

    public void deleteFirst(){
        //special 1: iff list is empty ,throw exception

        if(head==null){
            throw new RuntimeException("List is empty");
        }

        //general:make head pointing to next node
        head=head.next;
    }


    public void delAll(){
        head=null;
    // all nodes will be garbage collected
    }


    public void deleteAtPos(int pos) {
        // Special case: empty list
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        // Special case: position 1 (delete first)
        if (pos == 1) {
            head = head.next;
            return;
        }
        // Validate position and traverse to pos-1
        Node trav = head;
        for (int i = 1; i < pos - 1 && trav != null; i++) {
            trav = trav.next;
        }
        // Check for invalid position
        if (trav == null || trav.next == null) {
            throw new RuntimeException("Invalid position");
        }
        // Delete node at pos by skipping it
        trav.next = trav.next.next;
    }

    public void deleteLast() {
        // Special case: empty list
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        // Special case: single node
        if (head.next == null) {
            head = null;
            return;
        }
        // Traverse to second-to-last node
        Node trav = head;
        while (trav.next.next != null) {
            trav = trav.next;
        }
        // Remove last node
        trav.next = null;
    }

}



public class SimglyLinkedList {
    public static void main(String[] args) {
        int choice,val,pos;

        SinglyList list=new SinglyList();

        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("\n\n0--->Exit \n1--->Display\n2--->Add First\n3--->Add Last\n4--->Add at a Pos\n5--->Delete First\n6--->Delete Last\n7--->Delete at a Pos \n8--->Delete All");
            System.out.println("Enter Your choice:");
            choice=sc.nextInt();
            switch (choice){
                case 1://Display
                   list.display();
                    break;

                case 2://Add First
                    System.out.println("Enter new Element value");
                    val=sc.nextInt();
                    list.addFirst(val);
                    break;

                case 3://Add last
                    System.out.println("Enter new Element value");
                    val=sc.nextInt();
                    list.addLast(val);
                    break;

                case 4://Add at POS
                    System.out.println("Enter new Element value");
                    val=sc.nextInt();
                    System.out.println("Enter new Element Position");
                    pos=sc.nextInt();
                    list.addAtPos(val,pos);
                    break;

                case 5: // Delete First
                    try {
                        list.deleteFirst();
                        System.out.println("First element deleted");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6: // Delete Last
                    try {
                        list.deleteLast();
                        System.out.println("Last element deleted");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 7: // Delete at POS
                    System.out.println("Enter position to delete");
                    pos = sc.nextInt();
                    try {
                        list.deleteAtPos(pos);
                        System.out.println("Element at position " + pos + " deleted");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 8://Del All
                    list.delAll();
                    break;
            }
        }while (choice!=0);
    }
}