package com.offer.algorithm;

import java.util.HashMap;

/**
 * @author shine10076
 * @date 2019/8/1 15:20
 */
public class 复杂链表的复制 {

    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null) return null;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();

        RandomListNode head = pHead;
        RandomListNode res = new RandomListNode(0);
        RandomListNode p1 = res;

        /**
         * 构造顺序链表
         */
        while (head != null)
        {

            RandomListNode node = new RandomListNode(head.label);
            map.put(head,node);
            p1.next = node;
            p1 = p1.next;
            head = head.next;
        }

        RandomListNode rand = pHead;
        RandomListNode p2 = res.next;
        while (rand != null && p2 != null)
        {
            if(rand.random != null)
            {
                p2.random = map.get(rand.random);
            }
            p2 = p2.next;
            rand = rand.next;
        }

        return res.next;
    }

}


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}