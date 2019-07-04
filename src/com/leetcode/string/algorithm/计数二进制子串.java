package com.leetcode.string.algorithm;

/**
 * @author shine10076
 * @date 2019/7/4 19:27
 */
public class 计数二进制子串 {

    public int countBinarySubstrings(String s) {

        char[] ch = s.toCharArray();
        int res = 0;
        int curNum = 1, preNum = 0;
        for(int i=1;i<ch.length;i++)
        {
            if(ch[i-1]==ch[i])
            {
                curNum++;
            }
            else
            {
                preNum = curNum;
                curNum = 1;
            }
            if(preNum >= curNum)  res++;
        }
        return res;
    }

}
