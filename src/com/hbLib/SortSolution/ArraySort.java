package com.hbLib.SortSolution;

import java.util.Arrays;
import java.util.Random;

public abstract class ArraySort {
    public abstract int[] sort(int[] pArr);

    public void swap(int[] pArr, int a, int b) {
        int temp = pArr[a];
        pArr[a] = pArr[b];
        pArr[b] = temp;
    }

    public static void main(String[] args) {
        ArraySort bubble = new BubbleSort();
        ArraySort selection = new SelectionSort();
        ArraySort insert = new InsertSort();
        ArraySort merge = new MergeSort();
        ArraySort merge2 = new MergeSort2();

        //        int[] a = {1, 4, 5, 9, 7};
        int[] a = {1, -9, 212, 9};
        int[] b = Arrays.copyOfRange(a, 2, 4);
        int num = 15;
        int[] c = new int[num];
        Random r = new Random();
        for (int i = 0; i < num; i++) {
            c[i] = r.nextInt(30);
        }

        System.out.println("Original Array: " + Arrays.toString(c));
        System.out.println("After Bubble Sort: " + Arrays.toString(bubble.sort(c)));
        System.out.println("After Selection Sort: " + Arrays.toString(selection.sort(c)));
        System.out.println("After Insert Sort: " + Arrays.toString(insert.sort(c)));
        System.out.println("After Merge Sort: " + Arrays.toString(merge.sort(c)));
        System.out.println("After Merge Sort2: " + Arrays.toString(merge2.sort(c)));
    }
}
