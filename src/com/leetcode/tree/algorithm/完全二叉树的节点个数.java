package com.leetcode.tree.algorithm;

/**
 * 时间复杂度 ： O((log N )^2)
 * @author shine10076
 * @date 2019/9/18 15:19
 */
public class 完全二叉树的节点个数 {

    public int countNodes(TreeNode root) {
        if(root == null)
        {
            return 0;
        }

        return bs(root,1,mostLevel(root,1));
    }

    private int bs(TreeNode root, int level, int h)
    {
        if(level == h)
        {
            return 1;
        }
        if(mostLevel(root.right,level+1) == h)
        {
            return (1<<(h-level)) + bs(root.right,level+1,h);
        }else
        {
            return (1<<(h-level-1)) + bs(root.left,level+1,h);
        }

    }

    private int mostLevel(TreeNode root, int level)
    {
        while (root != null)
        {
            level++;
            root = root.left;
        }

        return level-1;
    }

}
