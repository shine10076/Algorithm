package com.leetcode.string.algorithm;

/**
 * @author shine10076
 * @date 2020/2/27 17:41
 */
public class 最长特殊子序列I {

    public int findLUSlength(String a, String b) {

        int m = a.length(), n = b.length();
        if(m != n){
            return Math.max(m,n);
        }else {
            if(a.equals(b)){
                return -1;
            }
            return m;
        }

    }

    public int findLUSlength2(String a, String b){

        return a.equals(b)? -1 : Math.max(a.length(),b.length());
    }
}
