package com.leetcode.array.algorithm;

import java.util.Arrays;

/**
 * @author shine10076
 * @date 2020/3/18 10:04
 */
public class 矩形面积 {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int res = (C-A)*(D-B) + (G-E)*(H-F);
        int[] rec1 = new int[]{A,B,C,D};
        int[] rec2 = new int[]{E,F,G,H};
        if(!isOverlap(rec1,rec2)){
            return res;
        }
        //去除重叠面积
        int[] X = new int[]{A,C,E,G};
        int[] Y = new int[]{B,D,F,H};
        Arrays.sort(X);
        Arrays.sort(Y);
        return res - (X[2]-X[1])*(Y[2]-Y[1]);
    }

    private boolean isOverlap(int[] rec1, int rec2[]){
        if((rec2[0]<=rec1[0]&&rec2[2]<=rec1[0])
                ||(rec2[0]>=rec1[2]&&rec2[2]>=rec1[2])
                ||(rec2[1]<=rec1[1]&&rec2[3]<=rec1[1])
                ||(rec2[1]>=rec1[3]&&rec2[3]>=rec1[3])){
            return false;
        }else{
            return true;
        }
    }
}
