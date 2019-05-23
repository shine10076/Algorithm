package com.leetcode.hashMap.algorithm;

import java.util.*;

/**
 * @author shine10076
 * @date 2019/5/20 12:30
 */
public class 最长和谐子序列 {
    public int findLHS(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>(nums.length);
        for(int i:nums)
        {
            map.put(i,map.getOrDefault(i, 0) + 1);
        }
        int res = 0;
        for(int num:map.keySet())
        {
            if(map.containsKey(num+1))
            {
                res = Math.max(res,map.get(num)+map.get(num+1));
            }
        }
        return res;
    }
}
