package com.offer.algorithm;

import com.leetcode.tree.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/8/22 19:16
 */
public class 二叉搜索树的第k个节点 {


    static TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(k<=0) return null;
        List<TreeNode> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        if(pRoot == null) return null;
        TreeNode cur = pRoot;
        while (!stack.isEmpty() || cur != null)
        {
            while ( cur !=null )
            {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode node = stack.pop();
            list.add(node);
            cur = node.right;
        }

        if(k>list.size()) return null;
        return list.get(k-1);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        KthNode(root,1);
    }

}
