public class RunningLengthEncoding {
    public static void main(String[] args) {
        String str = "aaaaaabbbbbbbbcccccccccc";
        int hash[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            hash[(int) str.charAt(i) - 97]++;
        }

        String ans = "";
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > 0) {
                char ch = (char) (97 + i);
                ans = ans + ch + hash[i];
            }

        }
        System.out.println(ans);

    }
}
