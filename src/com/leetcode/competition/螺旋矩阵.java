package com.leetcode.competition;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shine10076
 * @date 2019/4/15 15:35
 */
public class 螺旋矩阵 {

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        List<int[]> list = new ArrayList<>();
        int count  = 0;
        int starter = 1;
        while(count != R*C)
        {
            //向右
            for(int i=0;i<starter;i++)
            {
                if(r0<R && c0 < C && r0 >= 0 && c0 >= 0)
                {   int[] res = {r0,c0};
                    list.add(res);
                    count ++;
                }
                c0++;
            }
            //向下
            for(int i=0;i<starter;i++)
            {
                if(r0<R && c0 < C && r0 >= 0 && c0 >= 0)
                {   int[] res = {r0,c0};
                    list.add(res);
                    count ++;
                }
                r0++;
            }
            starter++;
            //向左
            for(int i=0;i<starter;i++)
            {
                if(r0<R && c0 < C && r0 >= 0 && c0 >= 0)
                {   int[] res = {r0,c0};
                    list.add(res);
                    count ++;
                }
                c0--;
            }
            //向上
            for(int i=0;i<starter;i++)
            {
                if(r0<R && c0 < C && r0 >= 0 && c0 >= 0)
                {   int[] res = {r0,c0};
                    list.add(res);
                    count ++;
                }
                r0--;
            }
            starter++;
        }
        int[][] res= new int[list.size()][];
        for(int i=0;i<list.size();i++)
        {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args)
    {
    }
}
