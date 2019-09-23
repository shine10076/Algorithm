package com.leetcode.competition;

import java.util.HashSet;

/**
 * @author shine10076
 * @date 2019/9/23 20:30
 */
public class 找出所有行中最小公共元素 {

    public int smallestCommonElement(int[][] mat) {

        int m = mat.length, n = mat[0].length;
        int max = 0;
        for(int i=0;i<m;i++)
        {
            max = Math.max(max,mat[i][n-1]);
        }

        int[] count = new int[max+1];
        for (int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                count[mat[i][j]]++;
            }
        }

        for(int i=1;i<count.length;i++)
        {
            if(count[i]==m)
            {
                return i;
            }
        }

        return -1;
    }
}
