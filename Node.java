// From repo: https://github.com/Sohaib-Mohiuddin/comp254-demo/blob/main/Week%202/Node.java

public class Node {
    private int data; // String data for Node
    private Node next; // Reference to next Node

    // Constructor
    public Node() { }

    // Constructor
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    // Getters and Setters
    public int getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    // toString method
    public String toString() {
        return this.data + " -> " + this.getNext();
    }

    // equals method
    public boolean equals(Node node) {
        return this.data == node.getData();
    }
}