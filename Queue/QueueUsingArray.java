public class QueueUsingArray {
    public static class MyQueue {
        int queue[];
        int front;
        int rear;
        int capacity;

        public MyQueue(int capacity) {
            this.capacity = capacity;
            queue = new int[capacity];
            front = -1;
            rear = -1;
        }

        public void enqueue(int element) {
            if (front > rear) {
                front = -1;
                rear = -1;
            }
            if (rear == capacity - 1) {
                System.out.println("Queue seems to be full");
                return;
            }
            queue[++rear] = element;
            System.out.println("Element Pushed");

        }

        public void dequeue() {
            if (rear == -1 || front == rear) {
                System.out.println("Queue seems to be empty");
                return;
            }

            System.out.println("Element removed is-:" + queue[front + 1]);
            queue[++front] = 0;
        }

        public void printFrontAndRearElement() {
            if (front == -1 && rear == -1) {
                System.out.println("No element present in the Queue");
                return;
            }

            System.out.println(queue[front + 1] + " " + queue[rear]);

        }

        public int size() {
            return rear = front + 1;
        }

        public boolean isEmpty() {
            if (front == -1 && rear == -1)
                return true;
            else
                return false;
        }

    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue(20);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.printFrontAndRearElement();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.printFrontAndRearElement();
    }
}
