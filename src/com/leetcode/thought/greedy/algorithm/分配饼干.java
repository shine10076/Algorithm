package com.leetcode.thought.greedy.algorithm;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author shine10076
 * @date 2019/5/23 17:00
 */
public class 分配饼干 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        for(int bis : s)
        {
            if(bis>=g[index])
            {
                index++;
                if(index>=g.length)
                {
                    break;
                }
            }
        }
        return index+1;
    }

}
