package com.leetcode.backTrack.algorithm;

import java.util.*;

/**
 * @author shine10076
 * @date 2019/7/23 20:31
 */
public class 组合 {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n<=0) return res;

        dfs(1,n,k,new ArrayList<>(),res);
        return res;
    }

    public static void dfs(int index, int n, int count, ArrayList<Integer> list, List<List<Integer>> res)
    {
        if(count == 0)
        {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=index;i<=n;i++)
        {
            list.add(i);
            count--;
            dfs(i+1,n,count,list,res);
            count++;
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        combine(4,2);
    }

}
