package com.leetcode.linkedlist.algorithm;

import java.util.List;

/**
 * @author shine10076
 * @date 2019/5/12 21:38
 */
public class 奇偶链表 {

    public static ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode oddHead = odd;
        ListNode even = new ListNode(0);
        ListNode evenHead = even;
        ListNode cur = head;
        boolean isOdd = true;
        while(cur != null)
        {
            if(isOdd)
            {
                odd.next = cur;
                odd = odd.next;
            }
            else
            {
                even.next = cur;
                even = even.next;
            }
            cur = cur.next;
            isOdd = !isOdd;
        }
        even.next = null;
        odd.next = evenHead.next;
        return oddHead.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        ListNode head = new ListNode(100);
        ListNode cur = head;
        for(int i=0;i<nums.length;++i)
        {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        ListNode res = oddEvenList(head.next);
    }
}
