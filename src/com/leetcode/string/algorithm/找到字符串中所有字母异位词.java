package com.leetcode.string.algorithm;

import com.leetcode.linkedlist.algorithm.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shine10076
 * @date 2019/10/17 9:23
 */
public class 找到字符串中所有字母异位词 {

    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        if(s.length()<p.length()) return list;

        int size = p.length();

        int[] countP = new int[26];
        int[] countS = new int[26];

        for(char c : p.toCharArray())
        {
            countP[c-'a']++;
        }
        for(int i=0;i<size;i++)
        {
            countS[s.charAt(i)-'a']++;
        }

        if(isEquals(countS,countP))
        {
            list.add(0);
        }
        for(int i=size;i<s.length();i++)
        {
             countS[s.charAt(i)-'a']++;
             countS[s.charAt(i-size)-'a']--;
             if(isEquals(countS,countP))
             {
                 list.add(i-size+1);
             }
        }
        return list;
    }

    private boolean isEquals(int[] countS,int[] countP)
    {
        for(int i=0;i<countS.length;i++)
        {
            if(countS[i] != countP[i])
            {
                return false;
            }
        }
        return true;
    }


}
