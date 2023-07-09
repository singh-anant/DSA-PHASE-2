public class CheckIfDigitsRepeat {
    private static boolean isRepeated(int matrix[][], int max) {
        for (int i = 0; i < matrix.length; i++) {
            int hash[] = new int[max + 1];
            for (int j = 0; j < matrix[i].length; j++)
                hash[matrix[i][j]]++;
            for (int k = 0; k < hash.length; k++) {
                if (hash[k] > 1)
                    return true;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            int hash[] = new int[max + 1];
            for (int j = 0; j < matrix[i].length; j++)
                hash[matrix[j][i]]++;
            for (int k = 0; k < hash.length; k++) {
                if (hash[k] > 1)
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 2 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                max = Math.max(max, matrix[i][j]);
            }
        }

        System.out.println(isRepeated(matrix, max));

    }

}
