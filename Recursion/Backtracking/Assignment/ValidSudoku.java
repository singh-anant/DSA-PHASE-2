class Solution {
    char[][] board;

    private boolean isPresentInRow(int row, char value) {
        // IN a Row Traverse in Each Col
        for (int col = 0; col < 9; col++) {
            if (board[row][col] == value) {
                return true;
            }
        }
        return false;
    }

    private boolean isPresentInCol(int col, char value) {
        // IN a Row Traverse in Each Col
        for (int row = 0; row < 9; row++) {
            if (board[row][col] == value) {
                return true;
            }
        }
        return false;
    }

    private boolean isPresentInSubGrid(int row, int col, char value) {
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == value) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCorrectToPlaceANumber(int row, int col, char value) {
        return !isPresentInRow(row, value) && !isPresentInCol(col, value) && !isPresentInSubGrid(row, col, value);
        // The Value is Present in Row
        // The Value is Present in Col
        // The Value is Present in SubGrid
    }

    private boolean traversingSudoku(int row, int col) {
        // if we reach to last column , then move to the next row
        if (col == 9) {
            // Jump to the Next Row
            row = row + 1;
            col = 0;
        }
        // if we cross the last row +1 (9) , we solve the sudoku (Termination Case)
        if (row == 9) { // Termination Case
            return true;
        }
        if (board[row][col] == '.')
            return traversingSudoku(row, col + 1);

        if (isCorrectToPlaceANumber(row, col, board[row][col]) == false)
            return false;

        return traversingSudoku(row, col + 1);

    }

    public boolean isValidSudoku(char[][] board) {
        this.board = board;
        return traversingSudoku(0, 0);
    }
}