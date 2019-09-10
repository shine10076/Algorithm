package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * @date 2019/9/10 14:14
 */
public class 目标和 {

    private int count = 0;

    public int findTargetSumWays(int[] nums, int S) {

        int sum = 0;
        for(int i : nums) sum += i;
        if(Math.abs(S)>sum) return 0;

        dfs(nums,0,0,S);

        return count;

    }

    private void dfs(int[] nums, int index, int S, int target)
    {

        if(index == nums.length)
        {
            if(S==target) count++;
            return;
        }
        for(int i=index;i<nums.length;i++)
        {

            S += nums[i];
            dfs(nums,index+1,S,target);
            S -= nums[i];
            S -= nums[i];
            dfs(nums,index+1,S,target);
            S += nums[i];
            break;
        }
    }

}
