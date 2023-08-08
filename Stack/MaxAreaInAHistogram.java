import java.util.Stack;

class Solution {
    // Function to find largest rectangular area possible in a given histogram.
    public int getMaxArea(int hist[]) {
        // your code here

        int rightIndex[] = new int[hist.length];
        int leftIndex[] = new int[hist.length];
        int width[] = new int[hist.length];

        Stack<Integer> stack = new Stack<>();
        // Lowest to the right
        for (int i = hist.length - 1; i >= 0; i--) {
            if (stack.isEmpty())
                rightIndex[i] = hist.length;
            else if (!stack.isEmpty() && hist[stack.peek()] < hist[i])
                rightIndex[i] = stack.peek();
            else if (!stack.isEmpty() && hist[stack.peek()] >= hist[i]) {
                while (!stack.isEmpty() && hist[stack.peek()] >= hist[i])
                    stack.pop();
                if (stack.isEmpty())
                    rightIndex[i] = hist.length;
                else if (!stack.isEmpty() && hist[stack.peek()] < hist[i])
                    rightIndex[i] = stack.peek();
            }
            stack.push(i);
        }

        stack = new Stack<>();
        // lowest to the left
        for (int i = 0; i < hist.length; i++) {
            if (stack.isEmpty())
                leftIndex[i] = -1;
            else if (!stack.isEmpty() && hist[stack.peek()] < hist[i])
                leftIndex[i] = stack.peek();
            else if (!stack.isEmpty() && hist[stack.peek()] >= hist[i]) {
                while (!stack.isEmpty() && hist[stack.peek()] >= hist[i])
                    stack.pop();
                if (stack.isEmpty())
                    leftIndex[i] = -1;
                else if (!stack.isEmpty() && hist[stack.peek()] < hist[i])
                    leftIndex[i] = stack.peek();
            }
            stack.push(i);
        }

        for (int i = 0; i < width.length; i++) {
            width[i] = rightIndex[i] - leftIndex[i] - 1;
        }

        for (int i = 0; i < hist.length; i++)
            width[i] = hist[i] * width[i];

        int max = 0;
        for (int i : width)
            max = Math.max(max, i);

        return max;
    }
}