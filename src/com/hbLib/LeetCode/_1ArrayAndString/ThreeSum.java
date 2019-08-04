package com.hbLib.LeetCode._1ArrayAndString;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> res = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0)
                break;
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                int sum = nums[j] + nums[k] + nums[i];
                if (sum == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.addAll(Arrays.asList(nums[i], nums[j], nums[k]));
                    res.add(tmp);
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }

        }
        List<List<Integer>> res1 = new LinkedList<>(res);
        return res1;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res1 = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; ) {
            if (nums[i] > 0)
                break;
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                int sum = nums[j] + nums[k] + nums[i];
                if (sum == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.addAll(Arrays.asList(nums[i], nums[j], nums[k]));
                    res1.add(tmp);
                }
                if (sum > 0) {
                    while (k > 0 && nums[k] == nums[--k]) ;
                } else {
                    while (j < nums.length - 1 && nums[j] == nums[++j]) ;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[++i]) ;
        }
        return res1;
    }


    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
//        Arrays.sort(a);
        ThreeSum solution = new ThreeSum();
        solution.threeSum(a);
        System.out.println(Arrays.toString(a));
    }
}
