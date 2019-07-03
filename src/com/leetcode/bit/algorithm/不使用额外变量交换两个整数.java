package com.leetcode.bit.algorithm;

/**
 * @author shine10076
 * @date 2019/7/2 21:34
 */
public class 不使用额外变量交换两个整数 {

    public static void main(String[] args)
    {
        int a = 4, b=5;
        a = a^b;
        b = b^a;
        a = b^a;
        System.out.println("a:"+a);
        System.out.println("b:"+b);
    }
}
