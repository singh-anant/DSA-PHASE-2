public class Anagram {

    public static void main(String[] args) {
        String s1 = "silent";
        String s2 = "listen";
        /*
         * if (s1.length() != s2.length()) {
         * System.out.println("Not Anagram");
         * return;
         * }
         * int hash1[] = new int[26];
         * int hash2[] = new int[26];
         * for (int i = 0; i < s1.length(); i++) {
         * hash1[(int) s1.charAt(i) - 97]++;
         * }
         * for (int i = 0; i < s2.length(); i++) {
         * hash2[(int) s2.charAt(i) - 97]++;
         * }
         * 
         * for (int i = 0; i < hash1.length; i++) {
         * if (hash1[i] != hash2[i]) {
         * System.out.println("Not Anagram");
         * return;
         * }
         * }
         * System.out.println("Anagram");
         */
        if (s1.length() != s2.length()) {
            System.out.println("Not Anagram");
            return;
        }
        int hash1[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            hash1[(int) s1.charAt(i) - 97]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            hash1[(int) s1.charAt(i) - 97]--;
        }
        for (int i : hash1) {
            if (i != 0) {
                System.out.println("Not Anagram");
                return;
            }
        }
        System.out.println("Anagram");

    }

}
