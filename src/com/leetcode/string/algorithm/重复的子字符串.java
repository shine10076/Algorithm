package com.leetcode.string.algorithm;

/**
 * @author shine10076
 * @date 2019/10/4 16:25
 */
public class 重复的子字符串 {

    public static boolean repeatedSubstringPattern(String s) {

        for(int i=0;i<(s.length()/2);i++)
        {
            if(isConstruct(s,i))
            {
                return true;
            }
        }

        return false;
    }

    private static boolean isConstruct( String s, int end)
    {
        String sub = s.substring(0,end+1);
        int n = sub.length();
        for(int i=0;i<s.length();i += n)
        {
            if(i+n>s.length() ||!sub.equals(s.substring(i,i+n)))
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String  s = "aabaaba";
        System.out.println(
                repeatedSubstringPattern(s)
        );
    }
}
