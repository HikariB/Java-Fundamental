package com.hbLib.LeetCode.backTrack;

public class FloodFill {
    static int[][] dirs = new int[][]{
            {-1, 0},    //up
            {0, 1},     //right
            {1, 0},     //down
            {0, -1}     //left
    };

    int rowLen;
    int colLen;
    boolean[][] isVisited;

    boolean inArea(int row, int col) {
        return row >= 0 && row < rowLen && col >= 0 && col < colLen;
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        rowLen = grid.length;
        colLen = grid[0].length;
//        isVisited = new boolean[rowLen][colLen];
        int res = 0;
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (grid[row][col] == '1') {
                    res++;
                    dfs(grid, row, col);
                }
            }
        }
        return res;

    }

    private void dfs(char[][] grid, int row, int col) {
        grid[row][col] = '0';
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dirs[i][0];
            int nextCol = col + dirs[i][1];
            if (inArea(nextRow, nextCol) && grid[nextRow][nextCol] == '1') {
                dfs(grid, nextRow, nextCol);
            }
        }
    }
}
