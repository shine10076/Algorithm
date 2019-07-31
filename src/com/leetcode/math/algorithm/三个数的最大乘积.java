package com.leetcode.math.algorithm;

import java.util.Arrays;

/**
 * @author shine10076
 * @date 2019/7/31 13:30
 */
public class 三个数的最大乘积 {


    public int maximumProduct(int[] nums) {

        Arrays.sort(nums);
        int size = nums.length;
        int right = nums[size-1]*nums[size-2]*nums[size-3];
        int left = nums[0]*nums[1]*nums[size-1];
        return Math.max(right,left);
    }
}
