package com.leetcode.competition;

import java.util.HashSet;

/**
 * @author shine10076
 * @date 2019/9/29 19:24
 */
public class 独一无二的数字 {

    public boolean uniqueOccurrences(int[] arr) {

        int[]  count = new int[2001];
        for(int i : arr)
        {
            count[i+1000]++;
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i : count)
        {
            if(i>0)
            {
                if(set.contains(i))
                {
                   return false;
                }
                else {
                    set.add(i);
                }
            }
        }

        return true;
    }
}
