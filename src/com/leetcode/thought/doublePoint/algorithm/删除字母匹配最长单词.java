package com.leetcode.thought.doublePoint.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author shine10076
 * @date 2019/5/21 16:10
 * @leetcode 524
 */
public class 删除字母匹配最长单词 {

    public static String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String target : d) {
            int l1 = longestWord.length(), l2 = target.length();
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (isWord(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;

    }

    private static boolean isWord(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }

    public static void main(String[] args) {
        System.out.println(isWord("abpcplea", "a"));
    }
}
