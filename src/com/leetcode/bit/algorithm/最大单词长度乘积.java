package com.leetcode.bit.algorithm;

/**
 * @author shine10076
 * @date 2019/7/4 13:10
 */
public class 最大单词长度乘积 {

    public int maxProduct(String[] words) {
        int[] bitMark = new int[words.length];
        for(int i=0;i<words.length;i++)
        {
            char[] c = words[i].toCharArray();
            for (int j=0;j<c.length;j++)
            {
                int letter = c[j]-'a';
                bitMark[i] = bitMark[i]|(1<<letter);
            }
        }
        int res = 0;
        for(int i=0;i<words.length-1;i++)
            for(int j=i+1;j<words.length;j++)
            {
                if((bitMark[i]&bitMark[j])==0)
                {
                    res=Math.max(res,words[i].length()*words[j].length());
                }
            }
        return res;
    }
}
