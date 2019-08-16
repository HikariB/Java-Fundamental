package com.hbLib.SortSolution;

import java.util.Arrays;

public class HeapSort extends ArraySort {
    @Override
    public int[] sort(int[] pArr) {
        int[] resArr = Arrays.copyOf(pArr, pArr.length);
        if (pArr.length <= 1)
            return resArr;

        // 建 MaxHeap 升序，minHeap 为降序，因为每次都把堆顶和元素末尾交换
        buildHeap(resArr);
        // pop 堆顶和数组尾部交换，并下渗
        // 注意调整好后，待调整的数组长度缩小
        for (int i = 1; i < resArr.length; i++) {
            // 调整数组最后一位
            swap(resArr, 0, resArr.length - i);
            // 待调整数组长度减小
            heapify(resArr, 0, resArr.length - i);
        }
        return resArr;

    }

    private void buildHeap(int[] resArr) {
        // 从最后一个非叶子节点开始
        for (int i = resArr.length / 2; i >= 0; i--) {
            heapify(resArr, i, resArr.length);
        }
    }


    // 下渗，把小的值往下移
    private void heapify(int[] resArr, int i, int length) {
        int left = 2 * i + 1;
        int right = left + 1;
        int max = i;
        // 选出子结点中最大的值
        if (left < length && resArr[max] < resArr[left])
            max = left;
        if (right < length && resArr[max] < resArr[right])
            max = right;
        // 若原子树 root 不是最大
        if (max != i) {
            swap(resArr, max, i);
            heapify(resArr, max, length);
        }
    }
}
