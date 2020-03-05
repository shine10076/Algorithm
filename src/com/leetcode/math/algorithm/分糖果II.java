package com.leetcode.math.algorithm;

/**
 * @author shine10076
 * @date 2020/3/5 10:09
 */
public class 分糖果II {

    public int[] distributeCandies(int candies, int n) {
        int[] res = new int[n];
        int index = 0;
        int count = 1;
        while(candies > 0){
            index = index % n;
            if(candies >= count){
                res[index++] += count;
                candies -= count;
                count++;
            }else
            {
                res[index++] += candies;
                candies -= candies;
            }
        }
        return res;
    }

    public int[] distributeCandies2(int candies, int n){

        //p(p+1)/2 <= candies < (p^2+p)/2 +p+1
        // 2*candies < p^2+3p+2
        // P^2 + 3p + 2 -2C
        // p = floor((-3+sqrt(1+8C))/2);
        // p > floor(sqrt(2C+1/4) - 3/2) && p <= floor(sqrt(2C+1/4)-1/2);
        int p = (int)(Math.sqrt(2*candies+0.25)-0.5);
        int remaining = (int)(candies - (p + 1) * p * 0.5);
        int rows = p / n, cols = p % n;

        int[] d = new int[n];
        for(int i = 0; i < n; ++i) {
            // complete rows
            d[i] = (i + 1) * rows + (int)(rows * (rows - 1) * 0.5) * n;
            // cols in the last row
            if (i < cols) d[i] += i + 1 + rows * n;
        }
        // remaining candies
        d[cols] += remaining;
        return d;

    }
}
