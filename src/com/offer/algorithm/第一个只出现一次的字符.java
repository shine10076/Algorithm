package com.offer.algorithm;

import java.util.HashSet;

/**
 * @author shine10076
 * @date 2019/8/15 10:48
 */
public class 第一个只出现一次的字符 {

    public int FirstNotRepeatingChar(String str) {
        char[] letter = str.toCharArray();
        int[] value = new int[52];

        for(char c : letter)
        {
            if(c<'a')
            {
                value[c-'A'+26]++;
            }else
            {
                value[c-'a']++;
            }
        }
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<52;i++)
        {
            if(value[i]==1)
            {
                if(i<26) set.add((char)('a'+i));
                else set.add((char)('A'+i-26));
            }
        }

        for(int i = 0;i<letter.length;i++)
        {
            if(set.contains(letter[i])) return i;
        }
        return -1;
    }
}
