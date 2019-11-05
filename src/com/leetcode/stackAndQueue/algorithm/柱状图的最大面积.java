package com.leetcode.stackAndQueue.algorithm;

import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/11/5 16:29
 */
public class 柱状图的最大面积 {

    public static int largestRectangleArea(int[] heights) {

        if(heights == null || heights.length < 1){
            return 0;
        }
        if(heights.length == 1) return heights[0];

        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        for(int i=0;i<heights.length;i++){
            left[i] = -1;
            right[i] = heights.length;
        }
        /**
         * 更新left数组和right数组
         */
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<heights.length;i++){
            if(stack.isEmpty()){
                stack.push(i);
            }else if( heights[i] > heights[stack.peek()] ){
                left[i] = stack.peek();
                stack.push(i);
            }else if(heights[i] < heights[stack.peek()])
            {
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                    right[stack.peek()] = i;
                    stack.pop();
                }
                if(!stack.isEmpty()&&heights[i] > heights[stack.peek()]){
                    left[i] = stack.peek();
                    stack.push(i);
                }else if(!stack.isEmpty()&&heights[i]==heights[stack.peek()])
                {
                    left[i] = left[stack.peek()];
                    stack.push(i);
                }else{
                    stack.push(i);
                }
            }else {
                left[i] = left[stack.peek()];
                stack.push(i);
            }
        }

        int L = 0, R = 0;
        int res = 0;
        for(int i=0;i<heights.length;i++){
            L = left[i];
            R = right[i];
            int width = R-L-1;
            int area = width*heights[i];
            res = Math.max(area,res);
        }


        return res;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
}
