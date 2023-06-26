
public class DutchFlag {
    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = { 0, 0, 1, 1, 0, 2, 2, 2, 1, 1, 1, 2, 2, 2 };
        // First approach is using 0,1 method in which we will take counter tot
        // calculate 0 and 1
        // We will use different technique
        int low = 0;// tracking 0
        int mid = 0;// tracking 1
        int high = arr.length - 1;// tracking 2;
        while (mid <= high)// while mid does't cross high...
        {
            int value = arr[mid];
            switch (value) {
                case 0:
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    swap(arr, mid, high);
                    high--;
                    break;
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
