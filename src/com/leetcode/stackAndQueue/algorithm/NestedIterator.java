package com.leetcode.stackAndQueue.algorithm;

import java.util.*;

/**
 * @author shine10076
 * @date 2019/10/5 14:29
 */
public class NestedIterator implements Iterator<Integer> {



    private Queue<Integer> queue = null;


    public NestedIterator(List<NestedInteger> nestedList) {

        queue = new LinkedList<>();
        if(nestedList == null) return ;
        for(NestedInteger cur : nestedList)
        {
            queue.addAll(createList(cur));
        }

    }

    @Override
    public Integer next() {

        if(queue.isEmpty())
        {
            throw new IndexOutOfBoundsException("非法遍历");
        }

        int res = queue.poll();
        return res;

    }

    @Override
    public boolean hasNext() {

        return !queue.isEmpty();
    }

    public List<Integer> createList(NestedInteger nestedInteger)
    {
        List<Integer> res = new ArrayList<>();
        if(nestedInteger == null ) return res;
        if(nestedInteger.isInteger())
        {
            res.add(nestedInteger.getInteger());
        }
        else
        {
            List<NestedInteger> list = nestedInteger.getList();
            for(NestedInteger integer : list)
            {
                res.addAll(createList(integer));
            }
        }
        return res;
    }

}
