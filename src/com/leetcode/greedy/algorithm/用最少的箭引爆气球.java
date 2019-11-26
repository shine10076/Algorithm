package com.leetcode.greedy.algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author shine10076
 * 2019/11/26 19:04
 */
public class 用最少的箭引爆气球 {

    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length < 1){
            return 0;
        }
        /**
         * 先按x坐标由小到大，再按y坐标由小到大
         */
        Arrays.sort(points,(int[] p1, int[] p2)->{
            if(p1[0] == p2[0]) return p2[1]-p1[1];
            else return p1[0]-p2[0];
        });

        int res = 0;
        int start = points[0][0];
        int end = points[0][1];
        /**
         * 如果和之前的有重叠区域就可以一只箭射爆，否则就重新计算区域并且用另一只箭射爆
         */
        for(int i=1;i<points.length;i++){
            if(points[i][0] > end )
            {
                res++;
                start = points[i][0];
                end = points[i][1];
            }
            else {
                start = Math.max(start,points[i][0]);
                end = Math.min(end,points[i][1]);
            }
        }

        res ++;

        return res;


    }
}
