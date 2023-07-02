public class PrintPrefix {
    public static void main(String[] args) {
        String str = "abcd";
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            ans += str.charAt(i);
            System.out.print(ans + " ");
        }
    }
}
