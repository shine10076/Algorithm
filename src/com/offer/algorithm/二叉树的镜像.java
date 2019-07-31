package com.offer.algorithm;

import com.leetcode.tree.algorithm.TreeNode;

/**
 * @author shine10076
 * @date 2019/7/31 20:18
 */
public class 二叉树的镜像 {

    public void Mirror(TreeNode root) {

        if(root!=null)
        {
            Mirror(root.right);
            Mirror(root.left);
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }
    }
}
