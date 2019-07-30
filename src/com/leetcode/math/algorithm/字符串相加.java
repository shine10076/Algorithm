package com.leetcode.math.algorithm;

/**
 * @author shine10076
 * @date 2019/7/30 19:58
 */
public class 字符串相加 {

    public String addStrings(String num1, String num2) {

        StringBuilder sb  = new StringBuilder();

        int m = num1.length()-1, n = num2.length()-1;
        int flag = 0;
        while (m>=0 || n>=0)
        {
            int addA = 0, addB = 0;

            if(m>=0)
            {
                addA = num1.charAt(m)-'0';
                m--;
            }
            if(n>=0)
            {
                addB = num2.charAt(n)-'0';
                n--;
            }
            int sum = addA + addB + flag;
            if(sum<10)
            {
                sb.append((char)(sum+'0'));
                flag = 0;
            }else
            {
                sb.append((char)(sum-10+'0'));
                flag = 1;
            }

        }

        if(flag == 1)
        {
            sb.append((char)(1+'0'));
        }

        return sb.reverse().toString();

    }
}
