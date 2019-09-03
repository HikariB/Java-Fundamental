package com.hbLib.LeetCode.backTrack;

public class FindWordsInGrid {
    static int[][] dirs = new int[][]{
            {-1, 0},    //up
            {0, 1},     //right
            {1, 0},     //down
            {0, -1}     //left
    };

    int rowLen;
    int colLen;
    boolean[][] isVisited;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null)
            return false;
        rowLen = board.length;
        colLen = board[0].length;
        isVisited = new boolean[rowLen][colLen];

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                isVisited[row][col] = true;
                if (process(board, word, row, col, 0))
                    return true;
                isVisited[row][col] = false;
            }
        }
        return false;
    }

    private boolean process(char[][] board, String word, int row, int col, int cur) {

        if (board[row][col] != word.charAt(cur)) {
            return false;
        }

        if (cur == word.length() - 1)
            return true;

        // 从4个方向中寻找下一个 char
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dirs[i][0];
            int nextCol = col + dirs[i][1];
            if (inArea(nextRow, nextCol) && !isVisited[nextRow][nextCol]) {
                isVisited[nextRow][nextCol] = true;
                if (process(board, word, nextRow, nextCol, cur + 1)) {
                    return true;
                }
                isVisited[nextRow][nextCol] = false;
            }
        }
        return false;
    }

    private boolean inArea(int row, int col) {
        return row >= 0 && row < rowLen && col >= 0 && col < colLen;
    }
}
