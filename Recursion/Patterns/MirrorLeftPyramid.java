public class MirrorLeftPyramid {
    static void printStars(int stars, int rows) {
        if (stars == 0)
            return;

        printStars(stars - 1, rows);
        if (rows < 6 - stars)
            System.out.print(" ");
        else
            System.out.print("* ");
    }

    static void printMirrorLeftPyramid(int rows, int stars) {
        if (rows == 0)
            return;

        printMirrorLeftPyramid(rows - 1, stars);
        System.out.println();
        printStars(stars, rows);

    }

    public static void main(String[] args) {
        printMirrorLeftPyramid(5, 5);
    }
}
