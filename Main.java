import java.util.Scanner;

import javax.swing.text.Position;

public class Main {
    public static void main(String[] args) {
        // Creating the list
        LinkedList mySinglyLinkedList = new LinkedList();

        // Adding data to the list
        for (int i = 101; i <= 110; i++) {
            mySinglyLinkedList.insertAtEnd(i);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("You will be swapping 2 nodes in the list");
        mySinglyLinkedList.display();
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
            var nodeARef = mySinglyLinkedList.getNodeAtPosition(Math.min(position1, position2) - 1);
            var nodeBRef = mySinglyLinkedList.getNodeAtPosition(Math.max(position1, position2) - 1);

            System.out.println(nodeARef);
            System.out.println(nodeBRef);

            var head = mySinglyLinkedList.getHead();

            if (nodeARef == head && (position1 == 1 || position2 == 1)) {
                System.out.println("Head Node Changed!");
                mySinglyLinkedList.setHead(nodeBRef.getNext());
                var node = mySinglyLinkedList.getHead().getNext();
                nodeBRef.setNext(nodeARef);
                mySinglyLinkedList.getHead().setNext(nodeARef.getNext());
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
        mySinglyLinkedList.display();

        sc.close();
    }
}
