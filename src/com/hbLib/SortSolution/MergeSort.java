package com.hbLib.SortSolution;

import java.util.Arrays;

public class MergeSort extends ArraySort {
    @Override
    public int[] sort(int[] pArr) {
        if (pArr == null || pArr.length <= 1)
            return pArr;
        int[] resArr = Arrays.copyOf(pArr, pArr.length);

        //递归的解决
        int[] left = Arrays.copyOf(resArr, pArr.length / 2);
        int[] right = Arrays.copyOfRange(resArr, pArr.length / 2, pArr.length);
//        return sort(left, right);
        return merge(sort(left),sort(right));

    }


//    private int[] sort(int[] left, int[] right) {
//        if (left.length >= 2)
//            left = sort(Arrays.copyOf(left, left.length / 2), Arrays.copyOfRange(left, left.length / 2, left.length));
//        if (right.length >= 2)
//            right = sort(Arrays.copyOf(right, right.length / 2), Arrays.copyOfRange(right, right.length / 2, right.length));
//
//        return merge(left, right);
//    }


    private int[] merge(int[] left, int[] right) {
        if (left.length == 0)
            return right;
        if (right.length == 0)
            return left;

        int[] res = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                res[k++] = left[i++];
            else
                res[k++] = right[j++];
        }

        if (i == left.length) {
            while (j < right.length)
                res[k++] = right[j++];
        } else {
            while (i < left.length)
                res[k++] = left[i++];
        }
        return res;
    }
}
