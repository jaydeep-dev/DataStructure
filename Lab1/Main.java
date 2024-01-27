import java.util.Scanner;

import Exercise1.DoublyLinkedList;
import Exercise2.LinkedList;
import Exercise3.CircularLinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Singly Linked List Example");
        LinkedListExample();
        seperator();

        System.out.println("\nDoubly Linked List Example\n");
        DoublyLinkedListExample();
        seperator();

        System.out.println("\nCircular Linked list Example\n");
        CircularLinkedListExample();
        seperator();
    }

    private static void seperator() {
        System.out.println();

        for (int i = 0; i < 75; i++)
            System.out.print("=");

        System.out.println();
    }

    private static void CircularLinkedListExample() {
        var list = new CircularLinkedList();

        for (int i = 301; i <= 310; i++) {
            list.insertAtEnd(i);
        }

        System.out.print("Original List => ");
        list.display();

        try {
            var listClone = list.clone();

            // Comment below line for accurate result
            listClone.insertInBetween(0, 5);

            System.out.print("Clonned  List => ");
            listClone.display();

            if (list == listClone) {
                System.out.println("Pointing to same objects! JOB IS NOT DONE");
            } else {
                if (listClone.equals(list)) {
                    System.out.println("Cloned Successfully");
                } else {
                    System.out.println("Clonned but Contents changed!!!");
                }
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private static void DoublyLinkedListExample() {
        var listL = new DoublyLinkedList();
        var listM = new DoublyLinkedList();

        for (int i = 101; i <= 110; i++) {
            listL.insertAtEnd(i);
        }

        for (int i = 201; i <= 210; i++) {
            listM.insertAtEnd(i);
        }

        System.out.print("List 1 => ");
        listL.display();
        System.out.print("List 2 => ");
        listM.display();

        // Concating the list only one way (Intentionally)
        listL.getTail().setNext(listM.getHead());

        System.out.println();

        System.out.print("Modified List 1 => ");
        listL.display();
    }

    private static void LinkedListExample() {
        // Creating the list
        LinkedList list = new LinkedList();

        // Adding data to the list
        for (int i = 101; i <= 110; i++) {
            list.insertAtEnd(i);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("You will be swapping 2 nodes in the list");
        list.display();
        System.out.println();
        System.out.println("Please enter respective positions of the Node A & Node B to perform swap!");
        System.out.println();

        System.out.print("Enter the position for swaping Node A: ");
        var position1 = sc.nextInt();
        System.out.print("Enter the position for swaping Node B: ");
        var position2 = sc.nextInt();

        System.out.println();

        if (position1 == position2) {
            System.out.println("Both positions are same!");
        } else if (position1 <= 0 || position2 <= 0) {
            System.out.println("Please enter values grater than 0!");
        } else {
            position1 = Math.min(position1, position2);
            position2 = Math.max(position1, position2);

            var nodeARef = list.getNodeAtPosition(position1 - 1);
            var nodeBRef = list.getNodeAtPosition(position2 - 1);

            if (nodeARef != null && nodeBRef != null) {

                System.out.print("Original List => ");
                list.display();

                var head = list.getHead();

                if (nodeARef == head && position1 == 1) {
                    System.out.println("\nHead Node Changed!");
                    list.setHead(nodeBRef.getNext());
                    var node = list.getHead().getNext();
                    nodeBRef.setNext(nodeARef);
                    list.getHead().setNext(nodeARef.getNext());
                    nodeARef.setNext(node);
                } else if(position2 - position1 <= 1) {
                    var node = nodeARef.getNext();
                    nodeARef.setNext(nodeBRef.getNext());
                    nodeBRef.setNext(nodeARef.getNext().getNext());
                    nodeARef.getNext().setNext(node);
                } else {
                    var node = nodeBRef.getNext().getNext();
                    nodeBRef.getNext().setNext(nodeARef.getNext().getNext());
                    nodeARef.getNext().setNext(node);
                    node = nodeARef.getNext();
                    nodeARef.setNext(nodeBRef.getNext());
                    nodeBRef.setNext(node);
                }

                System.out.print("SWAPPED  List => ");
                list.display();
            }
        }

        sc.close();
    }
}
