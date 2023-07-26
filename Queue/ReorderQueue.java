import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReorderQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= 8; i++) {
            queue.offer(i);
        }
        for (int i = 0; i < (queue.size()); i++) {
            stack.push(queue.poll());
        }
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
            queue.offer(queue.poll());
        }
        System.out.println(queue);

    }
}
