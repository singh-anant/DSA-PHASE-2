public class Permutation {

    static void printPermutation(String str, String result) {
        if (str.length() == 0) {
            System.out.print(result + " ");
            return;
        }

        char firstChar = str.charAt(0);
        String smallString = str.substring(1);
        for (int i = 0; i <= smallString.length(); i++) {
            StringBuilder sb = new StringBuilder(smallString);
            sb.insert(i, firstChar);
            printPermutation(smallString, sb.toString());
        }
    }

    // static void printPermutation(String str, String result) {
    /* Base case: If the input string is empty, we have reached a permutation */
    /*
     * if (str.length() == 0) {
     * System.out.print(result + " ");
     * return;
     * }
     */

    /*
     * Recursive case: Iterate through each character in the input string
     * and generate permutations by appending each character to the result
     * and recursively calling the function with the remaining characters.
     */
    /*
     * for (int i = 0; i < str.length(); i++) {
     * char ch = str.charAt(i);
     * String remaining = str.substring(0, i) + str.substring(i + 1);
     * 
     * printPermutation(remaining, result + ch);
     * }
     * }
     */

    public static void main(String[] args) {
        printPermutation("abc", "");
    }
}
