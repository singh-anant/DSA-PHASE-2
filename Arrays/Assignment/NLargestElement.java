import java.util.Arrays;

public class NLargestElement {
    static int nLargest(int arr[], int nth) {
        if (arr.length == 0)
            return -1;
        if (nth > arr.length)
            return arr[0];
        Arrays.sort(arr);

        return arr[arr.length - nth];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 9, 8, 4, 3 };
        System.out.println(nLargest(arr, 5));

    }

}
