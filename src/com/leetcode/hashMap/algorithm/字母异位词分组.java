package com.leetcode.hashMap.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author shine10076
 * @date 2019/10/13 19:43
 */
public class 字母异位词分组 {

    public static List<List<String>> groupAnagrams(String[] strs) {

        ArrayList<Vocabulary> list = new ArrayList<>();
        ArrayList<List<String>> res = new ArrayList<>();
        for(String  s : strs)
        {
            list.add(new Vocabulary(s));
        }

        Collections.sort(list, new Comparator<Vocabulary>() {
            @Override
            public int compare(Vocabulary o1, Vocabulary o2) {
                return o1.id.compareTo(o2.id);
            }
        });


//        for(Vocabulary v: list)
//        {
//            System.out.println(v.strs+":"+v.id);
//        }

        String cur = list.get(0).id;
        ArrayList<String> curList = new ArrayList<>();
        curList.add(list.get(0).strs);
        for(int i=1;i<list.size();i++)
        {
            if(!cur.equals(list.get(i).id))
            {
                res.add(curList);
                curList = new ArrayList<>();
                curList.add(list.get(i).strs);
                cur = list.get(i).id;
            }
            else
            {
                curList.add(list.get(i).strs);
            }
        }
        res.add(curList);

        return res;

    }

   static  class Vocabulary{
        String strs;
        String id;

        public Vocabulary(String strs)
        {
            int[] ids = new int[26];
            StringBuilder sb = new StringBuilder();
            for(char c : strs.toCharArray())
            {
                ids[c-'a']++;
            }
            for(int i : ids)
            {
                sb.append(i);
            }
            this.strs = strs;
            this.id = sb.toString();
        }

    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(strs);
    }

}
