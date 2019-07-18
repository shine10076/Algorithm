package com.leetcode.Search.algorithm;

/**
 * @author shine10076
 * @date 2019/7/18 10:46
 */
public class 朋友圈 {

    public int findCircleNum(int[][] M) {

        int m = M.length;
        int res = 0;
        boolean[] visit = new boolean[m];
        for(int i=0;i<m;i++){
            if(visit[i]==false)
            {
                dfs(M,visit,i);
                res++;
            }
        }
        return res;
    }

    public void dfs(int[][] M, boolean[] visit, int i)
    {
        for(int j=0;j<M.length;j++)
        {
            if(visit[j]==false && M[i][j]==1&&j!=i)
            {
                visit[j] = true;
                dfs(M,visit,j);
            }
        }
    }

}
