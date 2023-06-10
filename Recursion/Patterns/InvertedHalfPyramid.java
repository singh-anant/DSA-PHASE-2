public class InvertedHalfPyramid {
    static void printStars(int stars) {
        if (stars == 0)
            return;
        System.out.print("*");
        printStars(stars - 1);
    }

    static void printInvertedHalfPyramid(int row, int stars) {
        if (row == 0)
            return;
        System.out.println();
        printStars(stars);
        printInvertedHalfPyramid(row - 1, stars - 1);

    }

    public static void main(String[] args) {
        printInvertedHalfPyramid(5, 5);
    }

}
