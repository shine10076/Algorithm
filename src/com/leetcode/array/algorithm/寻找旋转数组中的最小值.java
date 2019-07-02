package com.leetcode.array.algorithm;

import sun.misc.LRUCache;

/**
 * @author shine10076
 * @date 2019/4/9 22:32
 */
public class 寻找旋转数组中的最小值 {

    private static int findMin(int[] array) {
        if (array == null) return 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) return array[i];
        }
        return array[0];
    }

    private static int findMin2(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        int L = 0, R = nums.length - 1;
        while (L < R) {
            int mid = L + ((R - L) >> 1);
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[L] <= nums[mid] && nums[mid] > nums[R]) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return nums[L];
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 0, 1, 2, 3};
        System.out.println(findMin(nums));
    }
}
