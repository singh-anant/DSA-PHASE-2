import java.util.ArrayList;

public class StackUsingArrayList {
    private ArrayList<Integer> stack;

    public StackUsingArrayList() {
        stack = new ArrayList<>();
    }

    public void push(int element) {
        stack.add(element);
        System.out.println("Element Pushed");
    }

    public void pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack cannot be emptied more");
            return;
        }
        System.out.println("Element Removed Is-:" + stack.get(stack.size() - 1));
        stack.remove(stack.size() - 1);
    }

    public void peek() {
        System.out.println("Top Element Is-:" + stack.get(stack.size() - 1));

    }

    public static void main(String[] args) {
        StackUsingArrayList stack = new StackUsingArrayList();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.peek();
        stack.pop();
        stack.peek();

    }
}
