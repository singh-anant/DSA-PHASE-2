public class StackWithArray {
    public static class MyStack {
        int stack[];
        int top;
        int capcity;

        public MyStack(int capacity) {
            this.capcity = capacity;
            stack = new int[capacity];
            top = -1;
        }

        public void push(int element) {
            if (top == capcity - 1) {
                System.out.println("Stack seems to be full");
                return;
            }
            stack[++top] = element;
            System.out.println("Element Pushed");

        }

        public void pop() {
            if (top < 0) {
                System.out.println("Stack cannot be emptied more");
                return;
            }
            System.out.println("Element popped out is-:" + stack[top]);
            stack[top] = 0;
            top--;
        }

        public void peek() {
            if (top < 0) {
                System.out.println("No Element");
                return;
            }
            System.out.println("The element at top is-:" + stack[top]);
        }

        public void size() {
            System.out.println("The size is -:" + top + 1);
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(10);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.peek();
        stack.pop();
        stack.peek();

    }
}
