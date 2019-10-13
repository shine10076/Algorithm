package com.sort.algorithm;

import com.leetcode.linkedlist.algorithm.ListNode;

/**
 * @author shine10076
 * @date 2019/10/13 15:35
 */
public class SortLinkedtList {

    /**
     * 采用归并排序思想
     * @param head : 链表头
     * @return 链表头
     */
    public ListNode sortList(ListNode head) {

        if(head == null)
        {
            return null;
        }

        return mergeSort(head);

    }

    public ListNode mergeSort(ListNode head)
    {
        if(head == null)
        {
            return null;
        }

        if(head.next == null)
        {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        /**
         * 切割链表
         */
        ListNode cut = slow.next;
        slow.next = null;

        return merge(mergeSort(head),mergeSort(cut));
    }

    public ListNode merge(ListNode list1, ListNode list2)
    {
        ListNode res = new ListNode(0);
        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode cur = res;
        while (head1 != null && head2 != null)
        {
            if(head1.val < head2.val)
            {
                cur.next = head1;
                head1 = head1.next;
                cur = cur.next;
            }
            else
            {
                cur.next = head2;
                head2 = head2.next;
                cur = cur.next;
            }
        }
        while (head1 != null)
        {
            cur.next = head1;
            head1 = head1.next;
            cur = cur.next;
        }
        while (head2 != null)
        {
            cur.next = head2;
            head2 = head2.next;
            cur = cur.next;
        }

        return res.next;
    }

}
