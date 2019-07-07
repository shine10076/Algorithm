package com.leetcode.thought.doublePoint.algorithm;

/**
 * @author shine10076
 * @date 2019/7/5 12:32
 */
public class 盛最多水的容器 {

    public int maxArea(int[] height) {
        int L = 0, R = height.length-1;
        int res = 0;
        while(L<R)
        {
            int curArea = (R-L)*Math.min(height[L],height[R]);
            res = Math.max(res,curArea);
            if(height[L]<=height[R])
            {
                L++;
            }else
            {
                R--;
            }
        }
        return res;
    }
}
