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
        if (resArr[from] > resArr[to] && resArr[from] > resArr[middle]) {
            if (resArr[middle] >= resArr[to])
                swap(resArr, from, middle);
            else
                swap(resArr, from, to);
        }

        if (resArr[from] < resArr[to] && resArr[from] < resArr[middle]) {
            if (resArr[middle] > resArr[to])
                swap(resArr, from, to);
            else
                swap(resArr, from, middle);
        }

    }

    private int partion(int[] resArr, int from, int to) {
        int pivot = resArr[from];
        int p1 = from + 1;
        int p2 = to;
        while (p1 <= p2) {
            while (p1 <= p2 && resArr[p1] < pivot ) {
                p1++;
            }
            while (p1 <= p2 && resArr[p2] > pivot  ) {
                p2--;
            }
            if (p2 >= p1)
                swap(resArr, p1++, p2--);
        }
        swap(resArr, from, p2);
        return p2;

    }


}
