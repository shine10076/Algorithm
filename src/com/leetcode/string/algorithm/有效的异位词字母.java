package com.leetcode.string.algorithm;

/**
 * @author shine10076
 * @date 2019/7/4 15:56
 */
public class 有效的异位词字母 {

    public boolean isAnagram(String s, String t) {
        if(s==null||t==null||s.length() != t.length())
        {
            return false;
        }
        int[] map = new int[26];
        for(int i=0;i<s.length();i++)
        {
            map[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++)
        {
            map[t.charAt(i)-'a']--;
        }
        for(int ans: map)
        {
            if(ans!=0)
                return false;
        }
        return true;
    }
}
