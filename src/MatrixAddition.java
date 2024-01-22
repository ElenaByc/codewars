/*
6 kyu
Matrix Addition
https://www.codewars.com/kata/526233aefd4764272800036f
 */

import java.util.Arrays;

public class MatrixAddition {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(matrixAddition(
                new int[][]{{1, 2, 3}, {3, 2, 1}, {1, 1, 1}},
                new int[][]{{2, 2, 1}, {3, 2, 3}, {1, 1, 3}})));
        // { { 3, 4, 4 }, { 6, 4, 4 }, { 2, 2, 4 } }
    }

    public static int[][] matrixAddition(int[][] a, int[][] b) {
        int n = a.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }

        return result;
    }

}
