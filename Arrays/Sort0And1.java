public class Sort0And1 {
    public static void main(String[] args) {
        int count = 0;
        int arr[] = { 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0 };
        for (int i : arr) {
            if (i == 0)
                count++;
        }
        for (int i = 0; i < count; i++) {
            arr[i] = 0;
        }
        for (int i = count; i < arr.length; i++) {
            arr[i] = 1;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
