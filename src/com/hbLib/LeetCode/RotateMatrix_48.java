package com.hbLib.LeetCode;

public class RotateMatrix_48 {

    // in place
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int len = matrix.length;

        // 转置 i,j --> j,i
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse
        for (int i = 0; i < len; i++) {
            int left = 0;
            int right = len - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }

        return;

    }

    public void rotate2(int[][] matrix) {


    }
}
