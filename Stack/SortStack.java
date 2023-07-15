import java.util.Stack;

public class SortStack {
    static Stack<Integer> sort(Stack<Integer> orignal) {
        Stack<Integer> tempoStack = new Stack<>();
        while (!orignal.isEmpty()) {// running loop till orignal stack is not empty..
            int current = orignal.pop();
            while (!tempoStack.isEmpty() && current > tempoStack.peek())
                orignal.push(tempoStack.pop());

            tempoStack.push(current);
        }
        return tempoStack;
    }

    public static void main(String[] args) {
        Stack<Integer> orignal = new Stack<>();
        orignal.push(1);
        orignal.push(4);
        orignal.push(7);
        orignal.push(8);
        orignal.push(2);
        orignal.push(4);
        orignal.push(10);
        System.out.println(orignal);
        Stack<Integer> ans = sort(orignal);
        System.out.println(ans);
    }
}
