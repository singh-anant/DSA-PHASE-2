import java.util.ArrayList;

public class PrintMatrixinsnakePattern {
    // Function to return list of integers visited in snake pattern in matrix.
    static ArrayList<Integer> snakePattern(int matrix[][]) {
        ArrayList<Integer> snakelist = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix.length; j++)
                    snakelist.add(matrix[i][j]);
            } else {
                for (int j = matrix.length - 1; j >= 0; j--)
                    snakelist.add(matrix[i][j]);
            }
        }
        return snakelist;
    }
}
