class Solution {

    static boolean isAccepted(char[][] board, int row, int col, char ch) {
        if (row < board.length && col < board[row].length && col > 0 && board[row][col] == ch)
            return true;

        return false;
    }

    static boolean existHelper(char[][] board, int row, int col, String word, StringBuilder sb, int index) {
        if (word == sb.toString()) {
            if (index == word.length() - 1)
                return true;

        }
        System.out.println(sb);

        if (isAccepted(board, row, col, word.charAt(index))) {
            sb.append(board[row][col]);
            // if(existHelper(board,row-1,col,word,sb,index+1))
            // return true;
            if (existHelper(board, row, col + 1, word, sb, index + 1))
                return true;
            if (existHelper(board, row, col - 1, word, sb, index + 1))
                return true;
            if (existHelper(board, row + 1, col, word, sb, index + 1))
                return true;
            sb.deleteCharAt(sb.length() - 1);

        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        StringBuilder sb = new StringBuilder();
        return existHelper(board, 0, 0, word, sb, 0);
    }
}