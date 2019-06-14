package com.leetcode.bit.algorithm;

/**
 * @author shine10076
 * @date 2019/6/12 21:34
 */
public class 汉明距离 {

    public int hammingDistance(int x, int y) {
        int res  = x^y;
        return Integer.bitCount(res);
    }
}
