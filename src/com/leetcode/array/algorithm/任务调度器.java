package com.leetcode.array.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shine10076
 * @date 2019/10/16 18:52
 */
public class 任务调度器 {

    public int leastInterval(char[] tasks, int n) {

        Queue<Character> queue = new LinkedList<>();
        int[] letter = new int[26];
        for(char c : tasks)
        {
            letter[c-'A']++;
        }
        boolean flag = true;
        while (flag)
        {
            flag = false;
            for(int i=0;i<26;i++)
            {
                if(letter[i]!=0)
                {
                    letter[i]--;
                    queue.offer((char)('A'+i));
                    flag = true;
                }
            }
        }

        return 0;
    }
}
