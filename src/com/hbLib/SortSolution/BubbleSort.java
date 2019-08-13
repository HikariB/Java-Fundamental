package com.hbLib.SortSolution;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;

public class BubbleSort extends ArraySort {

    @Override
    public int[] sort(int[] pArr) {
        if (pArr == null || pArr.length <= 1)
            return pArr;
        int[] resArr = Arrays.copyOf(pArr, pArr.length);

        //两轮循环
        //外循环每次确定最大值
        //内循环交换逆序对
        boolean flag = true;
        for (int i = 0; i < resArr.length - 1; i++) {
            flag = true;
            for (int j = 0; j < resArr.length - i - 1; j++) {
                if (resArr[j] > resArr[j + 1]){
                    swap(resArr, j, j + 1);
                    flag = false;
                }
            }
            if (flag)
                break;
        }

        return resArr;
    }
}
