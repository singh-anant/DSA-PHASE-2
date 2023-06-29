public class RotateArray {
    private static void reverse(int arr[], int low, int high) {
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50 };
        int rotation = 2;
        rotation %= arr.length;
        if (rotation < 0)
            rotation = arr.length + rotation;
        // reversing the first Half
        reverse(arr, 0, arr.length - 1 - rotation);
        // reversing the secont half
        reverse(arr, arr.length - rotation, arr.length - 1);
        // reversing the whole array
        reverse(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
