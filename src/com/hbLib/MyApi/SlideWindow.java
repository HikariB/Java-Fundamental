package com.hbLib.MyApi;

import java.util.LinkedList;

public class SlideWindow {

    // find max
    public static void slideTraverse(int[] pArr) {
        LinkedList<Integer> qmax = new LinkedList<>();
        assert pArr.length > 0;
        int left = 0;
        int right = 0;
        while (left < pArr.length) {

            while (right < pArr.length) {

                while (!qmax.isEmpty() && pArr[qmax.peekLast()] <= pArr[right]) {
                    qmax.pollLast();
                }
                qmax.addLast(right);

                // need break;
                // if() break;

                right++;
            }
            if (qmax.peekFirst() == left) {
                qmax.pollFirst();
            }

            left++;

        }
    }


}
