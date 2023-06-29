
public class FirstUniqueCharacter {
    public static void main(String[] args) {
        String str = "abgcabcdefefa";
        int hash[] = new int[26];
        int pos[] = new int[26];

        for (int i = 0; i < str.length(); i++) {
            hash[(int) str.charAt(i) - 97]++;
            pos[(int) str.charAt(i) - 97] = i;
        }
        for (int i : hash) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : pos) {
            System.out.print(i + " ");
        }
        char ch = '\u0000';
        int charpos = Integer.MAX_VALUE;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == 1) {
                if (charpos > pos[i]) {
                    ch = (char) (97 + i);
                    charpos = pos[i];

                }

            }
        }
        System.out.println(ch);
    }
}
