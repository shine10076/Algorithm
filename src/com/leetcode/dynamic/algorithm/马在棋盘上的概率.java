package com.leetcode.dynamic.algorithm;

/**
 * @author shine10076
 * @date 2019/4/23 15:28
 */
public class 马在棋盘上的概率 {
    static int[][] direction = new int[][]{{1,2},{1,-2}, {-1,2},{-1,-2},{2,1}, {2,-1},{-2,1},{-2,-1}};
    public static double knightProbability(int N, int K, int r, int c) {
        /*ways数组中存放着i,j在第k步的概率*/
        double[][][] ways = new double[K+1][N][N];
        ways[0][r][c] = 1.0;
        for(int k=1;k<=K;k++)
        {
            for(int i = 0;i<N;i++){
                for(int j=0;j<N;j++){
                    for(int[] dire:direction){
                        int oldR = i - dire[0];
                        int oldC = j - dire[1];
                        if( oldR >=0 && oldC >=0 && oldR < N && oldC < N)
                        {
                            ways[k][i][j] += ways[k-1][oldR][oldC]/8.0;
                        }
                    }
                }
            }
        }


        double res = 0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                res += ways[K][i][j];
            }
        }


        return res;
    }

    public static void main(String[] args) {
        System.out.println(knightProbability(3, 2, 0,0));
    }
}
