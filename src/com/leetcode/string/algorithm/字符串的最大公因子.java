package com.leetcode.string.algorithm;

/**
 * @author shine10076
 * @date 2020/3/12 17:52
 */
public class 字符串的最大公因子 {

    public static String gcdOfStrings(String str1, String str2) {
        int m = str1.length(),n=str2.length();
        int end = 0;
        for(int i = 0;i<Math.min(m,n);i++){
            if(str1.charAt(i) == str2.charAt(i)){
                end++;
            }else {
                break;
            }
        }

        for(int i = end;i>0;i--){
            String common = str1.substring(0,i);
            if(isDivide(str1,common)&&isDivide(str2,common)){
                return common;
            }
        }
        return "";
    }

    private static boolean isDivide(String s, String subStr){
        int time = s.length() / subStr.length();
        StringBuilder sb = new StringBuilder(s.length()*2);
        for(int i=0;i<time;i++){
            sb.append(subStr);
        }
        return sb.toString().equals(s);
    }

    //Math Problem
    public static String gdcOfStrings2(String str1, String str2){
        if(!(str1+str2).equals(str2+str1)) return "";
        return str1.substring(0,gcd(str1.length(),str2.length()));
    }

    public static int gcd(int m,int n) {
        if(m<n) {
            int k=m;
            m=n;
            n=k;
        }
        //if(m%n!=0) {
        //    m=m%n;
        //    return gcd(m,n);
        //}
        //return n;
        return m%n == 0?n:gcd(n,m%n);
    }
    public static void main(String[] args) {
        String str1 = "ABABAB";
        String str2 = "ABAB";
        System.out.println(gcdOfStrings(str1,str2));
    }
}
