package com.leetcode.array.algorithm;

/**
 * @author shine10076
 * 2019/12/4 16:29
 */
public class 接雨水 {

    /**
     *  left[i] ：第i个数左边最大的数
     *  right[i] : 第i个数右边最大的数
     * @param height ： 高度数组
     * @return
     */
    public int trap(int[] height) {
        if(height == null || height.length < 1){
            return 0;
        }
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int L = 0;
        for(int i=0;i<height.length;i++){
            if(L < height[i]){
                left[i] = -1;
                L = height[i];
            }else
            {
                left[i] = L;
            }
        }
        int R = 0;
        for(int i=height.length-1;i>=0;i--){
            if(R < height[i]){
                right[i] = -1;
                R = height[i];
            }else
            {
                right[i] = R;
            }
        }

        int area = 0;
        for(int i=0;i<height.length;i++){
            int tmp = 0;
            if(left[i]==-1 || right[i] == -1)
            {
                tmp = 0;
            }else{
                tmp = Math.min(left[i],right[i]) - height[i];
            }
            area += tmp;
        }

        return area;
    }
}
