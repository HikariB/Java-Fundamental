package com.hbLib.SortSolution;

import java.util.Arrays;

/**
 * 只开辟一个临时数组tempArr，每次merge都将结果先保存在 tempArr,然后复制回原数组
 */


public class MergeSort2 extends ArraySort{
    @Override
    public int[] sort(int[] pArr) {
        int[] resArr = Arrays.copyOf(pArr, pArr.length);
        if (pArr.length <= 1)
            return resArr;

        int[] tempArr = new int[pArr.length];
        mergeSort(resArr, tempArr, 0, resArr.length);
        return resArr;
    }

    private void mergeSort(int[] fromArr, int[] tempArr, int head, int tail) {
        if (tail == head)
            return;
        int middle = (head + tail) / 2;
        mergeSort(fromArr, tempArr, 0, middle);
        mergeSort(fromArr, tempArr, middle, tail);
        merge(fromArr, tempArr, head, middle, tail);
    }

    private void merge(int[] fromArr, int[] tempArr, int head, int middle, int tail) {
        int i = head;
        int j = middle;
        int k = head;
        while (i < middle && j < tail) {
            if (fromArr[i] <= fromArr[j])
                tempArr[k++] = fromArr[i++];
            else
                tempArr[k++] = fromArr[j++];
        }

        while (i < middle)
            tempArr[k++] = fromArr[i++];
        while (j < tail)
            tempArr[k++] = fromArr[j++];
        for (int l = head; l < tail; l++) {
            fromArr[l] = tempArr[l];
        }

    }
}
