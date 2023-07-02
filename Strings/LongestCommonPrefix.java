
public class LongestCommonPrefix {
    private static void sortString(String arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1].length() > arr[j].length()) {
                    String temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Arraysize is not fixed
        String arr[] = { "lists", "listen", "lies" };
        // First we can sort the array according to the length of array
        sortString(arr);
        // StringBuilder sb=new StringBuilder(arr[0]);
        String checkString = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int p1 = 0;
            while (p1 < checkString.length()) {
                if (checkString.charAt(p1) != arr[i].charAt(p1)) {
                    checkString = checkString.substring(0, p1);
                    break;
                }
                p1++;

            }
        }
        System.out.println(checkString);

    }
}
