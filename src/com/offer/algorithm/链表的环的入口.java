package com.offer.algorithm;

/**
 * @author shine10076
 * @date 2019/8/20 21:16
 */
public class 链表的环的入口 {


    public ListNode EntryNodeOfLoop(ListNode pHead)
    {

        if(pHead == null || pHead.next == null || pHead.next.next == null)
        {
            return null;
        }

        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;

        while(slow != fast)
        {

            if(slow.next == null || fast.next.next == null)
            {
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;

        }

        fast = pHead;

        while (fast!=slow)
        {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
