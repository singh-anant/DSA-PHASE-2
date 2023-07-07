import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {
    public int romanToInt(String s) {

        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int previous = 0;
        int ans = 0;

        /*
         * for(int i=s.length()-1; i>=0; i--){
         * int current = roman.get(s.charAt(i));
         * if(previous > current){
         * ans -= current;
         * }else{
         * ans += current;
         * }
         * previous = current;
         * }
         */

        for (int i = 0; i < s.length() - 1; i++) {
            int current = roman.get(s.charAt(i));
            int nextValue = roman.get(s.charAt(i + 1));
            if (current < nextValue) {
                ans -= current;
            } else {
                ans += current;
            }

        }

        return ans + roman.get(s.charAt(s.length() - 1));
    }
}
