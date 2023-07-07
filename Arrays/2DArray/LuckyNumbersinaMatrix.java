import java.util.ArrayList;

public class LuckyNumbersinaMatrix {
    public ArrayList<Integer> luckyNumbers(int[][] matrix) {
        // Finding all minimum values rowwise
        ArrayList<Integer> minValue = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int minRow = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                minRow = Math.min(minRow, matrix[i][j]);
            }
            minValue.add(minRow);
        }
        ArrayList<Integer> maxValue = new ArrayList<>();
        for (int i = 0; i < matrix[0].length; i++) {
            int maxCol = Integer.MIN_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                maxCol = Math.max(maxCol, matrix[j][i]);
            }
            maxValue.add(maxCol);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int min : minValue) {
            if (maxValue.contains(min))
                ans.add(min);
        }
        return ans;
    }
}
