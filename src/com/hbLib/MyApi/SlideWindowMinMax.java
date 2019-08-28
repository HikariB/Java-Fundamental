package com.hbLib.MyApi;

import java.util.LinkedList;

public class SlideWindowMinMax {

    /**
     * Code_05_AllLessNumSubArray
     * 子数组中的最大和最小值之差小于给定值的 情况和
     */

    public static int AllLessNumSubArray(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        // Core Structure
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();

        //左右指针只能往右移动
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                // 添加的逻辑
                // 后进的反而更小的，那么前面更大的时不可能成为滑窗中最小的
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);

                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);

                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    break;
                }
                j++;
            }
            // 左指针右移减少逻辑，检查头部是否过期
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
            res += j - i;
            i++;
        }
        return res;
    }
}
