package com.leetcode.bit.algorithm;

/**
 * @author shine10076
 * @date 2019/6/14 22:10
 */
public class 缺失数字 {

    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
            res = res ^ i;
        }
        return res ^ nums.length;
    }
}
