package com.offer.algorithm;

/**
 * @author shine10076
 * @date 2019/8/15 16:02
 */
public class 左旋转字符串  {

    public static String LeftRotateString(String str,int n) {

        if(str == null || str.length() == 0) return "";

        if(n>str.length()) return "";

        //substring方法返回子字符串，包括起始索引，不包括结尾索引
        StringBuilder a = new StringBuilder();
        a.append(str.substring(0,n));

        StringBuilder b = new StringBuilder();
        b.append(str.substring(n,str.length()));

        StringBuilder res = new StringBuilder();

        res.append(a.reverse().toString());
        res.append(b.reverse().toString());
        res.reverse();
        return res.toString();
    }


    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(str.substring(0,2));
        System.out.println(str.substring(2,str.length()));

        System.out.println(LeftRotateString(str,2));
    }
}
