public class PrintSuffex {
    public static void main(String[] args) {
        String str = "abcd";
        String ans = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            ans = str.charAt(i) + ans;
            System.out.print(ans + " ");
        }
    }
}
