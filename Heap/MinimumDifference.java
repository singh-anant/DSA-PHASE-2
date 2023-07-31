import java.util.PriorityQueue;

public class MinimumDifference {
    public static int minDifference(int nums[]) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : nums)
            minHeap.add(i);

        int min = Integer.MAX_VALUE;
        int top = minHeap.poll();
        while (!minHeap.isEmpty()) {
            int currentElement = minHeap.poll();
            int difference = currentElement - top;
            min = Math.min(min, difference);
            top = currentElement;
        }
        return min;
    }

    public static void main(String[] args) {
        int arr[] = { 5, 8, 6, 13, 12, 9 };
        System.out.println(minDifference(arr));
    }
}
