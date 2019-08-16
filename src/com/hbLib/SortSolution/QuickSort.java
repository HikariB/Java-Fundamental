package com.hbLib.SortSolution;

import java.util.Arrays;

public class QuickSort extends ArraySort {
    @Override
    public int[] sort(int[] pArr) {
        int[] resArr = Arrays.copyOf(pArr, pArr.length);
        if (pArr.length <= 1)
            return pArr;

        sort(resArr, 0, pArr.length - 1);
        return resArr;

    }

    private void sort(int[] resArr, int from, int to) {
        if (from >= to)
            return;
        // 确定第一个元素的位置
        int middle = (from + to) / 2;
        setFirstMiddle(resArr, from, middle, to);
        int pivot = resArr[from];
        int insertPivot = partion(resArr, from, to);
        sort(resArr, from, insertPivot - 1);
        sort(resArr, insertPivot + 1, to);
    }

    // 参考网上
    // 数字交换过程更巧妙
    // 注意条件判断，相等的情况发生；注意时从尾部先移动，若从头部先移动，则插入位置永远不会出现在头部
    // 不稳定

    private int partion2(int[] resArr, int from, int to) {
        int pivot = resArr[from];
        while (from < to) {
            while (resArr[to] >= pivot && to > from) {
                to--;
            }
            resArr[from] = resArr[to];
            while (resArr[from] <= pivot && to > from) {
                ++from;
            }
            resArr[to] = resArr[from];
        }
        resArr[from] = pivot;
        return from;
    }


    private void setFirstMiddle(int[] resArr, int from, int middle, int to) {
        //头 不能最大
        if (resArr[from] > resArr[to] && resArr[from] > resArr[middle]) {
            if (resArr[middle] >= resArr[to])
                swap(resArr, from, middle);
            else
                swap(resArr, from, to);
        }
        //头 不能最小
        if (resArr[from] < resArr[to] && resArr[from] < resArr[middle]) {
            if (resArr[middle] > resArr[to])
                swap(resArr, from, to);
            else
                swap(resArr, from, middle);
        }
    }


    private int partion(int[] resArr, int from, int to) {
        // 记录初始位置
        int pivot = from;
        // 相等的时候表示已找到 pivot的位置
        while (from < to) {
            // 从末尾开始
            // 注意全部元素相等时造成的越界 -1
            while (resArr[to] >= resArr[pivot] && to > from)
                to--;
            while (resArr[from] <= resArr[pivot] && to > from)
                from++;
            if (to > from){
                swap(resArr,to,from);
            }
        }
        swap(resArr,from,pivot);
        return from;
    }


}
