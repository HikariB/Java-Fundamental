package com.hbLib.LeetCode;

// 注意判例 [1, 1] [1,5,1]即相等的情况

// 基本思路是找到第一个递减的点即为pivot，和后续刚好超过(严格大于) pivot的值交换，交换后，pivot后续的序列为非递增序列，需要逆序得到最小

import java.util.LinkedList;
import java.util.List;

public class NextPermutation {
    public void nextPermutation_31(int[] nums) {
        int len = nums.length;
        int cur = len - 1;
        // 找到第一个递减的点
        while (cur - 1 >= 0 && nums[cur] <= nums[cur - 1]) {
            cur--;
        }
        if (cur == 0) {
            swapSegment(nums, 0, len - 1);
            return;
        } else {
            // 若存在 记为pivot
            int pivot = cur - 1;
            cur = len - 1;
            // 找到刚好大于 pivot的值
            while (cur >= 1 && nums[cur] <= nums[pivot]) {
                cur--;
            }
            int temp = nums[cur];
            nums[cur] = nums[pivot];
            nums[pivot] = temp;
            //
            swapSegment(nums, pivot + 1, len - 1);
        }
    }

    //reverse
    public void swapSegment(int[] arr, int from, int to) {
        if (from > to)
            throw new IllegalArgumentException();
        int temp;
        while (from < to) {
            temp = arr[from];
            arr[from] = arr[to];
            arr[to] = temp;
            from++;
            to--;
        }
    }


    String res = "";
    int kth;

    // kth permutation
    public String getPermutation_60(int n, int k) {
        if (n == 1)
            return "1";
        LinkedList<String> pre = new LinkedList<>();
        boolean[] isUsed = new boolean[n + 1];
        kth = k;
        getPermutation_60(n, pre, isUsed);
        return res;

    }

    private void getPermutation_60(int n, LinkedList<String> pre, boolean[] isUsed) {

        if (kth == 0) {
            return;
        }
        if (pre.size() == n) {
            kth--;
            if (kth == 0) {
                res = String.join("", pre);
            }
            return;
        }


        for (int i = 1; i <= n; i++) {
            if (!isUsed[i]) {
                pre.addLast(String.valueOf(i));
                isUsed[i] = true;
                getPermutation_60(n, pre, isUsed);
                isUsed[i] = false;
                pre.removeLast();
            }
        }

    }

    public static void main(String[] args) {
        new NextPermutation().getPermutation_60(3, 3);
    }
}
