public class CircularQueue {
    public static class MyCircularQueue {
        int queue[];
        int front;
        int rear;

        public MyCircularQueue() {
            queue = new int[5];
            front = -1;
            rear = -1;
        }

        public void enqueue(int element) {
            if ((rear + 1) % queue.length == front) {
                System.out.println("Queue seems to be full");
                return;
            } else if (rear == -1 && front == rear) {
                front = rear = 0;
                queue[rear] = element;
                System.out.println("Element Pushed");
                return;
            }

            rear = (rear + 1) % queue.length;
            queue[rear] = element;
            System.out.println("Element Pushed");

        }

        public void dequeue() {
            if (rear == -1 && front == rear) {
                System.out.println("Deletion cannot be performed...");
                return;
            } else if (front == rear) {
                front = rear = -1;
                return;
            }
            System.out.println("Element removed is-:" + queue[front]);
            front = (front + 1) % queue.length;
        }

        public boolean isEmpty() {
            if (front == -1 && rear == -1)
                return true;
            else
                return false;
        }

    }
}
