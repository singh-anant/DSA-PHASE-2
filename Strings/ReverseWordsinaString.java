import java.util.ArrayList;

class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        ArrayList<String> list = new ArrayList<>();
        String str[] = s.split(" ");
        String ans = "";
        for (String sp : str) {
            if (sp.compareTo("") == 0) {
                System.out.println("**");
                continue;
            } else
                list.add(sp);
        }
        System.out.println(list);
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i == 0)
                ans = ans + list.get(i);
            else
                ans = ans + list.get(i) + " ";
        }
        return ans;
    }
}