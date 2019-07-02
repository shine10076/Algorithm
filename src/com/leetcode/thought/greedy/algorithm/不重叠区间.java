package com.leetcode.thought.greedy.algorithm;

import java.util.*;

/**
 * @author shine10076
 * @date 2019/5/26 21:12
 */
public class 不重叠区间 {

    public int eraseOverlapIntervals(int[][] intervals) {
        /**
         * 贪心策略是每次都选出区间右节点中最小的那个，和经典的活动安排问题很类似
         */
        if (intervals == null || intervals.length == 0) return 0;
        int m = intervals.length;
        if (m == 1) return 0;
        List<Interval> list = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {

            list.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.b - o2.b;
            }
        });
        int pre = list.get(0).b;
        int res = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).a < pre) res++;
            else pre = list.get(i).b;
        }
        return res;
    }

    class Interval {
        public int a;
        public int b;

        Interval(int a, int b) {
            this.a = a;
            this.b = b;
        }

    }
}
