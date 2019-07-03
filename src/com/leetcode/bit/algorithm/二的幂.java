package com.leetcode.bit.algorithm;

/**
 * @author shine10076
 * @date 2019/7/3 19:53
 */
public class 二的幂 {

    public boolean isPowerOfTwo(int n) {
        return n>0&&Integer.bitCount(n)==1;
    }
    /**
     *   return n>0&&(n&-n)==n
     *   其中 (n&-n)的作用是返回从右往左的第一个1以及之后的0所构成的数字
     *   (n&(n-1))的作用是将二进制数最左边为1的数字改为0
      */


}
