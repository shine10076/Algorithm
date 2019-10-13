package com.leetcode.tree.algorithm;

/**
 * @author shine10076
 * @date 2019/10/13 19:08
 */
public class 前序和中序遍历构造二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int pi, int pj, int[] inorder, int ii, int ij)
    {
        if(pi>pj || ii > ij)
        {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pi]);

        for(int i = ii; i<=ij;i++)
        {
            if(preorder[pi] == inorder[i])
            {
                root.left = buildTree(preorder,pi+1,pi+(i-ii),inorder,ii,i-1);
                root.right = buildTree(preorder,pi+i-ii+1,pj,inorder,i+1,ij);
            }
        }


        return root;
    }
}
