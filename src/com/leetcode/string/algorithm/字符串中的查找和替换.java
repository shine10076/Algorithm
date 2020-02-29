package com.leetcode.string.algorithm;

import java.util.*;

/**
 * @author shine10076
 * @date 2020/2/29 20:21
 */
public class 字符串中的查找和替换 {

    public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {

        int N = S.length();
        //matches[i] = l代表S中下标i开始l长度的可以被替换
        int[] matches = new int[N];
        Arrays.fill(matches,-1);

        for(int i = 0; i < indexes.length;i++){
            if(S.substring(indexes[i],indexes[i]+sources[i].length()).equals(sources[i])){
                matches[indexes[i]] = i;
            }
        }

        StringBuilder res = new StringBuilder();
        int index = 0;
        while (index < S.length()){

            if(matches[index] != -1){
                res.append(targets[matches[index]]);
                index += sources[matches[index]].length();
            }else {
                res.append(S.charAt(index));
                index++;
            }

        }

        return res.toString();

    }

    public static void main(String[] args) {
        String S = "abcd";
        int[] indexes = new int[]{0,2};
        String[] sources = new String[]{"a","cd"};
        String[] targets = new String[]{"eee","ffff"};

        System.out.println(findReplaceString(S,indexes,sources,targets));
    }

}
