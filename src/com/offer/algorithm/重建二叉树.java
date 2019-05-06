package com.offer.algorithm;

import com.leetcode.tree.algorithm.TreeNode;

/**
 * @author shine10076
 * @date 2019/5/3 21:47
 */
public class 重建二叉树 {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        return preAndIn(pre,0,pre.length-1,in,0,in.length-1);
    }

    public TreeNode preAndIn(int[] pre, int pl, int pr, int[] in, int il, int ir)
    {
        if(pl>pr || il>ir) return null;
        TreeNode root = new TreeNode(pre[pl]);
        for(int i=il;i<=ir;i++)
        {
            if(in[i] == pre[pl])
            {
                root.left = preAndIn(pre,pl+1,i-il+pl,in,il,i-1);
                root.right = preAndIn(pre,i-il+pl+1,pr,in,i+1,ir);
            }
        }
        return root;
    }

}
