package com.leetcode.tree.algorithm;

/**
 * @author shine10076
 * @date 2019/10/1 15:26
 */
public class 二叉树展开为链表 {


    public void flatten(TreeNode root) {

        if(root == null ) return;

        flatten(root.left);
        flatten(root.right);
        if(root.left != null)
        {
            getRoot(root.left).right = root.right;
            root.right = root.left;
            root.left = null;
        }

    }

    public TreeNode getRoot(TreeNode node)
    {
        TreeNode res = node;
        while (res.right != null)
        {
            res = res.right;
        }
        return res;
    }
}
