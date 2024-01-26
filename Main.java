import java.util.Scanner;

import Exercise1.DoublyLinkedList;
import Exercise2.LinkedList;

public class Main {
    public static void main(String[] args) {
        //LinkedListExample();

        DoublyLinkedListExample();
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

        // Concating the list only one way (Intentionally)
        listL.getTail().setNext(listM.getHead());

        listL.display();
        listM.display();

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

        if (position1 == position2) {
            System.out.println("Both positions are same!");
        } else if (position1 <= 0 || position2 <= 0) {
            System.out.println("Please enter values grater than 0!");
        } else {
            var nodeARef = list.getNodeAtPosition(Math.min(position1, position2) - 1);
            var nodeBRef = list.getNodeAtPosition(Math.max(position1, position2) - 1);

            System.out.println(nodeARef);
            System.out.println(nodeBRef);

            var head = list.getHead();

            if (nodeARef == head && (position1 == 1 || position2 == 1)) {
                System.out.println("Head Node Changed!");
                list.setHead(nodeBRef.getNext());
                var node = list.getHead().getNext();
                nodeBRef.setNext(nodeARef);
                list.getHead().setNext(nodeARef.getNext());
                nodeARef.setNext(node);
            } else {
                var node = nodeBRef.getNext().getNext();
                nodeBRef.getNext().setNext(nodeARef.getNext().getNext());
                nodeARef.getNext().setNext(node);
                node = nodeARef.getNext();
                nodeARef.setNext(nodeBRef.getNext());
                nodeBRef.setNext(node);
            }
        }

        System.out.println();
        list.display();

        sc.close();
    }
}
