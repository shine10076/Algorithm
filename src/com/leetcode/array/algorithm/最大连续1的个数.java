package com.leetcode.array.algorithm;

/**
 * @author shine10076
 * @date 2019/5/3 16:20
 */
public class 最大连续1的个数 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cur = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 1) {
                cur++;
                if (max < cur) max = cur;
            } else {
                cur = 0;
            }
            ++i;



        }
        return max;
    }
}
