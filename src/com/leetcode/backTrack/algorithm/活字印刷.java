package com.leetcode.backTrack.algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shine10076
 * @date 2019/10/6 16:42
 */
public class 活字印刷 {

    int res = 0;
    public int numTilePossibilities(String tiles) {

        int[] counts  = new int[26];
        for(char c : tiles.toCharArray())
        {
            counts[c-'A']++;
        }

        res = 0;

        dfs(counts);

        return res;

    }


    public void dfs(int[] counts)
    {

        for(int i=0;i<26;i++)
        {
            if(counts[i] == 0)
                continue;
            res++;
            counts[i]--;
            dfs(counts);
            counts[i]++;
        }

    }
}
