package Assignment;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    /*
     * public List<Integer> spiralOrder(int[][] matrix) {
     * List<Integer> ans=new ArrayList<>();
     * int startR=0;
     * int endR=matrix.length-1;
     * int startC=0;
     * int endC=matrix[0].length-1;
     * while(startR<=endR && startC<=endC){
     * 
     * for(int i=startC;i<=endC;i++)
     * ans.add(matrix[startR][i]);
     * 
     * for(int i=startR+1;i<=endR;i++)
     * ans.add(matrix[i][endC]);
     * 
     * for(int i=endC-1;i>=startC;i--){
     * if(startR==endR)
     * break;
     * ans.add(matrix[endR][i]);
     * }
     * 
     * 
     * for(int i=endR-1;i>=startR+1;i--){
     * if(startC==endC)
     * break;
     * ans.add(matrix[i][startC]);
     * 
     * }
     * 
     * startR++;
     * endR--;
     * startC++;
     * endR--;
     * }
     * return ans;
     * }
     */
    List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j--) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traverse Up
                for (int j = rowEnd; j >= rowBegin; j--) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }

        return res;
    }
}
