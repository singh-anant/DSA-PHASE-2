public class DiagonalProblemVoid {
    static void getMazePos(int currentRow, int currentCol, int endRow, int endCol, String result) {
        // Termination Case (Positive Case and Negative Case)
        // Positive Case
        if (currentCol == endCol && currentRow == endRow) {
            System.out.print(result + " ");
            return;
        }
        // Negative Case
        if (currentCol > endCol || currentRow > endRow) {
            return;
        }
        getMazePos(currentRow, currentCol + 1, endRow, endCol, result + "R");
        getMazePos(currentRow + 1, currentCol, endRow, endCol, result + "D");
        getMazePos(currentRow + 1, currentCol + 1, endRow, endCol, result + "I");

    }

    public static void main(String[] args) {
        getMazePos(0, 0, 2, 2, "");
    }
}
