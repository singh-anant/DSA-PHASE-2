public class DecimalToBinary {
    public static void main(String[] args) {
        int n = 12;
        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            int bit = n & 1;
            ans.append(bit);
            n = n >> 1;
        }
        System.out.println(ans.reverse().toString());
    }
}
