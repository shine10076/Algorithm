package com.offer.algorithm;

import com.leetcode.tree.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/8/1 15:55
 */
public class 二叉搜索树和双向链表 {

    public TreeNode Convert(TreeNode pRootOfTree) {

        if(pRootOfTree == null)
        {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        TreeNode cur = pRootOfTree;
        while (cur!=null || !stack.isEmpty())
        {
            while (cur!=null)
            {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode node = stack.pop();
            list.add(node);
            cur = node.right;
        }

        for(int i=0;i<list.size();i++)
        {
            if(i-1>=0)
            {
                list.get(i).left = list.get(i-1);
            }
            if(i+1<list.size())
            {
                list.get(i).right = list.get(i+1);
            }
        }

        return list.get(0);

    }

}
