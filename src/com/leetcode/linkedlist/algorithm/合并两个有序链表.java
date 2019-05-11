package com.leetcode.linkedlist.algorithm;

/**
 * @author shine10076
 * @date 2019/5/9 19:11
 */
public class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode cur = new ListNode(0);
        ListNode head = cur;
        while(l1!=null && l2!=null)
        {
            if(l1.val < l2.val)
            {
                cur.next=l1;
                l1 = l1.next;
                cur=cur.next;
            }
            else
            {
                cur.next = l2;
                l2 = l2.next;
                cur=cur.next;
            }
        }
        while(l1 != null)
        {
            cur.next=l1;
            l1=l1.next;
            cur=cur.next;
        }
        while(l2 != null)
        {
            cur.next=l2;
            l2=l2.next;
            cur=cur.next;
        }
        return head.next;
    }
}
