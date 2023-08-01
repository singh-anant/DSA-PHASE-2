public class HeapSort {

    public int parentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    public int leftChildIndex(int parentIndex) {
        return (2 * parentIndex) + 1;
    }

    public int rightChildIndex(int parentIndex) {
        return (2 * parentIndex) + 2;
    }

    public void swapInArray(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public void maxHeaplify(int arr[], int size, int index) {
        int largest = index;
        int lci = leftChildIndex(index);
        int rci = rightChildIndex(index);
        if (lci < size && arr[lci] > arr[largest])
            largest = lci;
        if (rci < size && arr[rci] > arr[largest])
            largest = rci;
        if (largest != index) {
            // swapping will get performed
            swapInArray(arr, largest, index);
        }
    }

    public int[] buildAHeap(int arr[]) {
        // Now we have to pick the parent of the last node...
        // An then traverse till root node
        for (int i = parentIndex(arr.length - 1); i >= 0; i--)
            maxHeaplify(arr, arr.length, i);

        return arr;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 4, 50, 20, 15 };
        // First of all we are goinf to build a heap but using heaplify method;
        HeapSort hs = new HeapSort();
        int ans[] = hs.buildAHeap(arr);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}
