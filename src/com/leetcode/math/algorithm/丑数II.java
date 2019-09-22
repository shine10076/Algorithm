package com.leetcode.math.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shine10076
 * @date 2019/9/22 14:16
 */
public class 丑数II {

    public int nthUglyNumber(int n) {
        if(n <= 0) return 0;
        int m2 = 1;
        int m3 = 1;
        int m5 = 1;
        List<Integer> list = new ArrayList<>();
        while (list.size()<n)
        {
            int M = Math.min(m5,Math.min(m2,m3));
            list.add(M);

            for (int i : list)
            {
                m2 = i*2;
                if(m2>M) break;
            }

            for (int i : list)
            {
                m5 = i*5;
                if(m5>M) break;
            }

            for(int i : list)
            {
                m3 = i*3;
                if(m3>M) break;
            }

        }

        return list.get(n-1);

    }
}
