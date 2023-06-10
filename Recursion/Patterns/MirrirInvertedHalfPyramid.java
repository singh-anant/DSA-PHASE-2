public class MirrirInvertedHalfPyramid {
    static void printStars(int stars, int rows) {
        if (stars == 0)
            return;
        for (int i = 1; i < rows; i++)
            System.out.print(i);

        // System.out.print("*");
        printStars(stars - 1, rows);

    }

    static void printMirrirInvertedHalfPyramid(int rows, int stars) {
        if (rows == 0)
            return;

        printMirrirInvertedHalfPyramid(rows - 1, stars);
        printStars(stars, rows);
        System.out.println();

    }

    public static void main(String[] args) {
        printMirrirInvertedHalfPyramid(5, 5);
    }
}
