package com.leetcode.backTrack.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shine10076
 * @date 2019/7/23 19:09
 */
public class 全排列 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
        {
            return res;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int num : nums)
        {
            queue.offer(num);
        }
        dfs(queue,new ArrayList<Integer>(),res);

        return res;
    }

    public void dfs(Queue<Integer> queue, ArrayList<Integer> list, List<List<Integer>> res)
    {
        if(queue.isEmpty())
        {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<queue.size();i++)
        {
            int tmp = queue.poll();
            list.add(tmp);
            dfs(queue,list,res);
            list.remove(list.size()-1);
            queue.offer(tmp);
        }
    }

}
