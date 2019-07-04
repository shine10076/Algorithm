package com.leetcode.bit.algorithm;

/**
 * @author shine10076
 * @date 2019/7/3 20:51
 */
public class 两整数之和 {

    public int getSum(int a, int b) {
        return b==0?a:getSum(a^b,(a&b)<<1);
    }
}
