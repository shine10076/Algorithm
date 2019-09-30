package com.leetcode.math.algorithm;

/**
 * @author shine10076
 * @date 2019/9/30 15:03
 */
public class Excel表列序号 {

    public int titleNUmber(String s)
    {
        int res = 0;
        for(int i=0;i<s.length();i++)
        {
            res *= 26;
            res += s.charAt(i)-'A'+1;
        }

        return res;
    }
}
