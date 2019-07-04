package com.leetcode.bit.algorithm;

/**
 * @author shine10076
 * @date 2019/7/3 20:01
 */
public class 四的幂 {

    /**
     * 数是四的幂代表着二进制数只有一位1而且在奇数位
     * @param n
     * @return
     */
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n&(n-1))==0 && (n&0b01010101010101010101010101010101)!=0;
    }
}
