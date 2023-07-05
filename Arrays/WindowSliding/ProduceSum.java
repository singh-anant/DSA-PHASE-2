import java.util.ArrayList;

public class ProduceSum {
    public static void main(String[] args) {
        int windowSize = 3;
        int arr[] = { 2, 10, 5, 6, 9, 7, 1, 0 };
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < windowSize; i++) {
            sum += arr[i];
        }
        list.add(sum);
        for (int i = windowSize; i < arr.length - 1; i++) {
            sum = sum - arr[i - windowSize] + arr[i];
            list.add(sum);
        }
        System.out.println(list);
    }
}
