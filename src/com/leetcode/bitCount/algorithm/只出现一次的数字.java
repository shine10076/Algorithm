package com.leetcode.bitCount.algorithm;

/**
 * @author shine10076
 * @date 2019/6/12 21:37
 */
public class 只出现一次的数字 {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i:
             nums) {
            res=res^i;
        }
        return res;
    }
}
