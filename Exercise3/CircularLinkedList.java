package Exercise3;

import Exercise2.Node;

public class CircularLinkedList implements Cloneable {
    private Node head;
    private Node tail;

    // Constructor
    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Method to insert a node at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }

    // Method to insert a node at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setNext(head);
            this.head = newNode;
        }
    }

    // Method to insert a node in between
    public void insertInBetween(int data, int position) {
        Node newNode = new Node(data);
        if (head == null || position <= 0) {
            // Insert at the beginning if the list is empty or position is invalid
            insertAtBeginning(data);
        } else {
            Node current = head;
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
        if (head == null) {
            return; // List is empty
        }

        if (head == tail) {
            // Only one node in the list
            head = tail = null;
            return;
        }

        Node current = head;
        while (current.getNext() != tail) {
            current = current.getNext();
        }

        current.setNext(null);
        tail = current;
    }

    // Method to remove a node from the beginning
    public void removeFromBeginning() {
        if (head == null) {
            return; // List is empty
        }

        if (head == tail) {
            // Only one node in the list
            head = tail = null;
        } else {
            head = head.getNext();
        }
    }

    // Method to remove a node from in between
    public void removeFromInBetween(int position) {
        if (head == null || position <= 0) {
            return; // List is empty or position is invalid
        }

        if (position == 1) {
            // Remove from the beginning
            removeFromBeginning();
        } else {
            Node current = head;
            for (int i = 1; i < position - 1 && current != null; i++) {
                current = current.getNext();
            }
            if (current != null && current.getNext() != null) {
                current.setNext(current.getNext().getNext());
                if (current.getNext() == null) {
                    // If the removed node was the last node, update tail
                    tail = current;
                }
            }
        }
    }

    // Method to display the linked list
    public void display() {
        Node current = head;
        while (current.getNext() != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.print(current.getData() + " -> NULL");
        System.out.println();
    }

    // Extentions
    public boolean isHeadNode(Node node) {
        return node == head;
    }

    public boolean isTailNode(Node node) {
        return node == tail;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node node) {
        head = node;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node node) {
        tail = node;
    }

    public Node getNodeAtPosition(int position) {
        if (head == null) {
            return null;
        }

        Node current = head;
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
        var head = new Node(this.head.getData(), this.head.getNext());
        other.setHead(head);

        var current = head.getNext();
        var tail = head;
        while (current != null) {
            // Clonning the rest of the list
            var node = new Node(current.getData());
            tail.setNext(node);
            tail = node;
            current = current.getNext();
        }
        other.setTail(tail);
        return other;
    }

    @Override
    public boolean equals(Object other)
    {
        boolean flag = true;
        var current = head;
        var current2 = ((CircularLinkedList)other).head;
        while(flag && current != null && current2 != null) {
            //System.out.println("Checking " + current.getData() + " == " + current2.getData());
            flag = current.equals(current2);
            current = current.getNext();
            current2 = current2.getNext();
        }

        return flag;
    }

    @Override
    public String toString()
    {
        return "Head = " + head + " Tail = " + tail;
    }
}
