import java.util.Stack;

public class ReverseSentence {
    /*
     * public static void main(String[] args) {
     * String arr[] = "The sky is blue".split(" ");
     * String ans = "";
     * for (int i = arr.length - 1; i >= 0; i--) {
     * if (i == 0)
     * ans += arr[i];
     * else
     * ans += arr[i] + " ";
     * }
     * System.out.println(ans);
     * }
     */

    // Stack Approach
    public static void main(String args[]) {
        String s = "The sky is blue";
        String arr[] = s.split(" ");
        Stack<String> st = new Stack<>();
        for (String str : arr)
            st.push(str);
        String result = "";

        while (!st.isEmpty())
            result += st.pop() + " ";
        result.trim();
        System.out.println(result);
    }
}