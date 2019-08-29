package com.offer.algorithm;

/**
 * @author shine10076
 * @date 2019/8/29 20:20
 */
public class 表示数值的字符串 {


    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0)
            return false;
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }


}
