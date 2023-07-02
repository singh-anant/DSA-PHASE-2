import java.util.ArrayList;

public class PallindromeSubString {
    static boolean isPallindrome(String str) {
        int low = 0;
        int high = str.length() - 1;
        while (low < high) {
            if (str.charAt(low) != str.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abbcccddd";
        ArrayList<String> arr = new ArrayList<>();
        ArrayList<String> pallindomearr = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                String temp = str.substring(i, j);
                arr.add(temp);
                if (isPallindrome(temp))
                    pallindomearr.add(temp);
            }
        }
        System.out.println(arr);
        System.out.println(pallindomearr);
    }
}