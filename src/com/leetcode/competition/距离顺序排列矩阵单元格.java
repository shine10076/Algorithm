package com.leetcode.competition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author shine10076
 * @date 2019/4/21 10:56
 */
public class 距离顺序排列矩阵单元格 {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<Three> list = new ArrayList<>();
        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++)
            {
                int distance = Math.abs(i-r0) + +Math.abs(j-c0);
                list.add(new Three(distance,i, j));
            }
        Collections.sort(list, new Comparator<Three>() {
            @Override
            public int compare(Three o1, Three o2) {
                return o1.distance - o2.distance;
            }
        });
            int[][] res = new int[R*C][2];
            for(int i = 0; i<list.size();i++)
            {
                Three three = list.get(i);
                res[i][0] = three.getA();
                res[i][1] = three.getB();
            }
            return res;
    }

    class Three
    {
        int distance;
        int a;
        int b;
        Three(int distance, int a, int b)
        {
            this.distance = distance;
            this.a = a;
            this.b = b;
        }
        int getA()
        {
            return a;
        }
        int getB()
        {
            return b;
        }
    }


}
