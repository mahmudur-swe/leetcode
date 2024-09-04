class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length - 1;
        int offset = 0;

        for (int i = offset; i + offset < n; i++) {

            for (int j = offset; j + offset < n; j++) {

                int l = i;
                int m = j;

                System.out.print("n = " + n + "  " + offset + " : " + "\n");
                System.out.print(i + "  " + j + " : " + (matrix[i][j]) + "\n");
                System.out.print(m + "  " + (n - offset) + " : " + (matrix[m][n - offset]) + "\n");
                System.out.print((n - offset) + "  " + (n - j) + " : "
                            + (matrix[n - offset][n - j]) + "\n");
                    System.out.print(
                            (n - j) + "  " + offset + " : " + (matrix[n - j][offset]) + "\n");

                int tmp = matrix[m][n - offset];

                matrix[m][n - offset] = matrix[i][j];

                int subtmp = matrix[n - offset][n - j];

                matrix[n - offset][n  - j] = tmp;

                tmp = subtmp;

                subtmp = matrix[n - j][offset];

                matrix[n - j][offset] = tmp;

                tmp = subtmp;

                matrix[i][j] = tmp;

            }

            offset ++;
           

        }

    }
}