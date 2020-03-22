package com.leetcode.array.algorithm;

/**
 * @author shine10076
 * @date 2020/3/22 22:41
 */
public class 使数组唯一的最小增量 {

    public int minIncrementForUnique(int[] A) {
        int[] map = new int[80000];
        for(int i : A){
            map[i]++;
        }
        int res = 0;
        for(int i=0;i<map.length;i++){
            if(map[i] > 1){
                map[i+1] += map[i]-1;
                res += map[i]-1;
                map[i] = 1;
            }
        }
        return res;
    }
}
