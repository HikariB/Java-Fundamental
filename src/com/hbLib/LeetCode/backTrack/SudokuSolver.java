package com.hbLib.LeetCode.backTrack;

import java.util.Arrays;

public class SudokuSolver {

    boolean[][] rowMemo = new boolean[9][10];
    boolean[][] colMemo = new boolean[9][10];
    boolean[][] boxMemo = new boolean[9][10];


    public void solveSudoku(char[][] board) {
        int toBeSet = 0;
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    rowMemo[row][board[row][col] - '0'] = true;
                    colMemo[col][board[row][col] - '0'] = true;
                    boxMemo[row / 3 * 3 + col / 3][board[row][col] - '0'] = true;
                } else
                    toBeSet++;
            }
        }
        process(board, toBeSet, 0, 0);
    }

    private boolean process(char[][] board, int toBeSet, int startRow, int startCol) {
        if (toBeSet == 0)
            return true;

        for (int row = startRow; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // find .
                if (board[row][col] == '.') {
                    for (int num = 1; num <= 9; num++) {
                        if (!rowMemo[row][num]
                                && !colMemo[col][num]
                                && !boxMemo[row / 3 * 3 + col / 3][num]) {
                            // set
                            board[row][col] = (char) ('0' + num);
                            rowMemo[row][num] = true;
                            colMemo[col][num] = true;
                            boxMemo[row / 3 * 3 + col / 3][num] = true;
                            toBeSet--;
                            if (process(board, toBeSet, row, col)) {
                                return true;
                            }
                            rowMemo[row][num] = false;
                            colMemo[col][num] = false;
                            boxMemo[row / 3 * 3 + col / 3][num] = false;
                            board[row][col] = '.';
                            toBeSet++;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println((char) ('1' + 3));

        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        new SudokuSolver().solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));

        }

    }
}
