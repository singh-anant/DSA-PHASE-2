import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = sandwiches.length - 1; i >= 0; i--)
            stack.push(sandwiches[i]);
        for (int i = 0; i < students.length; i++)
            queue.offer(students[i]);
        int count = 0;
        while (true) {
            if (stack.peek() == queue.peek()) {
                count = 0;
                stack.pop();
                queue.poll();
            } else {
                count++;
                queue.offer(queue.poll());
            }
            if (count == stack.size())
                break;
        }
        return count;
    }

}