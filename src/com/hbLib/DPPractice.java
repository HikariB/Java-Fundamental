package com.hbLib;

import java.util.*;



public class DPPractice {

    public static void main(String[] args) {

        System.out.println("hello");

        int[] a = {2, 1, 1, 2};
        int[] suba = Arrays.copyOfRange(a, 0, 2);
        System.out.println(Arrays.toString(suba));

        int[] a2 = {1, 2, 5, 6};
        System.out.println(Arrays.binarySearch(a2, 2));


    }

    //DP1
    private Map<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {

        if (n <= 2)
            return n;
        if (this.cache.containsKey(n) == true) {
            return this.cache.get(n);
        } else {
            int res = climbStairs(n - 1) + climbStairs(n - 2);
            this.cache.put(n, res);
            return res;
        }

    }

    //Dp2
    public int maxProfit(int[] prices) {
        int l = prices.length;
        if (l < 2)
            return 0;
        int res = 0;
        for (int i = l - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                res = prices[i] - prices[j] > res ? prices[i] - prices[j] : res;
            }
        }
        return res;


    }

    //Dp2 -2
    public int maxProfit2(int[] prices) {
        int maxCur = 0;
        int res = 0;
        for (int i = 1; i <= prices.length - 1; i++) {
            maxCur += prices[i] - prices[i - 1];
            maxCur = maxCur > 0 ? maxCur : 0;
            res = maxCur > res ? maxCur : res;
        }

        return res;

    }


    //Dp3
    public int maxSubArray(int[] nums) {
        int res = 0;
        int maxRes = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
            maxRes = res > maxRes ? res : maxRes;
            res = res > 0 ? res : 0;

        }
        return maxRes;

    }

    //Dp4

    private Map<Integer, Integer> memo = new HashMap<>();


    public int rob(int[] nums) {
        int res = 0;
        int cache1 = 0;
        int cache2 = 0;


        if (nums.length == 0) {
            memo.put(0, 0);
            return 0;
        }
        if (nums.length == 1) {
            memo.put(1, nums[0]);
            return nums[0];
        }
        if (nums.length == 2) {
            cache1 = nums[0] > nums[1] ? nums[0] : nums[1];
            memo.put(2, cache1);
            return cache1;
        }
        if (nums.length == 3) {
            cache1 = nums[0] + nums[2] > nums[1] ? nums[0] + nums[2] : nums[1];
            memo.put(3, cache1);
            return cache1;
        }

        if (memo.containsKey(nums.length - 2))
            cache1 = memo.get(nums.length - 2);
        else
            cache1 = rob(Arrays.copyOfRange(nums, 0, nums.length - 2));

        if (memo.containsKey(nums.length - 3))
            cache2 = memo.get(nums.length - 3);
        else
            cache2 = rob(Arrays.copyOfRange(nums, 0, nums.length - 3));


        cache1 += nums[nums.length - 1];
        cache2 += nums[nums.length - 2];
        res = cache1 > cache2 ? cache1 : cache2;
        memo.put(nums.length, res);
        return res;

    }

    //Dp4

    public int rob2(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dpMemo = new int[nums.length + 2];
        Arrays.fill(dpMemo, 0);


        for (int i = 2; i < dpMemo.length; i++) {
            dpMemo[i] = Math.max(dpMemo[i - 1], nums[i - 2] + dpMemo[i - 2]);
        }
        return dpMemo[dpMemo.length - 1];
    }

    //k : length -k
    //
    private Map<Integer, Boolean> mapCanJump = new HashMap<>();

    public boolean canJump(int[] nums) {

        if (nums.length == 0)
            return false;
        if (nums.length <= 2) {
            boolean b = (nums[0] >= nums.length - 1);
            mapCanJump.put(nums.length - 1, b);
            return b;

        }


        for (int i = nums.length - 2; i >= 0; --i) {
            if (nums[i] >= nums.length - i - 1) {
                if (i == 0) {
                    return true;
                } else {
                    if (mapCanJump.containsKey(i))
                        return mapCanJump.get(i);
                    if (canJump(Arrays.copyOfRange(nums, 0, i + 1))) {
                        mapCanJump.put(i, true);
                        return true;
                    }
                }
            }

        }
        mapCanJump.put(nums.length - 1, false);
        return false;

    }

    public boolean canJump2(int[] nums) {
        if (nums.length == 0)
            return false;
        boolean[] booleans = new boolean[nums.length];
        Arrays.fill(booleans, false);
        booleans[0] = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (!booleans[i]) {
                break;
            }
            for (int j = 1; j <= nums[i] && i + j <= nums.length - 1; j++) {
                booleans[j + i] = true;
            }
        }
        return booleans[nums.length - 1];
    }

    public int uniquePaths(int m, int n) {
        int[][] map = new int[m + 1][n + 1];
        // Put 0 to each map[][]

        //init
        map[1][1] = 1;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (map[i][j] > 0)
                    continue;
                else
                    map[i][j] = map[i - 1][j] + map[i][j - 1];

            }

        }
        return map[m][n];

    }

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0)
            return -1;
        Arrays.sort(coins);
        //use max
        int index = Arrays.binarySearch(coins, amount);
        if (index < 0 && -index < 2)
            return -1;
        int maxChange = index > 0 ? coins[index] : coins[-index - 2];
        int res = amount / maxChange;
        amount -= res*maxChange;
//        coinChange();

        return 0;

    }

}


