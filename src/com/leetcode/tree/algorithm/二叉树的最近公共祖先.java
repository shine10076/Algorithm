package com.leetcode.tree.algorithm;

import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/4/25 15:26
 */
public class 二叉树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        /*这说明p, q分别存在于左右子树中*/
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }
}
