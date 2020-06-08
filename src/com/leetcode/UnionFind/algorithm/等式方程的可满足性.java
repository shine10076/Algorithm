package com.leetcode.UnionFind.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shine10076
 * @date 2020/6/8 9:43
 */
public class 等式方程的可满足性 {

    public static boolean equationsPossible(String[] equations) {
        int[] letter = new int[26];
        for(int i=0;i<26;i++) letter[i] = i;
        List<String> notEqual = new ArrayList<>(500);
        for(String s : equations){
            if(s.substring(1,3).equals("==")){
                int a = s.charAt(0)-'a';
                int b = s.charAt(3)-'a';
                //下标大的合并下标小的
                if(a < b) union(letter,a,b);
                else if(a > b) union(letter,b,a);
            }else{
                notEqual.add(s);
            }
        }

        for(String s : notEqual){
            int a = s.charAt(0)-'a';
            int b = s.charAt(3)-'a';
            if(findhead(letter,a) == findhead(letter,b)){
                return false;
            }
        }
        return true;

    }

    public static void union(int[] letter, int a, int b){
        int ahead = findhead(letter,a);
        int bhead = findhead(letter,b);
        for(int i = 0;i<letter.length;i++){
            if(letter[i] == bhead) letter[i] = ahead;
        }
    }

    public static int findhead(int[] letter, int i){
        return letter[i];
    }

    public static void main(String[] args) {
        String[] equations = new String[]{
                "a==b","e==c","b==c","a!=e"
        };

        equationsPossible(equations);
    }
}
