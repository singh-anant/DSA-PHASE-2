public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    public void swap(int x, int y) {
        int temp = heap[x];
        heap[x] = heap[y];
        heap[y] = temp;
    }

    public int parentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public int leftChildIndex(int parentIndex) {
        return (2 * parentIndex) + 1;
    }

    public int rightChildIndex(int parentIndex) {
        return (2 * parentIndex) + 2;
    }

    public void insertionInMaxHeap(int value) {
        // for the out of range-->overflow
        if (size == capacity) {
            System.out.println("HEAP IS NOW FULL....");
            return;
        }
        int current = size;
        heap[size++] = value;
        while (current > 0 && heap[current] > heap[parentIndex(current)]) {
            // then we are going to swap elements
            swap(current, parentIndex(current));
            current = parentIndex(current);
        }
    }

    public int deleteInMaxHeap() {
        if (size == 0) {
            System.out.println("HEAP IS EMPTY...");
            return -1;
        }
        // store the value of root element which we have to return
        int x = heap[0];
        heap[0] = heap[--size];
        maxHeaplify(0);
        return x;
    }

    public void insertInMaxHeap(int index, int value) {
        heap[index] = value;
        while (index != 0 && heap[parentIndex(index)] < heap[index]) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    public void maxHeaplify(int index) {
        int largest = index;
        int lci = leftChildIndex(index);
        int rci = rightChildIndex(index);
        if (lci < size && heap[lci] > heap[largest])
            largest = lci;
        if (lci < size && heap[rci] > heap[largest])
            largest = rci;
        if (largest != index) {
            swap(index, largest);
            maxHeaplify(largest);
        }
    }

    public void printHeap() {
        for (int i : heap) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        MaxHeap mh = new MaxHeap(5);
        /*
         * mh.insertionInMaxHeap(10);
         * mh.insertionInMaxHeap(1);
         * mh.insertionInMaxHeap(4);
         * mh.insertionInMaxHeap(6);
         * mh.insertionInMaxHeap(8);
         */

        int arr[] = { 10, 1, 4, 6, 8 };
        for (int i = arr.length - 1; i >= 0; i--) {
            mh.insertionInMaxHeap(arr[i]);
        }
        mh.printHeap();

    }
}