package com.leetcode.stackAndQueue.algorithm;

import java.util.*;

/**
 * @author shine10076
 * @date 2019/10/5 14:29
 */
public class NestedIterator implements Iterator<Integer> {


    private int curIndex = 0;

    private NestedInteger cur = null;

    private Queue<Integer> queue = null;

    private List<NestedIterator> dataList = null;

    public NestedIterator(List<NestedInteger> nestedList) {

        if(nestedList == null) return ;

        curIndex = 0;
        cur = nestedList.get(0);




    }

    @Override
    public Integer next() {
        return 0;
    }

    @Override
    public boolean hasNext() {
        return false;
    }


    public void createQueue(Queue<Integer> queue, NestedInteger cur)
    {
        queue = new LinkedList<>();
        while (!cur.isInteger())
        {

        }

    }

}
