package com.leetcode.string.algorithm;

/**
 * @author shine10076
 * @date 2019/7/4 16:07
 */
public class 最长回文串 {

    public int longestPalindrome(String s) {
        char[] ch = s.toCharArray();
        int[] map = new int[256];
        for(int i=0;i<ch.length;i++)
        {
            map[ch[i]]++;
        }
        int res = 0;
        for(int val:map)
        {
            if(val%2==0)
            {
                res += val;
            }else if(val !=0)
            {
                res += val-1;
            }else
            {}
        }
        if(res<ch.length) res++;
        return res;
    }

}
