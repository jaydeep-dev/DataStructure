package Exercise1;

public class DoublyLinkedList {
    private NodeD head;
    private NodeD tail;

    // Constructor
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Method to insert a node at the end
    public void insertAtEnd(int data) {
        NodeD newNode = new NodeD(data);
        if (head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            newNode.setPrev(tail);
            this.tail = newNode;
        }
    }

    // Method to insert a node at the beginning
    public void insertAtBeginning(int data) {
        NodeD newNode = new NodeD(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            this.head = newNode;
        }
    }

    // Method to insert a node in between
    public void insertInBetween(int data, int position) {
        NodeD newNode = new NodeD(data);
        if (head == null || position <= 0) {
            // Insert at the beginning if the list is empty or position is invalid
            insertAtBeginning(data);
        } else {
            NodeD current = head;
            for (int i = 1; i < position - 1 && current != null; i++) {
                current = current.getNext();
            }
            if (current != null) {
                newNode.setNext(current.getNext());
                newNode.setPrev(current);
                current.getNext().setPrev(newNode);
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

        NodeD current = head;
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
            NodeD current = head;
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
        NodeD current = head;
        while (current.getNext() != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.print(current.getData() + " -> NULL");
        System.out.println();
    }

    // Extentions
    public boolean isHeadNode(NodeD node) {
        return node == head;
    }

    public boolean isTailNode(NodeD node) {
        return node == tail;
    }

    public NodeD getHead() {
        return head;
    }

    public NodeD getTail() {
        return tail;
    }

    public void setTail(NodeD node) {
        tail = node;
    }

    public void setHead(NodeD node) {
        head = node;
    }

    public NodeD getNodeAtPosition(int position) {
        if (head == null) {
            return null;
        }

        NodeD current = head;
        for (int i = 1; i < position; i++) {
            if (current == null) {
                System.out.println("Position entered has exceeded the list limit!");
                break;
            }

            current = current.getNext();
        }

        return current;
    }
}
