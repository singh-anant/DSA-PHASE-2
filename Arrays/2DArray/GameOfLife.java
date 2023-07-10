import java.util.ArrayList;

public class GameOfLife {
    private static int totalNeighbours(int[][] board, int row, int col) {
        int totalLive = 0;
        // check for horizontal neighbours
        if (col - 1 >= 0) {
            if (board[row][col - 1] == 1)
                totalLive++;
        }
        if (col + 1 < board[0].length) {
            if (board[row][col + 1] == 1) {
                totalLive++;
            }
        }
        // vertical
        if (row - 1 >= 0) {
            if (board[row - 1][col] == 1) {
                totalLive++;
            }
        }
        if (row + 1 < board.length) {
            if (board[row + 1][col] == 1) {
                totalLive++;
            }
        }
        // diagonal
        if (row - 1 >= 0 && col - 1 >= 0) {
            if (board[row - 1][col - 1] == 1) {
                totalLive++;
            }
        }
        if (row - 1 >= 0 && col + 1 < board[0].length) {
            if (board[row - 1][col + 1] == 1) {
                totalLive++;
            }
        }
        if (row + 1 < board.length && col - 1 >= 0) {
            if (board[row + 1][col - 1] == 1) {
                totalLive++;
            }
        }
        if (row + 1 < board.length && col + 1 < board[0].length) {
            if (board[row + 1][col + 1] == 1) {
                totalLive++;
            }
        }
        return totalLive;

    }

    public void gameOfLife(int[][] board) {
        // calculting the total neighbours
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    if (totalNeighbours(board, i, j) < 2)
                        arr.add(0);
                    else if (totalNeighbours(board, i, j) == 2 || totalNeighbours(board, i, j) == 3)
                        arr.add(1);
                    else if (totalNeighbours(board, i, j) > 3)
                        arr.add(0);
                } else if (board[i][j] == 0) {
                    if (totalNeighbours(board, i, j) == 3)
                        arr.add(1);
                    else
                        arr.add(0);
                }
            }
        }
        int c = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = arr.get(c++);
            }
        }
    }
}
