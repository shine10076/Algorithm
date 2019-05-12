package com.leetcode.linkedlist.algorithm;

import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/5/11 15:12
 */
public class 两数相加II {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while(l1 != null)
        {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null)
        {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int flag = 0;
        ListNode res = new ListNode(0);
        while(!stack1.isEmpty() && !stack2.isEmpty())
        {
            int a = stack1.pop(),b =stack2.pop();
            ListNode node = new ListNode((a+b+flag)%10);
            node.next = res.next;
            res.next = node;
            flag = (a+b+flag)/10;
        }
        while(!stack1.isEmpty())
        {
            int a = stack1.pop();
            ListNode node = new ListNode((a+flag)%10);
            node.next = res.next;
            res.next = node;
            flag = (a+flag)/10;
        }
        while(!stack2.isEmpty())
        {
            int b = stack2.pop();
            ListNode node = new ListNode((b+flag)%10);
            node.next = res.next;
            res.next = node;
            flag = (b+flag)/10;
        }
        if(flag != 0)
        {
            ListNode node = new ListNode(flag);
            node.next = res.next;
            res.next = node;
        }
        return res.next;
    }
}
