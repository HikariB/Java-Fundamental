package com.hbLib.MyApi;

public class BinarySearchSummary {

    /* template
    // ... 时需要注意的细节
    int binarySearch(int[] nums, int target) {
        int left = 0, right = ...;

        while(...) {
            int mid = (right + left) / 2;
            // 为了防止溢出
            int mid = left + (right - left) >>> 1
            if (nums[mid] == target) {
            ...
            } else if (nums[mid] < target) {
                left = ...
            } else if (nums[mid] > target) {
                right = ...
            }
        }
        return ...;
    }

    */

    int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        // 左闭右开
        //while(left < right)
        // 左闭右闭 []
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        //return nums[left] == target ? left : -1;
        return -1;
    }

    // left_bound
    // 返回比Target小的数的个数
    int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) { // 注意
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }

        // target 比所有数都大
//        if (left == nums.length) return -1;
// 类似之前算法的处理方式
//        return nums[left] == target ? left : -1;

        return left;
    }

    int right_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1; // 注意
    }

    // 常规二分搜索
    /**
     * 因为我们初始化 right = nums.length - 1
     * 所以决定了我们的「搜索区间」是 [left, right]
     * 所以决定了 while (left <= right)
     * 同时也决定了 left = mid+1 和 right = mid-1
     *
     * 因为我们只需找到一个 target 的索引即可
     * 所以当 nums[mid] == target 时可以立即返回
     */

    // 左边界
    /**
     * 因为我们初始化 right = nums.length
     * 所以决定了我们的「搜索区间」是 [left, right)
     * 所以决定了 while (left < right)
     * 同时也决定了 left = mid + 1 和 right = mid
     *
     * 因为我们需找到 target 的最左侧索引
     * 所以当 nums[mid] == target 时不要立即返回
     * 而要收紧右侧边界以锁定左侧边界
     */

    //右边界
    /**
     * 因为我们初始化 right = nums.length
     * 所以决定了我们的「搜索区间」是 [left, right)
     * 所以决定了 while (left < right)
     * 同时也决定了 left = mid + 1 和 right = mid
     *
     * 因为我们需找到 target 的最右侧索引
     * 所以当 nums[mid] == target 时不要立即返回
     * 而要收紧左侧边界以锁定右侧边界
     *
     * 又因为收紧左侧边界时必须 left = mid + 1
     * 所以最后无论返回 left 还是 right，必须减一
     */

}
