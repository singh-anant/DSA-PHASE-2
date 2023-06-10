public class SquarePattern {

    static void squarePattern(int row, int stars) {

        // Termination Case
        if (row == 0)
            return;
        for (int i = 0; i < stars; i++) {
            System.out.print("*");
        }

        System.out.println();
        squarePattern(row - 1, stars);
    }

    public static void main(String[] args) {
        squarePattern(5, 5);
    }
}
