package com.leetcode.hashMap.algorithm;

import java.util.HashMap;

/**
 * @author shine10076
 * @date 2020/3/19 20:26
 */
public class 最长回文串 {

    public int longestPalindrome(String s) {
        int[] map = new int[75];
        for(char c : s.toCharArray()){
            map[c-'0']++;
        }
        int res = 0;
        for(int i : map){
            if(i==0) continue;
            if((i&1)==0){
                res += i;
            }else {
                res += i-1;
            }
        }
        if(res < s.length()) res++;
        return res;
    }
}
