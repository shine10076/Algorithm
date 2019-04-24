package com.leetcode.tree.algorithm;

/**
 * @author shine10076
 * @date 2019/4/24 22:09
 * @leetcode 235
 */
public class 二叉搜索树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        /*都在左子树中*/
        if(root.val > p.val && root.val >q.val) return lowestCommonAncestor(root.left, p, q);
        /*都在右子树中*/
        if(root.val < p.val && root.val< q.val) return lowestCommonAncestor(root.right,p,q);
        return root;
}
}
