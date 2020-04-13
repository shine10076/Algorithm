package com.leetcode.greedy.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shine10076
 * @date 2020/4/13 16:21
 */
public class 单调递增的数 {

    public int monotoneIncreasingDigits(int N) {
        ArrayList<Integer> list = new ArrayList<>();
        while(N > 0){
            int num = N%10;
            N = N/10;
            list.add(num);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < list.size();i++){
            res.add(list.get(i));
            if(i > 0 && res.get(i) > res.get(i-1)){
                res.set(i,res.get(i)-1);
                for(int j = 0; j < i; j++) res.set(j,9);
            }
        }
        int ans = 0;
        for(int i=res.size()-1;i>=0;i--){
            ans *= 10;
            ans += res.get(i);
        }
        List<Integer> list1 = new ArrayList<>();
        return ans;
    }
}
