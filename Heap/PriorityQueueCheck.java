import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueCheck {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>();
        int arr[] = { 10, 4, 50, 20, 15 };
        for (int i : arr) {
            maxheap.add(i);
        }
        System.out.println(maxheap);
        System.out.println(maxheap.poll());
        System.out.println(maxheap);

    }
}
