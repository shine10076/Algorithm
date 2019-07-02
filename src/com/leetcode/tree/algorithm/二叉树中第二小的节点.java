package com.leetcode.tree.algorithm;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shine10076
 * @date 2019/4/16 11:16
 * @leetcode 671
 */
public class 二叉树中第二小的节点 {

    /*分情况讨论*/
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        if (root.left == null && root.right == null) return -1;
        int left = root.left.val;
        int right = root.right.val;
        if (root.left.val == root.val) left = findSecondMinimumValue(root.left);
        if (root.right.val == root.val) right = findSecondMinimumValue(root.right);
        if (left != -1 && right != -1) return Math.min(left, right);
        if (left != -1) return left;
        return right;
    }

    public static void main(String[] args) {
    }
}
