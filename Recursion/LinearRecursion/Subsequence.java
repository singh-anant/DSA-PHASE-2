import java.util.ArrayList;

public class Subsequence {

    static ArrayList<String> printSubsequence(String str) {
        if (str.length() == 0) {
            ArrayList<String> arr = new ArrayList<>();
            arr.add("");
            return arr;
        }

        ArrayList<String> finalResult = new ArrayList<>();
        char firstChar = str.charAt(0);
        ArrayList<String> arr = printSubsequence(str.substring(1));
        for (String t : arr) {
            // Not Include
            finalResult.add(t);
            // Include
            finalResult.add(firstChar + t);
        }
        return finalResult;

    }

    public static void main(String[] args) {
        System.out.println(printSubsequence("anant"));
    }
}
