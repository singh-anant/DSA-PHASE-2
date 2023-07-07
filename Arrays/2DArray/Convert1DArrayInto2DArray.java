public class Convert1DArrayInto2DArray {
    public int[][] construct2DArray(int[] original, int m, int n) {
        // List<Integer> list=new ArrayList<>();
        if (original.length != m * n)
            return new int[0][0];
        int c = 0;
        int ans[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                ans[i][j] = original[c++];
        }
        // Using single loop
        /*
         * int row=0,col=0;
         * for(int i=0;i<original.length;i++){
         * ans[row][col]=original[i];
         * col++;
         * if(col>=n){
         * row++;
         * col=0;
         * }
         * }
         */
        return ans;

    }
}
