package com.hbLib.ACNowCoder;

import sun.security.util.Length;

import java.util.*;

public class SelfDefineComparator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            String[] nums = str.split(",");
            int len = nums.length;
            String[] temp = nums[len - 1].split(";");
            nums[len - 1] = temp[0];
            int K = Integer.parseInt(temp[1]);


            Integer[] numsInt = new Integer[len];
            for (int i = 0; i < len; i++) {
                numsInt[i] = Integer.valueOf(nums[i]);
            }

            Arrays.sort(numsInt, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    //都是奇数或偶数
                    if ((o1 & 1) == (o2 & 1)) {
                        return o2 - o1;
                    } else {
                        if ((o1 & 1) == 0) {
                            return -1;
                        } else {
                            return 1;
                        }
                    }
                }
            });
            ArrayList<String> res = new ArrayList<>();
            for (int i = 0; i < K; i++) {
                res.add(String.valueOf(numsInt[i]));
            }
            System.out.println(String.join(",", res));
        }
    }
}
