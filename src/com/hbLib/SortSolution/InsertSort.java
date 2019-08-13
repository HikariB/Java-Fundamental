package com.hbLib.SortSolution;

import java.util.Arrays;

public class InsertSort extends ArraySort {
    @Override
    public int[] sort(int[] pArr) {
        if (pArr == null || pArr.length <= 1)
            return pArr;
        int[] resArr = Arrays.copyOf(pArr, pArr.length);
        for (int i = 1; i < resArr.length; i++) {
            int j = i - 1;
            int temp = resArr[i];
            while (j >= 0 && temp < resArr[j]) {
                resArr[j + 1] = resArr[j];
                j--;
            }
            if (j != i-1)
                resArr[j+1] = temp;


//            // 类似于bubble
//            for (int j = i; j > 0; j--) {
//                if (resArr[j - 1] < resArr[j])
//                    break;
//                else
//                    swap(resArr,j-1,j);
//            }
        }
        // 1  5  3
        return resArr;
    }


}
