package com.offer.algorithm;

import com.leetcode.tree.algorithm.TreeNode;

/**
 * @author shine10076
 * @date 2019/8/19 15:17
 */
public class 对称二叉树 {

    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        if(pRoot.left != null && pRoot.right != null)
        {
            return isEqual(pRoot.right, pRoot.left);
        }
        else if(pRoot.left != null || pRoot.right != null)
        {
            return false;
        }else return true;
    }

    boolean isEqual(TreeNode right, TreeNode left)
    {
        if(right != null && left != null)
        {
            if(right.val != left.val) return false;

            return isEqual(right.right,left.left) && isEqual(right.left,left.right);

        }
        else if(right != null || left != null)
            return false;
        else
            return true;
    }
}
