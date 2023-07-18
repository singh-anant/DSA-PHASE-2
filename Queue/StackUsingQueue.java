import java.util.LinkedList;
import java.util.Queue;

import javax.management.RuntimeErrorException;

public class StackUsingQueue {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public StackUsingQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int element) {
        queue2.add(element);
        while (!queue1.isEmpty())
            queue2.add(queue1.remove());

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        if (checkEmpty())
            throw new RuntimeErrorException(null, "Stack is empty");
        return queue1.remove();
    }

    public boolean checkEmpty() {
        return queue1.isEmpty();
    }

}
