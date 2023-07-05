public class RabinKarpAlgorithm {
    static long HashFunction(String text) {
        long hashValue = 0;
        for (int i = 0; i < text.length(); i++) {
            int code = text.charAt(i) - 97;
            hashValue += code * Math.pow(10, text.length() - 1 - i);
        }
        return hashValue;
    }

    static int searchPattern(String text, String pattern) {
        int textlength = text.length();
        int patternlength = pattern.length();
        long patternHashCode = HashFunction(pattern);

        for (int i = 0; i < textlength - patternlength; i++) {
            long textHashCode = HashFunction(text.substring(i, i + patternlength));
            if (patternHashCode == textHashCode && pattern.equals(text.substring(i, i + patternlength))) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String text = "abbccccabbbcca";
        String pattern = "cca";
        System.out.println(searchPattern(text, pattern));
    }
}
