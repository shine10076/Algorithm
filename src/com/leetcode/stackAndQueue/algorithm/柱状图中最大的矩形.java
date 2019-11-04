package com.leetcode.stackAndQueue.algorithm;

import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/11/4 15:55
 */
public class 柱状图中最大的矩形 {

    public static int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length < 0 ){
            return 0;
        }
        if(heights.length == 1) return heights[0];

        Stack<Integer> stack = new Stack<>();
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        for(int i=0;i<heights.length;i++)
        {
            left[i] = -1;
            right[i] = heights.length;
        }

        stack.push(0);
        for(int i=1;i<heights.length;i++)
        {
            //小，大
            if( heights[stack.peek()] < heights[i] ){
                left[i] = stack.peek();
                stack.push(i);
            }
            //大，小
            else if(heights[stack.peek()] > heights[i] ){
                while (!stack.isEmpty()&&heights[stack.peek()] > heights[i])
                {
                    int out = stack.pop();
                    right[out] = i;
                }

                stack.push(i);
            }
            else
            {
                stack.push(i);
            }
        }

        int res = 0;
        int L = 0;
        int R = heights.length-1;
        for(int i=0;i<heights.length;i++)
        {
            if(left[i] != -1)
            {
                L = left[i];
            }
            else
            {
                L = 0;
            }

            if(right[i] != -1)
            {
                R = right[i];
            }
            else
            {
                R = heights.length-1;
            }

            int tmp = (R-L-1)*heights[i];
            res = Math.max(tmp,res);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] heights = new int[]{2,1,5,6,2,3};
        System.out.println("最大面积是"+largestRectangleArea(heights));

    }
}
