package com.leetcode.array.algorithm;

import java.util.HashMap;

/**
 * @author shine10076
 * @date 2019/10/17 19:52
 */
public class 和为K的子数组 {

    public int subarraySum(int[] nums, int k) {

        int[] sums = new int[nums.length];
        int sum = 0;

        for(int i=0;i<nums.length;i++)
        {
            sum += nums[i];
            sums[i] = sum;
        }

        int res = 0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i;j<nums.length;j++)
            {
                if((sums[j]-sums[i]+nums[i])==k)
                {
                    res++;
                }
            }
        }

        return res;
    }


    //采用hash表
    public int subarraySum2(int[] nums, int k) {

        /**
         * key : nums[0...i]的和的值 k
         * value ： 值为k的nums[0...i]的i的数量
         */
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum,1);
        for(int i : nums){
            sum += i;
            if(map.containsKey(sum-k)){
                res += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
