package com.leetcode.backTrack.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shine10076
 * @date 2019/7/24 21:07
 */
public class 组合求和 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
        {
            return res;
        }

        dfs(candidates,0,target,new ArrayList<Integer>(),res);

        return res;
    }


    public void dfs(int[] candidates,int index, int target, List<Integer> list, List<List<Integer>> res)
    {
        if(target == 0)
        {
            res.add(new ArrayList<>(list));
            return ;
        }
        for (int i=index;i<candidates.length;i++)
        {
            if(candidates[i] > target) continue;
            list.add(candidates[i]);
            dfs(candidates,i,target-candidates[i],list,res);
            list.remove(list.size()-1);
        }
        return ;
    }
}
