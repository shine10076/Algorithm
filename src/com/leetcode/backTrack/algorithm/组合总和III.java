package com.leetcode.backTrack.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shine10076
 * @date 2019/7/25 19:29
 */
public class 组合总和III {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n<=0)
        {
            return res;
        }

        dfs(n,k,1,new ArrayList<Integer>(),res);
        return res;

    }

    public void dfs(int target, int count,int index,List<Integer> list, List<List<Integer>> res)
    {
        if(count<0) return;
        if(target == 0 && count == 0)
        {
            res.add(new ArrayList<>(list));
        }
        for(int i=index;i<=9;i++)
        {
            if(i>target) break;
            list.add(i);
            dfs(target-i,count-1,i+1,list,res);
            list.remove(list.size()-1);
        }

    }
}
