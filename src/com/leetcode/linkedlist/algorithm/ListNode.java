package com.leetcode.linkedlist.algorithm;

/**
 * @author shine10076
 * @date 2019/4/22 14:58
 */
public class ListNode {
    public int val;
    public ListNode next;

   public ListNode(int x) {
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
