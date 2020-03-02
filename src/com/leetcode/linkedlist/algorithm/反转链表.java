package com.leetcode.linkedlist.algorithm;

import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/9/30 15:11
 */
public class 反转链表 {

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        if(head == null) return head;

        ListNode res = head;
        while (res.next != null)
        {
            res = res.next;
        }
        reverse(head,null);

        return res;
    }

    public void reverse(ListNode cur, ListNode pre){

        if(cur == null)
        {
            return;
        }

        reverse(cur.next,cur);
        cur.next = pre;
    }

    public ListNode reverseList2(ListNode head) {

        if(head == null) return null;

        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while(node != null){
            stack.push(node);
            node = node.next;
        }
        ListNode pre = stack.pop();
        ListNode res = pre;
        while(!stack.isEmpty()){
            pre.next = stack.peek();
            pre = stack.pop();
        }
        pre.next = null;

        return res;
    }
}
