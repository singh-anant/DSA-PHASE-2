public class Pallindrome {
    public static void main(String[] args) {
        String str = "cacu";
        int low = 0;
        int high = str.length() - 1;
        while (low < high) {
            if (str.charAt(low) != str.charAt(high)) {
                System.out.println("Not Pallindrome");
                return;
            }
            low++;
            high--;
        }
        System.out.println("Pallindrome");
    }
}
