package com.leetcode.array.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author shine10076
 * @date 2019/10/17 10:04
 */
public class 合并区间 {

    public static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
        {
            return new int[0][0];
        }
        Arrays.sort(intervals, (int[] o1, int[] o2)->{
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }else{
                return o1[0] - o2[0];
            }
        });
        ArrayList<Interval> list = new ArrayList<>();
        Interval pre = new Interval(intervals[0][0],intervals[0][1]);

        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0]<=pre.y)
            {
                pre.x = Math.min(pre.x,intervals[i][0]);
                pre.y = Math.max(pre.y,intervals[i][1]);
            }
            else
            {
                list.add(new Interval(pre.x,pre.y));
                pre.x = intervals[i][0];
                pre.y = intervals[i][1];
            }
        }

        list.add(pre);

        int[][] res = new int[list.size()][2];
        for(int i=0;i<list.size();i++)
        {
            res[i][0] = list.get(i).x;
            res[i][1] = list.get(i).y;
        }

        return res;
    }

     static class Interval
    {
        public int x;
        public int y;

        public Interval(int x, int y)
        {
            this.x = x;
            this.y = y;
        }


    }

    public static void main(String[] args) {

        int[][] nums =  new int[][]{
                {2,3},
                {4,5},
                {6,7},
                {8,9},
                {1,10}
        };
        int[][] res = merge(nums);
        for(int i=0;i<res.length;i++)
        {
            System.out.println(res[i][0]+"  "+res[i][1]);
        }
    }
}
