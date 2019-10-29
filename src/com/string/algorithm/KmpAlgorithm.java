package com.string.algorithm;

/**
 * @author shine10076
 * @date 2019/10/13 14:58
 */
public class KmpAlgorithm {

    public static int getIndexOf(String s, String m)
    {
        if(s == null || m == null || m.length() < 1 || s.length() < m.length()){
            return -1;
        }

        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);
        while (i1 < str1.length && i2 < str2.length){
            if(str1[i1] == str2[i2]){
                i1++;
                i2++;
            }else if(next[i2] == -1){
                i1++;
            }else {
                i2 = next[i2];
            }
        }

        return i2 == str2.length ? i1 - i2 : -1;
    }

    public static int[] getNextArray(char[] str)
    {
        return null;
    }
}
