
public class Pattern1 {

    static void numberOfLines(int lines, int stars) {
        if (lines == 0) {
            return;
        }
        for (int i = 0; i < stars; i++) {
            System.out.print("*");
        }
        System.out.println();
        numberOfLines(lines - 1, stars + 1);
    }

    public static void main(String[] args) {
        numberOfLines(5, 1);
    }
}
