import java.util.ArrayList;

public class PrintAllSubsequence {
    /*
     * abcd
     * " "
     * a ab ac ad abc acd abd
     * b bc bd bcd
     * c cd
     * d
     * abcd
     * 
     * 2^(length of string)
     */

    public static void main(String[] args) {
        ArrayList<String> ss = new ArrayList<>();
        String str = "abcd";

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
        System.out.println(ss);
    }
}
