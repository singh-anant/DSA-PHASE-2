import java.util.ArrayList;

public class LongestCommonSubsequence {
    private static void storeSubsequence(String str, ArrayList<String> ss) {
        for (int i = 0; i < str.length(); i++) {
            char firstCharacter = str.charAt(i);
            if (ss.size() == 0) {
                ss.add(" ");
                ss.add("" + firstCharacter);
                continue;
            }
            int listsize = ss.size();
            for (int j = 0; j < listsize; j++) {
                String temp = ss.get(j) + firstCharacter;
                ss.add(temp);
            }
        }
    }

    public static void main(String[] args) {
        String str1 = "abcdxy";
        String str2 = "abc";
        ArrayList<String> ss1 = new ArrayList<>();
        ArrayList<String> ss2 = new ArrayList<>();
        storeSubsequence(str1, ss1);
        storeSubsequence(str2, ss2);
        /*
         * System.out.println(ss1);
         * System.out.println(ss2);
         */
        String lcs = "";
        for (int i = 0; i < ss1.size(); i++) {
            if (ss2.contains(ss1.get(i)))
                lcs = ss1.get(i);
        }

    }
}
