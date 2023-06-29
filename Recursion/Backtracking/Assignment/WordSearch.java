class Solution {
    boolean[][] valid;

    public boolean exist(char[][] board, String word) {
        valid = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (check(board, i, j, 0, word))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, int row, int column, int index, String word) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length
                || board[row][column] != word.charAt(index) || valid[row][column])
            return false;

        valid[row][column] = true;
        if (check(board, row + 1, column, index + 1, word) ||
                check(board, row, column + 1, index + 1, word) ||
                check(board, row, column - 1, index + 1, word) ||
                check(board, row - 1, column, index + 1, word)) {
            return true;
        }
        valid[row][column] = false;
        return false;
    }
}