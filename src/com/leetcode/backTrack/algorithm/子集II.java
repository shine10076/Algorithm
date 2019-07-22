package com.leetcode.backTrack.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shine10076
 * @date 2019/7/20 9:32
 */
public class 子集II {

    public  List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if(nums == null ||  nums.length == 0)
        {
            return res;
        }
        Arrays.sort(nums);
        dfs(nums,0,new ArrayList<>(),res);

        return res;
    }

    public  void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> res)
    {
        res.add(new ArrayList<>(path));

        for(int i = index;i<nums.length;i++)
        {
            if(i>index && nums[i]==nums[i-1]) continue;
            path.add(nums[i]);
            dfs(nums,i+1,path,res);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        子集II subset = new 子集II();
        subset.subsetsWithDup(nums);
    }
}
