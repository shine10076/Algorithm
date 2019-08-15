package com.offer.algorithm;

import com.leetcode.tree.algorithm.TreeNode;

/**
 * @author shine10076
 * @date 2019/8/15 14:45
 */
public class 平衡二叉树 {
    //平衡二叉树：左右子树的深度差不超过一
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) return true;
        int depth = Math.abs(TreeDepth(root.left)-TreeDepth(root.right));
        if(depth>1) return false;
        return IsBalanced_Solution(root.right) && IsBalanced_Solution(root.left);
    }

    private int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;
    }
}
