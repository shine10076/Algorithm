package com.offer.algorithm;

import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/7/31 15:35
 */
public class 反转链表 {

    public ListNode ReverseList(ListNode head) {

        if(head == null) return null;

        if(head.next == null ) return head;

        ListNode res = new ListNode(0);
        ListNode tmp = head;
        while(tmp!=null)
        {
            ListNode node = tmp;
            tmp = tmp.next;
            node.next = res.next;
            res.next = node;
        }

        return res.next;
    }
}
