package com.offer.algorithm;

/**
 * @author shine10076
 * @date 2019/8/15 13:37
 */
public class 两个链表的公共节点 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        int m=0, n=0;
        ListNode p1 = pHead1,p2=pHead2;
        while (p1!=null)
        {
            m++;
            p1=p1.next;
        }
        while (p2!=null)
        {
            n++;
            p2=p2.next;
        }
        if(m>=n){
            p1=pHead1;
            p2=pHead2;
        }else
        {
            p2=pHead1;
            p1=pHead2;
            int tmp = m;
            m=n;
            n=tmp;
        }

        while(m>n)
        {
            p1=p1.next;
            m--;
        }
        ListNode res = null;
        while (p1!=null&&p2!=null)
        {
            if(p1==p2) {
                res = p1;
                break;
            }
            p1=p1.next;
            p2=p2.next;
        }
        return res;
    }
}
