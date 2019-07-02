package com.offer.algorithm;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/4/7 21:08
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class 从头到尾打印链表 {

    private ArrayList solution(ListNode listNode) {
        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }
}
