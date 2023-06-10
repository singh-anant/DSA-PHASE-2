public class LeftPyramid {

    static void printStars(int stars) {
        if (stars == 0)
            return;
        System.out.print("*");
        printStars(stars - 1);
    }

    static void printLeftPyramid(int row, int stars) {
        if (row == 0)
            return;
        printLeftPyramid(row - 1, stars - 1);
        System.out.println();
        printStars(stars);

    }

    public static void main(String[] args) {
        printLeftPyramid(5, 5);
    }
}
