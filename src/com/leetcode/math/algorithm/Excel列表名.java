package com.leetcode.math.algorithm;

/**
 * @author shine10076
 * @date 2019/7/30 16:49
 */
public class Excel列表名 {
    public String convertToTitle(int n) {

        if(n==0)
        {
            return "";
        }

        n--;

        return convertToTitle(n/26)+ (char)(n%26+'A');

    }
}
