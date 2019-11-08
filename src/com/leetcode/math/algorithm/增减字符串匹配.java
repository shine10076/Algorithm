package com.leetcode.math.algorithm;

/**
 * @author shine10076
 * @date 2019/11/8 19:07
 */
public class 增减字符串匹配 {

    public int[] diStringMatch(String S) {
        int[] res = new int[S.length()+1];
        int count = 0;
        int i=0, j=S.length();
        for(int k=0;k<S.length();k++)
        {
            if(S.charAt(k)=='I')
            {
                res[count++] = i++;
            }
            else
            {
                res[count++] = j--;
            }
        }
        res[count] = i;

        return res;
    }
}
