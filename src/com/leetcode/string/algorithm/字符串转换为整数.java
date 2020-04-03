package com.leetcode.string.algorithm;

/**
 * @author shine10076
 * @date 2020/4/3 14:18
 */
public class 字符串转换为整数 {

    public int myAtoi(String str) {
        str = str.trim();
        if(str.length() < 1) return 0;
        StringBuilder num = new StringBuilder();
        boolean isPositive = true;
        int index = 0;
        //判断首字符是否合法
        if(!Character.isDigit(str.charAt(index)) && str.charAt(index)!='+' && str.charAt(index)!='-'){
            return 0;
        }
        //正负
        if(str.charAt(index) == '-') {
            isPositive = false;
            index++;
        }
        else if(str.charAt(index) == '+') {
            index++;
        }
        //选取合法候选的字符
        while (index < str.length()){
            if(Character.isDigit(str.charAt(index))){
                num.append(str.charAt(index++));
            }else {
                break;
            }
        }

        if(num.length() < 1) return 0;
        int res = 0;
        for(int i = 0; i < num.length(); i++){
            int digit = (num.charAt(i)-'0');
            if(res > (Integer.MAX_VALUE - digit) / 10) {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }else {
                res *= 10;
                res += digit;
            }
        }

        return isPositive? res : -res;
    }

}
