package com.leetcode.math.algorithm;

import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/7/30 19:38
 */
public class 二进制求和 {

    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int m = a.length()-1, n = b.length()-1;
        int flag = 0;
        while(m>=0||n>=0)
        {
            int bitA = 0, bitB = 0;
            if(m>=0)
            {
                bitA = a.charAt(m)=='1'?1:0;
                m--;
            }
            if(n>=0)
            {
                bitB = b.charAt(n)=='1'?1:0;
                n--;
            }
            int sum = flag + bitA + bitB;
            if(sum==3)
            {
                sb.append('1');
                flag = 1;
            }else if(sum==2)
            {
                sb.append('0');
                flag = 1;
            }else if(sum == 1)
            {
                sb.append('1');
                flag = 0;
            }else
            {
                sb.append('0');
                flag = 0;
            }
        }
        if(flag == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
