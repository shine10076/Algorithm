package com.leetcode.linkedlist.algorithm;

import java.util.List;

/**
 * @author shine10076
 * @date 2019/5/11 14:47
 */
public class 两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode cur = head;
        ListNode pre = res;
        while(cur != null && cur.next != null)
        {

            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = cur;
            pre.next = temp;
            pre = cur;
            cur = cur.next;
        }
        return res.next;
    }
}
