package com.leetcode.hashMap.algorithm;

import java.util.HashMap;


/**
 * @author shine10076
 * @date 2019/10/20 14:38
 */
public class 和为k的子数组 {

    public int subarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>(16);

        int sum = 0;
        int ans = 0;
        map.put(0,1);
        for(int num : nums)
        {
            sum += num;


            /**
             * k = sum - target
             * sum  is sum of [0...i]
             * if target==sum  - k, it means sum of  [i+1..j] == k
             */
            int target = sum - k;

            if(map.containsKey(target))
            {
                ans += map.get(target);
            }

            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        return ans;

    }

    public static void main(String[] args) {

    }
}
