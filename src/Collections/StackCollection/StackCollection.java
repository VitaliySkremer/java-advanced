package Collections.StackCollection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class StackCollection {
    void main() {
        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(3);
        stack.push(1);

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }

        Deque<Integer> deque = new ArrayDeque<>();

        deque.add(5);
        deque.add(3);
        deque.add(1);

        while (!deque.isEmpty()) {
            System.out.println(deque.pop());
        }
    }
}
