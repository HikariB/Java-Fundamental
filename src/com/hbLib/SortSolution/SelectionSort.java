package com.hbLib.SortSolution;

import java.util.Arrays;

public class SelectionSort extends ArraySort {
    @Override
    public int[] sort(int[] pArr) {
        if (pArr == null || pArr.length <= 1)
            return pArr;
        int[] resArr = Arrays.copyOf(pArr, pArr.length);

        //两重循环
        //内循环确定最小或者最大的数
        int minIndex;
        for (int i = 0; i < resArr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < resArr.length; j++) {
//                min = Math.min(min,resArr[j]);
                if (resArr[minIndex] > resArr[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex)
                swap(resArr, i, minIndex);
        }
        return  resArr;
    }
}
