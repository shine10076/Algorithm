package com.leetcode.linkedlist.algorithm;

/**
 * @author shine10076
 * @date 2019/4/22 14:58
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
        next = null;
    }

    public void printList() {
        ListNode cur = this;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}
