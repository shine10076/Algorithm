package com.leetcode.greedy.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author shine10076
 * @date 2020/4/13 17:00
 */
public class 用户分组 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < groupSizes.length; i++){
            if(!map.containsKey(groupSizes[i])){
                map.put(groupSizes[i],new ArrayList<>());
            }
            map.get(groupSizes[i]).add(i);
        }
        for(Integer i : map.keySet()){
            List<Integer> list = map.get(i);
            List<Integer> element = new ArrayList<>();
            for(Integer j : list){
                element.add(j);
                if(element.size() == i){
                    res.add(new ArrayList<>(element));
                    element.clear();
                }
            }
        }
        return res;
    }
}
