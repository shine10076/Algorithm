package com.leetcode.math.algorithm;

/**
 * @author shine10076
 * @date 2019/7/30 16:55
 */
public class 阶乘后的零 {

    public int trailingZeroes(int n) {
            /**
         * 2*5 产生一个0，2的数量明显多于5
         * 只需要统计5的个数
         * 5的个数统计方式
         * N/5 + N/5^2 + ...
         * 其中N/5表示不大于N的数字中N的倍数提供一个5
         */
        return n==0?0:n/5 + trailingZeroes(n/5);
    }
}
