package com.hbLib.LeetCode._1ArrayAndString;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] column = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] += 1;
                    column[j] += 1;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (row[i] > 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (column[i] > 0)
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
        }
    }

    public void setZeroes2(int[][] matrix) {
        boolean isFirstRowZero = false;
        boolean isFirstColumnZero = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (i == 0)
                        isFirstRowZero = true;
                    if (j == 0)
                        isFirstColumnZero = true;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0)
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
        }

        if (isFirstColumnZero)
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        if (isFirstRowZero)
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }

    }

    public static void main(String[] args) {
        int[][] a = {{0, 1, 2, 0},{3, 4, 5, 2},{1, 3, 1, 5}};
        SetZeroes setZeroes = new SetZeroes();
        setZeroes.setZeroes2(a);
    }


}
