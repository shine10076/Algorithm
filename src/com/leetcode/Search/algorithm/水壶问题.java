package com.leetcode.Search.algorithm;

import java.awt.*;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author shine10076
 * @date 2020/3/21 21:01
 */
public class 水壶问题 {
    public HashSet<String> set = new HashSet<>();
    public boolean canMeasureWater(int x, int y, int z) {
        // remain_x remain_y
        //remain_x ->0
        //remain_y ->0
        //remain_x -> (remain_y + remain_x )%x remain_y = (remain_y + remain_x)>x?remain_y+remain_x-x:0;
        if(x+y < z) return false;
        if(x == z || y == z || x + y == z){
            return true;
        }
        if(x == 0) return z%y == 0;
        if(y == 0) return z%x == 0;
        int remain_x = 0, remain_y = 0;
        set.clear();
        Stack<String> stack = new Stack<>();
        stack.push(remain_x+","+remain_y);
        while (!stack.isEmpty()){
            String[] cur = stack.pop().split(",");
            remain_x = Integer.parseInt(cur[0]);
            remain_y = Integer.parseInt(cur[1]);
            if(remain_x == z || remain_y == z || remain_x + remain_y == z){
                return true;
            }
            String s1 = 0+","+remain_y;
            if(!set.contains(s1)){
                set.add(s1);
                stack.add(s1);
            }
            String s2 = remain_x+","+0;
            if(!set.contains(s2)){
                set.add(s2);
                stack.add(s2);
            }
            String s3 = x + "," + remain_y;
            if(!set.contains(s3)){
                set.add(s3);
                stack.add(s3);
            }
            String s4 = remain_x + "," + y;
            if(!set.contains(s4)){
                set.add(s4);
                stack.add(s4);
            }
            int x5 = (remain_y+remain_x)%x;
            int y5 = (remain_y+remain_x)<=x?0:(remain_y+remain_x-x);
            String s5 = x5+","+y5;
            if(!set.contains(s5)){
                set.add(s5);
                stack.add(s5);
            }
            int y6 = (remain_y+remain_x)%y;
            int x6 = (remain_x+remain_y)<=y?0:(remain_x+remain_y-y);
            String s6 = x6+","+y6;
            if(!set.contains(s6)){
                set.add(s6);
                stack.add(s6);
            }
        }

        return false;
    }


    //水的总量总会增加x或者y
    //贝组定理：ax+by = z有解当且仅当 z 为x,y 最大公约数的倍数
    public boolean canMeasureWater2(int x, int y, int z){
        if(x + y < z) return false;
        if(x == 0 || y == 0 ) return z == 0 || x + y == z;
        return z%gcd(x,y)==0;
    }

    private int gcd(int m, int n){
        if(m < n){
            int tmp = m;
            m = n;
            n = tmp;
        }
        if(m%n == 0){
            return n;
        }else {
            return gcd(n,m%n);
        }
    }

}
