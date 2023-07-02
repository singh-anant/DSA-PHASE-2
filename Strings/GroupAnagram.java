public class GroupAnagram {
    // This is first approach.....
    private static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
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
                return false;
            }
        }
        return true;
    }

    /*
     * public static void main(String[] args) {
     * String arr[] = { "act", "dog", "cat", "god", "mic", "icm" };
     * for (int i = 0; i < arr.length; i++) {
     * for (int j = i + 1; j < arr.length; j++) {
     * if (isAnagram(arr[i], arr[j])) {
     * System.out.println(arr[i]);
     * break;
     * }
     * }
     * }
     * }
     */
    // 2nd approach could be we could sort both string and the array
    private static String sortWord(String s) {
        char arr[] = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    char temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }

        }
        s = "";
        for (char c : arr) {
            s += c;
        }
        return s;
        // System.out.println(s);
    }

    public static void sortArray(String arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    String temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        String arr[] = { "act", "dog", "cat", "god", "mic", "icm" };
        String clone[] = { "act", "dog", "cat", "god", "mic", "icm" };
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortWord(arr[i]);
        }
        /*
         * for (int i = 0; i < arr.length; i++) {
         * System.out.print(arr[i] + " ");
         * }
         */
        sortArray(arr);
        sortArray(clone);
        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].equals(arr[i + 1])) {
                System.out.print(clone[i] + " ");
            }
        }
    }

}
