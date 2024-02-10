package Exercise3;

import Exercise2.Node;

public class CircularLinkedList implements Cloneable {
    private Node tail;

    // Constructor
    public CircularLinkedList() {
        this.tail = null;
    }

    // Method to insert a node at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            this.tail = newNode;
            newNode.setNext(tail);
        } else {
            newNode.setNext(tail.getNext());
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }

    // Method to insert a node at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data, tail.getNext());
        if (this.tail == null) {
            this.tail = newNode;
            newNode.setNext(tail);
        } else {
            newNode.setNext(tail.getNext());
            tail.setNext(newNode);
        }
    }

    // Method to insert a node in between
    public void insertInBetween(int data, int position) {
        Node newNode = new Node(data);
        if (tail == null || position <= 0) {
            // Insert at the beginning if the list is empty or position is invalid
            insertAtBeginning(data);
        } else {
            Node current = tail;
            for (int i = 1; i < position - 1 && current != null; i++) {
                current = current.getNext();
            }
            if (current != null) {
                newNode.setNext(current.getNext());
                current.setNext(newNode);
                if (current == tail) {
                    tail = newNode;
                }
            } else {
                // Insert at the end if the position is beyond the current size
                insertAtEnd(data);
            }
        }
    }

    // Method to remove a node from the end
    public void removeFromEnd() {
        if (tail == null) {
            return; // List is empty
        }

        if (tail.getNext() == tail) {
            // Only one node in the list
            tail = null;
            return;
        }

        Node current = tail;
        while (current.getNext() != tail) {
            current = current.getNext();
        }

        current.setNext(tail.getNext());
        tail = current;
    }

    // Method to remove a node from the beginning
    public void removeFromBeginning() {
        if (tail == null) {
            return; // List is empty
        }

        if (tail.getNext() == tail) {
            // Only one node in the list
            tail = null;
        } else {
            var node = tail.getNext();
            tail.setNext(tail.getNext());
            //tail.setNext(tail.getNext().getNext());
        }
    }

    // Method to remove a node from in between
    public void removeFromInBetween(int position) {
        if (tail == null || position <= 0) {
            return; // List is empty or position is invalid
        }

        if (position == 1) {
            // Remove from the beginning
            removeFromBeginning();
        } else {
            Node current = tail;
            for (int i = 1; i < position - 1 && current != tail; i++) {
                current = current.getNext();
            }
            if (current != tail && current.getNext() != null) {
                current.setNext(current.getNext().getNext());
                if (current.getNext() == tail) {
                    // If the removed node was the last node, update tail
                    tail = current;
                }
            }
        }
    }

    // Method to display the linked list
    public void display() {
        Node current = tail;
        while (current.getNext() != tail) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.print(current.getData() + " -> " + tail.getData());
        System.out.println();
    }

    // Extentions
    public boolean isTailNode(Node node) {
        return node == tail;
    }

    public Node getHead() {
        return tail.getNext();
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node node) {
        tail = node;
    }

    public Node getNodeAtPosition(int position) {
        if (tail == null) {
            return null;
        }

        Node current = tail;
        for (int i = 1; i < position; i++) {
            if (current == null) {
                System.out.println("Position entered has exceeded the list limit!");
                break;
            }

            current = current.getNext();
        }

        return current;
    }

    public CircularLinkedList clone() throws CloneNotSupportedException {
        var other = (CircularLinkedList) super.clone();

        // Clonning the head
        var head = new Node(this.tail.getData(), this.tail.getNext());
        other.setTail(head);

        var current = head.getNext();
        var tail = head;
        while (current != this.tail) {
            // Clonning the rest of the list
            var node = new Node(current.getData());
            tail.setNext(node);
            tail = node;
            current = current.getNext();
        }
        tail.setNext(head);
        return other;
    }

    @Override
    public boolean equals(Object other) {
        boolean flag = true;
        var current = tail;
        Node otherTail = ((CircularLinkedList) other).tail;
        var current2 = otherTail;
        do {
            //System.out.println("Checking " + current.getData() + " == " + current2.getData());
            flag = current.equals(current2);
            current = current.getNext();
            current2 = current2.getNext();
        } while (flag && current != tail && current2 != otherTail);

        return flag;
    }

    @Override
    public String toString() {
        return "Tail = " + tail;
    }
}
