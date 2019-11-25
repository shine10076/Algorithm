package com.leetcode.math.algorithm;

/**
 * @author shine10076
 * 2019/11/25 19:06
 */
public class GCD {

    /**
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b){
        return (b==0)?a : gcd(b, a%b);
    }
}
