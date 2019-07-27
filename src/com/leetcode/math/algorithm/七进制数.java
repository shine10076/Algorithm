package com.leetcode.math.algorithm;

import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/7/27 20:33
 */
public class 七进制数 {

    public String convertToBase7(int num) {

        if(num == 0)
        {
            return "0";
        }

        StringBuilder sb =  new StringBuilder();

        boolean isNegative = num < 0;
        if(isNegative)
        {
            num = -num;
        }

        while(num>0)
        {
            sb.append(num%7);
            num = num/7;
        }

        String res = sb.reverse().toString();
        return isNegative?"-"+res:res;

    }
}
