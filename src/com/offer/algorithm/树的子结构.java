package com.offer.algorithm;

import com.leetcode.tree.algorithm.TreeNode;

/**
 * @author shine10076
 * @date 2019/7/31 19:54
 */
public class 树的子结构 {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) return false;

        if(root1.val == root2.val)
        {
            if(isEqual(root1.right,root2.right)&&isEqual(root1.left, root2.left))
                return true;
            return HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
        }else
        {
            return HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
        }

    }

    public boolean isEqual(TreeNode root1, TreeNode root2)
    {
        if(root2 == null) return true;
        if(root1 == null) return false;

        if(root1.val != root2.val)
        {
            return false;
        }else
        {
            return isEqual(root1.left,root2.left)&&isEqual(root1.right,root2.right);
        }
    }

}
