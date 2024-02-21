package MidtermCode.exercises;

public class Exercise2 {
    LinkedList list = new LinkedList();

    public void reverseList() {
        for (int i = 1; i <= 10; i++) {
            list.insertAtEnd(i);
        }
        System.out.println("Original list");
        list.display();

        var current = list.getHead();
        var currentNext = current.getNext();
        
        while (currentNext.getNext() != null) {
            var next = currentNext.getNext();
            currentNext.setNext(current);
            current = currentNext;
            currentNext = next;
        }

        currentNext.setNext(current);

        var head = list.getHead();
        head.setNext(null);
        list.setHead(list.getTail());
        list.setTail(head);

        System.out.println("Reversed list");
        list.display();
    }
}
