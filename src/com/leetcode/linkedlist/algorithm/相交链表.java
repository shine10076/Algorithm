package com.leetcode.linkedlist.algorithm;

/**
 * @author shine10076
 * @date 2019/4/22 14:57
 */
public class 相交链表 {

    /*判断无环链表是否相交*/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
        {
            return null;
        }
        int n = 0;
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while(cur1!= null)
        {
            n++;
            cur1 = cur1.next;
        }
        while(cur2 != null)
        {
            n--;
            cur2 = cur2.next;
        }
        if(cur1 != cur2)
        {
            return null;
        }

        cur1 = n>0?headA:headB;
        cur2 = cur1 == headA?headB:headA;
        n = Math.abs(n);
        while(n > 0)
        {
            cur1 = cur1.next;
            n--;
        }
        while(cur1 != cur2)
        {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur2;
    }
}
