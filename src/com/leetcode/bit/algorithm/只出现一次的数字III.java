package com.leetcode.bit.algorithm;

/**
 * @author shine10076
 * @date 2019/7/2 21:07
 */
public class 只出现一次的数字III {
    /**
     * 先将数组中数异或得到两个不同数字的异或结果
     *  diff&-diff = 得到最右边为一的数字，
     *  通过这一位的不同将数组划分位两部分
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for(int num:nums)
        {
            diff ^= num;
        }
        diff &= -diff;
        int res[] = new int[2];
        for(int num:nums)
        {
            if((num&diff) == 0) res[0] ^= num;
            else res[1] ^= num;
        }
        return res;
    }
}
