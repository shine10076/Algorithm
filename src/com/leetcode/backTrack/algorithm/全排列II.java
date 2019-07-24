package com.leetcode.backTrack.algorithm;

import java.util.*;

/**
 * @author shine10076
 * @date 2019/7/23 19:56
 */
public class 全排列II {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        if(nums == null || nums.length == 0)
        {
            return res;
        }
        for(int num : nums)
        {
            queue.offer(num);
        }
        dfs(queue,new ArrayList<Integer>(),res);

        return res;
    }

    /**
     * 将排列组合的问题看作图的遍历，从上到下的字节数依次-1，叶子节点为出口
     * @param queue
     * @param list
     * @param res
     */
    public static void dfs(Queue<Integer> queue, ArrayList<Integer> list, List<List<Integer>> res)
    {
        if(queue.isEmpty())
        {
            res.add(new ArrayList<>(list));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<queue.size();i++)
        {
            if(!set.contains(queue.peek())){
                int tmp = queue.poll();
                list.add(tmp);
                set.add(tmp);
                dfs(queue,list,res);
                list.remove(list.size()-1);
                queue.offer(tmp);
            }else
            {
                int tmp = queue.poll();
                queue.offer(tmp);
            }
        }
    }

    public static void main(String[] args) {
        int[]  nums = new int[]{
                1,1,2
        };

        List<List<Integer>> res = permuteUnique(nums);
        for(List<Integer> list : res)
        {
            for(Integer i : list)
            {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
