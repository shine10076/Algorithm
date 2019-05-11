package com.leetcode.linkedlist.algorithm;

/**
 * @author shine10076
 * @date 2019/5/9 19:47
 */
public class 删除链表重复元素 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null&&cur.next!=null)
        {
            if(cur.val == cur.next.val)
            {
                delete(cur.next,cur);
            }
            else
                cur=cur.next;
        }
        return head;
    }
    private void delete(ListNode node,ListNode pre)
    {
        pre.next = node.next;
    }
}
