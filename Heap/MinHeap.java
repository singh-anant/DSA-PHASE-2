public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
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

    public void insertionInMinHeap(int value) {
        // for the out of range-->overflow
        if (size == capacity) {
            System.out.println("HEAP IS NOW FULL....");
            return;
        }
        int current = size;
        heap[size++] = value;
        while (current > 0 && heap[current] < heap[parentIndex(current)]) {
            // then we are going to swap elements....
            swap(current, parentIndex(current));
            // to check above parent rows.....
            current = parentIndex(current);
        }
    }

    public void insertInMinHeap(int index, int value) {
        heap[index] = value;
        while (index != 0 && heap[parentIndex(index)] > heap[index]) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    public int deleteInMinHeap() {
        if (size == 0) {
            System.out.println("HEAP IS EMPTY...");
            return -1;
        }
        // store the value of root element which we have to return
        int x = heap[0];
        heap[0] = heap[--size];
        minHeaplify(0);
        return x;
    }

    public void minHeaplify(int index) {
        int parent = index;
        int lci = leftChildIndex(index);
        int rci = rightChildIndex(index);
        if (lci < size && heap[lci] < heap[parent])
            parent = lci;
        if (lci < size && heap[rci] < heap[parent])
            parent = rci;
        if (parent != index) {
            swap(index, parent);
            minHeaplify(parent);
        }
    }

    public void printHeap() {
        for (int i : heap) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        MinHeap mh = new MinHeap(10);
        mh.insertionInMinHeap(10);
        mh.insertionInMinHeap(1);
        mh.insertionInMinHeap(4);
        mh.insertionInMinHeap(6);
        mh.insertionInMinHeap(8);
        mh.printHeap();

    }
}