package com.hbLib.MyApi;

import java.util.Arrays;

/**
 * 带下标的 的堆【排序】
 * 适用于返回下标的情况，用空间换时间
 */


public class HeapSortWithIndices {


    public static void sortWithIndices(int[] pArr) {
        // 保留原有的index
        int[] indices = new int[pArr.length];
        for (int i = 0; i < pArr.length; i++) {
            indices[i] = i;
        }
        sort(pArr, indices);
        System.out.println("Original Array: " + Arrays.toString(pArr));
        System.out.println("Indices Array: " + Arrays.toString(indices));
    }

    private static void sort(int[] pArr, int[] indices) {
        // 建堆
        for (int i = 0; i < pArr.length; i++) {
            heapInsert(pArr, indices, i);
        }

        // 排序
        for (int i = pArr.length - 1; i > 0; i--) {
            swap(pArr, indices, 0, i);
            heapify(pArr, indices, 0, i - 1);
        }


    }

    private static void heapify(int[] pArr, int[] indices, int i, int maxLen) {
        int left = 2 * i + 1;
        int right = left + 1;
        int max = i;
//  非递归写法
        while (left <= maxLen) {
            max = pArr[max] < pArr[left] ? left : max;
            if (right <= maxLen) {
                max = pArr[max] < pArr[right] ? right : max;
            }
            if (max == i) {
                break;
            }
            swap(pArr, indices, i, max);
            i = max;
            left = 2 * i + 1;
            right = left + 1;
        }

// 递归写法
//        if (left <= maxLen && pArr[max] < pArr[left]) {
//            max = left;
//        }
//
//        if (right <= maxLen && pArr[max] < pArr[right]) {
//            max = right;
//        }
//
//        if (max != i) {
//            swap(pArr, indices, max, i);
//            heapify(pArr, indices, max, maxLen);
//        }

    }

    private static void swap(int[] pArr, int[] indices, int i, int j) {
        int temp = pArr[i];
        pArr[i] = pArr[j];
        pArr[j] = temp;
        temp = indices[i];
        indices[i] = indices[j];
        indices[j] = temp;
    }

    private static void heapInsert(int[] pArr, int[] indices, int i) {
        while (i > 0) {
            int p = (i - 1) / 2;
            if (pArr[p] > pArr[i]) {
                break;
            }
            swap(pArr, indices, i, p);
            i = p;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 3, 2, 1, 1};
        sortWithIndices(a);

    }

}
