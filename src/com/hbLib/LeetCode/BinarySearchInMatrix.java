package com.hbLib.LeetCode;

import java.util.PriorityQueue;

public class BinarySearchInMatrix {

    static class Node implements Comparable<Node> {
        int value;
        int rowIndex;
        int colIndex;

        public Node(int value, int rowIndex, int colIndex) {
            this.value = value;
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {

        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        PriorityQueue<Node> pq = new PriorityQueue<>(rowLen);

        for (int i = 0; i < rowLen; i++) {
            pq.offer(new Node(matrix[i][0], i, 0));
        }
        for (int i = 0; i < k-1; i++) {
            Node node = pq.poll();
            int nextRow = node.rowIndex;
            int nextCol = node.colIndex + 1;
            if (nextCol < colLen) {
                pq.offer(new Node(matrix[nextRow][nextCol],nextRow, nextCol));
            }
        }
        return pq.poll().value;

    }

    public int kthSmallest2(int[][] matrix, int k) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int min = matrix[0][0];
        int max = matrix[rowLen-1][colLen-1];
        int mid = 0;
        while(min < max){
            // mid = (max + min)/2;
            mid = min + (max - min) /2;
            int cnt = helper(matrix,mid);
            if (cnt < k){
                min = mid+1;
            } else {
                max = mid;
            }

        }
        return max;
    }

    // 找到小于等于K的元素个数
    public int helper(int[][]matrix, int k){
        int i = matrix.length-1;
        int j = 0;
        int sum = 0;
        while(i >= 0 && j < matrix[0].length){
            if(k >= matrix[i][j]){
                sum += i+1;
                j++;
            }
            else
                i--;
        }
        return sum;

    }

}
