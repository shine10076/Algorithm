package com.offer.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shine10076
 * @date 2019/8/21 19:19
 */
public class 删除链表中重复的节点 {


    public static ListNode deleteDuplication(ListNode pHead)
    {
        ListNode p = pHead;
        ListNode res = new ListNode(0);
        ListNode pre = res;
        boolean delete = false;
        int del = 0;
        while (p != null)
        {
            if(p.next != null && p.next.val != p.val)
            {
                pre.next = p;
                pre = p;
                p = p.next;
            }
            else if(p.next == null)
            {
                if(delete)
                {
                    if(del!=p.val)
                    {
                        pre.next = p;
                        pre = p;
                        p=p.next;
                    }
                }
            }
            else
            {
                //删除重复节点
                pre.next = null;
                del = p.val;
                delete = true;
                while (p.next != null&& p.val==del)
                {
                    p = p.next;
                }
            }
        }

        return res.next;
    }


    public static void main(String[] args) {

        ListNode res = new ListNode(0);
        ListNode p = res;
        int[] num = new int[]{1,2,3,3,4,4,5};
        for(int i:num )
        {
            ListNode node = new ListNode(i);
            p.next = node;
            p = p.next;
        }

        ListNode result = deleteDuplication(res.next);
        while (result!=null)
        {
            System.out.print(result.val+"  ");
            result = result.next;
        }
    }

}
