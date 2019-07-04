package com.leetcode.bit.algorithm;

/**
 * @author shine10076
 * @date 2019/7/4 13:43
 */
public class 比特位计数 {

    /**
     * 对于数字6(110)来说，可以看作是数字4(100)和数字2(010)的和
     * (n&(n-1))的作用是将二进制数最左边为1的数字改为0
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i=1;i<=num;i++)
        {
            res[i] = res[(i&(i-1))]+1;
        }
        return res;
    }
}
