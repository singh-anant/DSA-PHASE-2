import java.util.ArrayList;

public class Permutation {
    static ArrayList<String> printPermutation(String str) {
        // Base Condition
        if (str.length() == 0) {
            ArrayList<String> arr = new ArrayList<>();
            arr.add("");
            return arr;

        }

        ArrayList<String> result = new ArrayList<>();
        char firstChar = str.charAt(0);
        ArrayList<String> arr = printPermutation(str.substring(1));
        // Post process
        for (String t : arr) {
            /*
             * Here we have to insert the first character in every position of the element
             * of the list which is a String
             */
            for (int i = 0; i <= t.length(); i++) {
                // Since String will get modified so we will use StringBuffer or String Builder
                StringBuilder sb = new StringBuilder(t);
                sb.insert(i, firstChar);
                result.add(sb.toString());
            }

        }
        return result;

    }

    public static void main(String[] args) {

        System.out.println(printPermutation("abc"));
    }
}
