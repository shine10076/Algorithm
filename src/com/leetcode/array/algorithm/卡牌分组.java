package com.leetcode.array.algorithm;

/**
 * @author shine10076
 * @date 2020/3/27 10:58
 */
public class 卡牌分组 {

    public boolean hasGroupsSizeX(int[] deck) {
        int[] map = new int[10000];
        for(int i : deck){
            map[i]++;
        }
        int min = -1;
        for(int i : map ){
            if(i == 0) continue;
            if(min == -1){
                min = i;
            }else{
                min = Math.min(min,gcd(min,i));
            }
        }
        return min > 1;
    }

    private int gcd(int m, int n){
        if(m < n){
            int t = m;
            m = n;
            n = t;
        }
        if(m%n == 0) return n;
        return gcd(n, m%n);
    }
}
