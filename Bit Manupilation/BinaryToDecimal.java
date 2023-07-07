public class BinaryToDecimal {
    public static void main(String[] args) {
        String bin = "100";
        int mask = 0;
        int ans = 0;
        for (int i = bin.length() - 1; i >= 0; i--) {
            int bit = bin.charAt(i) - '0';
            ans += bit << mask++;

        }
        System.out.println(ans);
    }
}
