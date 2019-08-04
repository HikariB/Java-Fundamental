package com.hbLib.LeetCode._1ArrayAndString;

public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3)
            return false;
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > second)
                return true;
            if (num < first) {
                first = num;
            } else if (num > first && num < second) {
                second = num;
            }
        }
        return false;
    }
}
