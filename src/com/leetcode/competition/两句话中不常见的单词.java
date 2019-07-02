package com.leetcode.competition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shine10076
 * @date 2019/4/15 14:56
 */
public class 两句话中不常见的单词 {

    public static String[] uncommonFromSentences(String A, String B) {
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        List<String> list = new ArrayList<>();
        Map<String, Integer> aList = new HashMap<>();
        Map<String, Integer> bList = new HashMap<>();
        for (String s : a) {

            if (aList.containsKey(s)) aList.put(s, aList.get(s) + 1);
            else aList.put(s, 1);
        }
        for (String s : b) {
            if (bList.containsKey(s)) bList.put(s, bList.get(s) + 1);
            else bList.put(s, 1);
        }
        for (Map.Entry<String, Integer> entry : aList.entrySet()) {

            if (!bList.containsKey(entry.getKey()) && entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        for (Map.Entry<String, Integer> entry : bList.entrySet()) {

            if (!aList.containsKey(entry.getKey()) && entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[list.size()]);
    }

}
