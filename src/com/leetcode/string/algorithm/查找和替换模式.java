package com.leetcode.string.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author shine10076
 * @date 2020/2/18 15:47
 */
public class 查找和替换模式 {

    public static List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> res = new ArrayList<>();
        char[] p = pattern.toCharArray();

        for(String w : words){
            if(w.length() != pattern.length()) continue;
            HashMap<Character,Character> map = new HashMap<>();
            HashSet<Character> set = new HashSet<>();
            char[] word = w.toCharArray();
            char[] copy = new char[word.length];
            for(int i=0;i<word.length;i++){
                if(map.containsKey(p[i])){
                    if(map.get(p[i]) == word[i]) {
                        copy[i] = p[i];
                    }else {
                        copy[i] = word[i];
                    }
                }else {
                    if(!set.contains(word[i])){
                        copy[i] = p[i];
                        map.put(p[i],word[i]);
                        set.add(word[i]);
                    }else {
                        copy[i] = word[i];
                    }

                }
            }

            String transfer = String.copyValueOf(copy);
            if(transfer.equals(pattern)){
                res.add(w);
            }

        }

        return res;
    }


    public static void main(String[] args) {
        String[] words = new String[]{
                "abc","deq","mee","aqq","dkd","ccc"
        };
        String pattern = "abb";
        for(String s : findAndReplacePattern(words,pattern)){
            System.out.print(s+" ");
        }
    }
}
