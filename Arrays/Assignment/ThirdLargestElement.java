import java.util.Arrays;

public class ThirdLargestElement {

    static int thirdLargest(int[] arr) {
        if (arr.length == 0)
            return -1;
        if (arr.length <= 3)
            return arr[arr.length - 1];

        Arrays.sort(arr);
        return arr[arr.length - 3];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 9, 8, 4, 3 };
        System.out.println(thirdLargest(arr));
    }
}
