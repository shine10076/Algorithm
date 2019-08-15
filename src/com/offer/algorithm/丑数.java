package com.offer.algorithm;

import java.util.ArrayList;

/**
 * @author shine10076
 * @date 2019/8/15 10:14
 */
public class 丑数 {

    public int GetUglyNumber_Solution(int index) {
        if(index <= 0) return 0;
        ArrayList<Integer> list = new ArrayList<>();
        int M2 = 1;
        int M3 = 1;
        int M5 = 1;
        while (list.size()<index)
        {
            int M =Math.min(Math.min(M2,M3),M5);
            list.add(M);
            for(int i: list)
            {
                M2 = i*2;
                if(M2>M) break;
            }
            for(int i:list)
            {
                M3 = i*3;
                if(M3 > M) break;
            }
            for(int i:list)
            {
                M5 = i*5;
                if(M5>M) break;
            }
        }

        return list.get(index-1);
    }
}
