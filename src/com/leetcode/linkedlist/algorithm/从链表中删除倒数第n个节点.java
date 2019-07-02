package com.leetcode.linkedlist.algorithm;

/**
 * @author shine10076
 * @date 2019/5/9 19:55
 */
public class 从链表中删除倒数第n个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        ListNode pre = null;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            pre = slow;
            fast = fast.next;
            slow = slow.next;
        }
        pre.next = slow.next;
        return head;
    }
}
