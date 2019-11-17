package com.leetcode.string.algorithm;

/**
 * @author shine10076
 * 2019/11/17 13:52
 */
public class 最长回文子串 {

    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int start = 0, end = 0;
        for(int i=0;i<s.length();i++){
            int len1 = expandBound(s,i,i);
            int len2 = expandBound(s,i,i+1);
            int len = Math.max(len1,len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start,end+1);
    }

    public static int expandBound(String s, int L, int R){

        while (L>=0 && R<s.length() && s.charAt(L) == s.charAt(R)){
                L--;
                R++;
        }

        return R-L-1;
    }

    public static void main(String[] args) {
        String s = "bbb";
        System.out.println(longestPalindrome(s));
    }

}
