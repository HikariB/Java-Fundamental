package com.hbLib.LeetCode.backTrack;

import java.util.LinkedList;
import java.util.List;

public class NQueens {

    boolean[] col;  //标记 [列] 是否被占用
    boolean[] dia1; //标记 [对角线1 i+j = 定值]
    boolean[] dia2; //标记 [对角线2 i-j = 定值]

    //表示每行 Queen 放在第几列
    List<List<Integer>> queenCol;

    public List<List<String>> solveNQueens(int n) {
        // n = 1 [[Q]]
//        if (n < 4)
//            return null;
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];   // i - j + n - 1
        LinkedList<Integer> pre = new LinkedList<>();
        queenCol = new LinkedList<>();
        putQueen(n, 0, pre);

        return getStringFromQueenCol(n);
    }


    private void putQueen(int n, int row, LinkedList<Integer> pre) {
        if (pre.size() == n) {
            queenCol.add(new LinkedList<>(pre));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!this.col[col] && !dia1[row + col] && !dia2[row - col + n - 1]) {
                pre.addLast(col);
                this.col[col] = true;
                dia1[col + row] = true;
                dia2[row - col + n - 1] = true;
                putQueen(n, row + 1, pre);
                this.col[col] = false;
                dia1[col + row] = false;
                dia2[row - col + n - 1] = false;
                pre.removeLast();
            }
        }
    }

    private List<List<String>> getStringFromQueenCol(int n) {
        List<List<String>> res = new LinkedList<>();
        if (queenCol.size() > 0) {
            for (List<Integer> colList : queenCol) {
                List<String> solution = new LinkedList<>();
                for (int col : colList) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < n; i++) {
                        if (i == col)
                            sb.append('Q');
                        else
                            sb.append('.');
                    }
                    solution.add(sb.toString());
                }
                res.add(solution);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> ans = new NQueens().solveNQueens(6);
        System.out.println(ans);
    }

}
