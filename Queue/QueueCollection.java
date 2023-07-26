import java.util.LinkedList;
import java.util.Queue;

public class QueueCollection {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.add(40);
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.peek());

    }
}
