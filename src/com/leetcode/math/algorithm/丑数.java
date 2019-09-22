package com.leetcode.math.algorithm;

/**
 * @author shine10076
 * @date 2019/9/22 14:03
 */
public class 丑数 {

    public boolean isUgly(int num) {

        if(num<1) return false;

        while (num%2==0&&num>=2)
        {
            num /= 2;
        }

        while (num%3==0&&num>=3)
        {
            num /= 3;
        }

        while (num%5==0&&num>=5)
        {
            num /= 5;
        }

        return num == 1;
    }
}
