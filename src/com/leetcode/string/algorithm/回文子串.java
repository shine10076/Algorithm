package com.leetcode.string.algorithm;

/**
 * @author shine10076
 * @date 2019/7/4 16:56
 */
public class 回文子串 {

    public int res = 0;
    public int countSubstrings(String s) {
        char[] ch = s.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            //分奇数个的回文子串和偶数个的回文子串
            extendSubString(ch,i,i);
            extendSubString(ch,i,i+1);
        }
        return res;
    }

    public void extendSubString(char[] ch, int start, int end)
    {
        while(start>=0 && end < ch.length&&ch[start]==ch[end])
        {
            start--;
            end++;
            res++;
        }
    }
}
