package Exercise1;

public class NodeD {
    private int data; // String data for Node
    private NodeD next; // Reference to next Node
    private NodeD prev;

    // Constructor
    public NodeD() { }

    // Constructor
    public NodeD(int data, NodeD next, NodeD prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public NodeD(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    // Getters and Setters
    public int getData() {
        return this.data;
    }

    public NodeD getNext() {
        return this.next;
    }

    public NodeD getPrev() {
        return this.prev;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(NodeD next) {
        this.next = next;
    }

    public void setPrev(NodeD prev) {
        this.prev = prev;
    }

    // toString method
    public String toString() {
        return this.data + " -> " + this.getNext();
    }

    // equals method
    public boolean equals(NodeD node) {
        return this.data == node.getData();
    }
}
