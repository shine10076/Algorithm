package com.leetcode.tree.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/4/22 11:12
 * @leetcode 94
 */
public class 非递归二叉树中序遍历 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            cur = node.right;
        }
        return list;
    }
}
