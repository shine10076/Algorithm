package com.leetcode.backTrack.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shine10076
 * @date 2019/9/30 13:29
 */
public class 括号生成 {

    public List<String> generateParenthesis(int n) {

        ArrayList<String> res = new ArrayList<>();

        if(n <= 0)
        {
            return res;
        }

        backTrack(res,"",0,0,n);

        return res;

    }

    private void backTrack(ArrayList<String> res, String cur, int open, int close, int max)
    {
        if(cur.length() == 2*max)
        {
            res.add(cur);
            return;
        }

        if(open < max)
        {
            backTrack(res,cur+"(",open+1,close,max);
        }
        if(close<open)
        {
            backTrack(res,cur+")",open,close+1,max);
        }

    }
}
