package com.leetcode.tree.algorithm;

import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/4/24 10:20
 */
public class 把二叉搜索树转化为累加树 {

    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int sum = 0;
        while(cur != null || !stack.isEmpty())
        {
            while(cur != null)
            {
                stack.push(cur);
                cur = cur.right;
            }
            TreeNode node = stack.pop();
            int val = node.val;
            node.val += sum;
            sum += val;

            cur = node.left;
        }
        return root;
    }
}
