package com.leetcode.backTrack.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author shine10076
 * @date 2019/7/25 19:09
 */
public class 组合求和II {


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        if(candidates == null || candidates.length == 0)
        {
            return res;
        }
        Arrays.sort(candidates);

        dfs(candidates,0,target,new ArrayList<Integer>(),res);


        return res;
    }

    public void dfs(int[] candicates, int index, int target, List<Integer> list, List<List<Integer>> res)
    {
        if(target == 0)
        {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=index;i<candicates.length;i++)
        {
            if(i>index && candicates[i]==candicates[i-1]) continue;
            if (target<candicates[i]) continue;

            list.add(candicates[i]);
            dfs(candicates,i+1,target-candicates[i],list,res);
            list.remove(list.size()-1);
        }

    }

}
