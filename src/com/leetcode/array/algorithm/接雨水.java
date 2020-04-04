package com.leetcode.array.algorithm;

import java.util.Arrays;

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
    public static int trap(int[] height) {
        if(height == null || height.length < 1) return 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        Arrays.fill(left,-1);
        Arrays.fill(right,-1);
        int L = -1;
        for(int i = 0;i < height.length;i++){
            if(height[i] > L){
                L = height[i];
            }else{
                left[i] = L;
            }
        }
        int R = -1;
        for(int i = height.length-1;i >= 0;i--){
            if(height[i] > R){
                R = height[i];
            }else{
                right[i] = R;
            }
        }
        int res = 0;
        for(int i = 0;i < height.length;i++){
            if(left[i] != -1 && right[i] != -1){
                res += (Math.min(left[i],right[i]) - height[i]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{2,0,2};
        System.out.println(trap(height));
    }
}
