import java.util.HashMap;
import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        int arr[] = { 100, 80, 60, 70, 60, 75, 85 };
        int ans[] = new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty())
                ans[i] = -1;
            else if (!stack.isEmpty() && stack.peek() > arr[i]) {
                ans[i] = stack.peek();
            } else if (!stack.isEmpty() && stack.peek() <= arr[i]) {
                while (!stack.isEmpty() && stack.peek() <= arr[i])
                    stack.pop();

                if (stack.isEmpty())
                    ans[i] = -1;
                else
                    ans[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == -1)
                ans[i] = 1;
            else
                ans[i] = Math.abs(map.get(ans[i]) - i);
        }
        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}
