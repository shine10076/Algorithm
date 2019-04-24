package com.leetcode.competition;

import java.util.*;

/**
 * @author shine10076
 * @date 2019/4/21 10:31
 * @leetcode 1029
 */
public class 两地调度 {

    public int twoCitySchedCost(int[][] costs) {
        //将a市和b市的费用相减
        int m = costs.length;
        List<Three> list = new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            int diff = costs[i][0] - costs[i][1];
            list.add(new Three(diff,costs[i][0], costs[i][1]));
        }
        Collections.sort(list, new Comparator<Three>() {
            @Override
            public int compare(Three o1, Three o2) {
                return o1.diff - o2.diff;
            }
        });
        int sum = 0;
        for(int i=0;i<m/2;i++)
        {
            sum += list.get(i).getA();
        }
        for(int i=m/2;i<m;i++)
        {
            sum += list.get(i).getB();
        }
        return sum;
    }

    class Three
    {
        int diff;
        int a;
        int b;
        public Three(int diff, int a, int b) {
            this.diff = diff;
            this.a = a;
            this.b = b;
        }

        public int getDiff() {
            return diff;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }
}
