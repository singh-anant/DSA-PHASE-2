public class HollowSquare {
    static void printHollowSquare(int row, int stars) {
        // printing the number of lines
        if (row == 0)
            return;
        for (int i = 0; i < stars; i++) {
            if (row == 5 || row == 1 || i == 0 || i == 4)
                System.out.print("*");
            else
                System.out.print(" ");
        }

        System.out.println();
        printHollowSquare(row - 1, stars);
    }

    public static void main(String[] args) {
        printHollowSquare(5, 5);
    }
}
