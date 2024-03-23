import java.util.Stack;

import Queue.LinkedQueue;
import Stacks.StackTransfer;
import lists.LinkedPositionalList;

public class Main {
    public static void main(String[] args) {
        Exercise1();
        Exercise2();
        Exercise3();
    }

    private static void Exercise3() {

        exerciseTitleProvider("Exercise 3");

        LinkedQueue<Integer> queue1 = new LinkedQueue<>();
        LinkedQueue<Integer> queue2 = new LinkedQueue<>();

        for (int i = 1; i < 10; i++) {
            queue1.enqueue(i);
        }

        for (int i = 91; i < 100; i++) {
            queue2.enqueue(i);
        }

        queue1.concatenate(queue2);

        int size = queue1.size();
        for (int i = 0; i < size; i++) {
            System.out.print(queue1.dequeue() + " -> ");
        }
    }

    private static void Exercise2() {

        exerciseTitleProvider("Exercise 2");

        Stack<String> smallLetters = new Stack<>();
        Stack<String> capitalLetters = new Stack<>();

        for (char i = 'a'; i <= 'z'; i++) {
            smallLetters.push(i + "");
        }

        for (char i = 'A'; i <= 'Z'; i++) {
            capitalLetters.push(i + "");
        }

        System.out.println();
        for (String val : capitalLetters) {
            System.out.print(val + " -> ");
        }
        
        System.out.println();
        for (String val : smallLetters) {
            System.out.print(val + " -> ");
        }
        
        StackTransfer<String> transferHandler = new StackTransfer<>();
        transferHandler.Transfer(smallLetters, capitalLetters);
        System.out.println();
        System.out.println();

        for (String val : capitalLetters) {
            System.out.print(val + " -> ");
        }

        System.out.println();
    }

    private static void Exercise1() {

        exerciseTitleProvider("Exercise 1");

        LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
        
        lists.Position<Integer> pos = null;

        for (int i = 1; i < 100; i++) {
            // Assigning position at the middle of the list
            if (i == 50) {
               pos = list.addLast(i);
            }
            list.addLast(i);
        }

        // The following line will throw IllegalArgumentException as the line will remove the element from the list thus making it an illegal operation.
        //list.remove(pos);

        int index = list.indexOf(pos);
        System.out.println("Pos is " + pos.getElement() + " and it's index is " + index);
    }

    private static void exerciseTitleProvider(String titleString) {
        System.out.println();
        System.out.println(titleString);
        System.out.println("=========================================");
        System.out.println();
    }
}
