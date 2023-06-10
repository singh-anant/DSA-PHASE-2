public class CapitalizeArray {
    static String[] printCapitalizeArray(String arr[], int index, int n) {
        if (index == arr.length) {
            String str[] = new String[n];
            return str;
        }

        String str[] = printCapitalizeArray(arr, index + 1, n);

        str[index] = arr[index].toUpperCase();
        return str;
    }

    public static void main(String[] args) {
        String arr[] = { "foo", "bar", "world" };
        String ans[] = printCapitalizeArray(arr, 0, arr.length);
        for (String string : ans) {
            System.out.println(string);
        }
    }
}
