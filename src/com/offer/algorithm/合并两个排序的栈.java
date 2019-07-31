package com.offer.algorithm;

/**
 * @author shine10076
 * @date 2019/7/31 15:52
 */
public class 合并两个排序的栈 {

    public ListNode Merge(ListNode list1,ListNode list2) {

        ListNode p1 = list1;
        ListNode p2 = list2;

        ListNode res = new ListNode(0);
        ListNode p = res;

        while(p1!=null && p2 != null)
        {
            if(p1.val <= p2.val)
            {
                p.next = p1;
                p=p.next;
                p1=p1.next;
            }else
            {
                p.next = p2;
                p = p.next;
                p2 =p2.next;
            }
        }
        while (p1!=null)
        {
            p.next = p1;
            p=p.next;
            p1=p1.next;
        }
        while (p2!=null)
        {
            p.next = p2;
            p = p.next;
            p2 =p2.next;
        }
        return res.next;
    }
}
