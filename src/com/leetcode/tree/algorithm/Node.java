package com.leetcode.tree.algorithm;

/**
 * @author shine10076
 * 2019/11/19 20:47
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
