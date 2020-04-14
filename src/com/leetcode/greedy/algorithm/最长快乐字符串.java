package com.leetcode.greedy.algorithm;

import java.util.Arrays;

/**
 * @author shine10076
 * @date 2020/4/14 14:31
 */
public class 最长快乐字符串 {

    public static String longestDiverseString(int a, int b, int c) {

        point[] p = new point[]{new point(a,'a'),new point(b,'b'),new point(c,'c')};
        StringBuilder sb = new StringBuilder(a+b+c);
        boolean flag = true;
        while (true){
            Arrays.sort(p);
            if(sb.length() >= 2 && sb.charAt(sb.length()-1) == p[0].c && sb.charAt(sb.length()-2) == p[0].c){
                if(p[1].value-- > 0){
                    sb.append(p[1].c);
                }else{
                    break;
                }
            }else {
                if(p[0].value-- > 0){
                    sb.append(p[0].c);
                }else {
                    break;
                }
            }
        }
        return sb.toString();
    }

   static class point implements Comparable<point>{
        int value;
        char c;

        public point(int value, char c) {
            this.value = value;
            this.c = c;
        }

        @Override
        public int compareTo(point o) {
            return o.value - this.value;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestDiverseString(0,8,11));
    }
}
