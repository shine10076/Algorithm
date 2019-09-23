package com.leetcode.competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shine10076
 * @date 2019/9/22 15:44
 */
public class 最小绝对差 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++)
        {
            int diff = Math.abs(arr[i]-arr[i-1]);
            min = Math.min(diff,min);
        }

        for(int i=1;i<arr.length;i++)
        {
            int diff = Math.abs(arr[i]-arr[i-1]);
            if(diff == min)
            {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i-1]);
                list.add(arr[i]);
                res.add(list);
            }
        }

        return res;

    }
}
