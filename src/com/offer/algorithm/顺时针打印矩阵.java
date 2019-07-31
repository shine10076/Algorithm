package com.offer.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shine10076
 * @date 2019/7/31 20:24
 */
public class 顺时针打印矩阵 {

    /**
     * 转圈打印矩阵
     * @param matrix :  矩阵类型
     * @return 数组
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {

        ArrayList<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
        {
            return res;
        }
        int m = matrix.length, n = matrix[0].length;
        int tR = 0, tC = 0;
        int dR = m-1,dC = n-1;
        while(tR<=dR && tC<=dC)
        {
            addItem(matrix,tR++,tC++,dR--,dC--,res);
        }

        return res;
    }

    public void addItem(int[][] matrix, int tR,int tC, int dR, int dC,ArrayList<Integer> res)
    {
        int curR = tR, curC= tC;
        if(tC == dC)
        {
            for(int i=tR;i<=dR;i++)
            {
                res.add(matrix[i][tC]);
            }
        }
        else if(tR == dR)
        {
            for(int i=tC;i<=dC;i++)
            {
                res.add(matrix[tR][i]);
            }
        }else
        {
            while (curC != dC)
            {
                res.add(matrix[curR][curC]);
                curC++;
            }
            while (curR!= dR)
            {
                res.add(matrix[curR][curC]);
                curR++;
            }
            while (curC != tC)
            {
                res.add(matrix[curR][curC]);
                curC--;
            }
            while (curR != tR)
            {
                res.add(matrix[curR][curC]);
                curR--;
            }
        }
    }
}
