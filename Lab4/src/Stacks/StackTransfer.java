package Stacks;

import java.util.Stack;

public class StackTransfer<T> {
    public void Transfer(Stack<T> from, Stack<T> to) {

        Stack<T> copyOfFrom = new Stack<>();
        for (T value : from) {
            copyOfFrom.push(value);
        }

        for (int i = 0; i < from.size(); i++) {
            T value = copyOfFrom.pop();
            to.push(value);
        }

        // This will make the from empty and actually transfer the elements
        // int size = from.size();
        // for (int i = 0; i < size; i++) {
        //     T value = from.pop();
        //     to.push(value);
        // }
    }
}
