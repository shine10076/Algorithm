package com.offer.algorithm;

import java.util.List;

/**
 * @author shine10076
 * @date 2019/7/9 20:19
 */
public class 链表倒数第k个节点 {

    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode first = head;
        ListNode second = head;
        for(int i=0;i<k-1;i++)
        {
            if(first.next != null)
            {
                first = first.next;
            }else
            {
                return null;
            }
        }
        while (first.next !=null)
        {
            first=first.next;
            second=second.next;
        }
        return second;
    }
}
