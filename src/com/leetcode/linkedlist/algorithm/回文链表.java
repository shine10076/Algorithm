package com.leetcode.linkedlist.algorithm;

/**
 * @author shine10076
 * @date 2019/5/8 11:16
 */
public class 回文链表 {

    /**
     * 使用O(1)的额外空间
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if( head == null || head.next == null )
        {
            return true;
        }
        ListNode n1 = head;
        ListNode n2 = head;
        /**
         * 为了寻找中点
         */
        while(n1.next != null && n2.next.next != null)
        {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next;
        n1.next = null;
        ListNode n3;
        /**
         * 右半区反转
         */
        while(n2 != null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;
        n2 =head;
        boolean res = true;
        while (n1 != null && n2 != null) { // check palindrome
            if (n1.val != n2.val) {
                res = false;
                break;
            }
            n1 = n1.next; // left to mid
            n2 = n2.next; // right to mid
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) { // recover list
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }
}
