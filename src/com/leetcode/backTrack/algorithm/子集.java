package com.leetcode.backTrack.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shine10076
 * @date 2019/7/20 9:08
 */
public class 子集 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
        {
            return res;
        }

        dfs(nums,0,new ArrayList<>(),res);

        return res;

    }

    /**
     * 回溯法
     * @param nums
     * @param index
     * @param path
     * @param res
     */
    public void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> res)
    {
        res.add(path);

        for(int i=index;i<nums.length;i++)
        {
            path.add(nums[i]);
            dfs(nums,i+1,path,res);
            path.remove(path.size()-1);
        }

    }
}
