package com.leetcode.linkedlist.algorithm;

/**
 * @author shine10076
 * @date 2019/5/12 20:54
 */
public class 分割链表 {

    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        ListNode pre = new ListNode(0);
        int len  = 0;
        ListNode cur = root;
        while(cur != null)
        {
            ++len;
            cur = cur.next;
        }
        if(len < k)
        {
            cur = root;
            int i = 0;
            while(cur != null)
            {
                res[i++] = cur;
                pre = cur;
                cur = cur.next;
                pre.next = null;
            }
            while(i<len)
            {
                res[i++] = null;
            }
        }
        else
        {
            /*当k>=len*/
            cur = root;
            int i = 0;
            int add = len%k;
            int eachlen = len/k;

            while(i<k)
            {
                res[i] = cur;
                i++;
                for(int j = 0;j<eachlen;j++)
                {
                    pre = cur;
                    cur = cur.next;
                }
                if(add>0)
                {
                    pre = cur;
                    cur = cur.next;
                    add--;
                }
                pre.next = null;
            }

        }
        return res;
    }

    public static void printList(ListNode head)
    {
        ListNode cur =head;
        while(cur != null)
        {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1};
        ListNode head = new ListNode(100);
        ListNode cur = head;
        for(int i=0;i<nums.length;++i)
        {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        ListNode[] res = splitListToParts(head.next,1);
        res[0].printList();
    }
}
