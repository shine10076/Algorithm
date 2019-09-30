package com.leetcode.linkedlist.algorithm;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author shine10076
 * @date 2019/9/28 16:17
 */
public class 合并k个排序链表 {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });

        for(ListNode head : lists)
        {
            if(head == null) continue;

            ListNode p = head;
            while (p!=null)
            {
                ListNode item = p;
                queue.offer(item);
                p = p.next;
            }

        }

        if(queue.isEmpty()) return null;
        ListNode res = queue.poll();
        ListNode p = res;
        while (!queue.isEmpty())
        {
            p.next = queue.poll();
            p = p.next;
        }
        return res;

    }
}
