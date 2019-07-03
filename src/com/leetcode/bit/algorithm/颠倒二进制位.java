package com.leetcode.bit.algorithm;

/**
 * @author shine10076
 * @date 2019/7/2 21:28
 */
public class 颠倒二进制位 {

    public int reverseBits(int n) {

        int[] bits = new int[32];
        for(int i=31;i>=0;i--)
        {
            bits[i]=n&1;
            n=n>>>1;
        }
        int flag = 1;
        int res = 0;
        for (int i=0;i<32;++i)
        {
            res += flag*bits[i];
            flag *=2;
        }
        return res;
    }
}
