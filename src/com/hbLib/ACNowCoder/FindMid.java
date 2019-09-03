package com.hbLib.ACNowCoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMid {


    public int quickFindMid(int[] array) {
        // 考虑奇数偶数
        return quickFindKth(array, (array.length - 1) >>> 1);
    }


    public int quickFindKth(int[] array, int Kth) {
        if (array == null || array.length == 0 || Kth < 0 || Kth >= array.length) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        int resIndex = -1;
        while (resIndex != Kth) {
            resIndex = partition(array, left, right);
            if (resIndex < Kth) left = resIndex + 1;
            else if (resIndex > Kth) right = resIndex - 1;
            else break;
        }
        return array[resIndex];
    }

    private int partition(int[] array, int left, int right) {
        if (left > right || right < 0 || left > array.length - 1)
            return -1;
        int pivot = array[left];
        while (left < right) {
            while (left < right && array[right] >= pivot) right--;
            array[left] = array[right];

            while (left < right && array[left] <= pivot) left++;
            array[right] = array[left];
        }
        array[left] = pivot;
        return left;
    }

    public static int heapMedian(int[] array) {
        int heapSize = (array.length + 1) >>> 1;
        PriorityQueue<Integer> heap = new PriorityQueue<>(heapSize, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < heapSize; i++) {
            heap.add(array[i]);
        }

        for (int i = heapSize; i < array.length; i++) {
            if (array[i] < heap.peek()) {
                heap.poll();
                heap.add(array[i]);
            }
        }


        return heap.peek();

    }


    public static void main(String[] args) {
        int[] arr = new int[]{7, 8, 5, 1, 2, 4, 6, 3, 9, 3, 3};
//        int mid = new FindMid().quickFindKth(arr, 3);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(mid);
        System.out.println(heapMedian(arr));


    }

}
