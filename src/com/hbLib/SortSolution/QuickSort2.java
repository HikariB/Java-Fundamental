package com.hbLib.SortSolution;

import java.util.Arrays;
import java.util.Random;

public class QuickSort2 {
    public int[] quickSort(int[] pArr) {
        if (pArr == null || pArr.length <= 1)
            return pArr;
        quickSort(pArr, 0, pArr.length - 1);
        return pArr;
    }

    private void quickSort(int[] pArr, int from, int to) {
        if (from >= to)
            return;
        // partition
        int index = partition(pArr, from, to);
        // 递归地调用
        quickSort(pArr, from, index - 1);
        quickSort(pArr, index + 1, to);
    }

    /*
    private void swap(int[] pArr, int i,int j){
        int temp = pArr[i];
        pArr[i] = pArr[j];
        pArr[j] = temp;
    }
    */
    private int partition(int[] pArr, int from, int to) {
        int pivot = pArr[from];
        while (from < to) {
            while (from < to && pArr[to] >= pivot) {
                to--;
            }
            pArr[from] = pArr[to];
            while (from < to && pArr[from] <= pivot) {
                from++;
            }
            pArr[to] = pArr[from];
        }
        pArr[from] = pivot;
        return from;
    }

    public static void main(String[] args) {
        int num = 15;
        int[] c = new int[num];
        Random r = new Random();
        for (int i = 0; i < num; i++) {
            c[i] = r.nextInt(30);
//                c[i] = i;
        }
        System.out.println(Arrays.toString(c));
        new QuickSort2().quickSort(c);
        System.out.println(Arrays.toString(c));
    }
}
