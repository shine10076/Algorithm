package com.leetcode.string.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shine10076
 * @date 2019/7/4 16:35
 */
public class 同构字符串 {

    public static boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length())
        {
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        char[] s2 = s.toCharArray();
        char[] t2 = t.toCharArray();
        for(int i=0;i<s2.length;i++)
        {
            if(!map.containsKey(s2[i]))
            {
                if(map.containsValue(t2[i]))
                {
                    return false;
                }
                map.put(s2[i],t2[i]);

            }else if(map.containsKey(s2[i]))
            {
                if(t2[i]!=map.get(s2[i]))
                {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ab";
        String t = "ca";
        System.out.println(isIsomorphic(s,t));
    }
}
