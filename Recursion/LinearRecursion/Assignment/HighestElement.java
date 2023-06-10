public class HighestElement {
    static void printHighestElement(int arr[], int index, int ans) {
        if (index == arr.length) {
            System.out.println(ans);
            return;
        }
        if (arr[index] > ans)
            ans = arr[index];
        printHighestElement(arr, index + 1, ans);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 1, 6, 2, 10 };
        printHighestElement(arr, 0, arr[0]);
    }
}
