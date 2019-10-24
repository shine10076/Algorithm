package com.leetcode.tree.algorithm;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author shine10076
 * @date 2019/10/24 9:52
 */
public class 验证二叉搜索树 {

    public boolean isValidBST(TreeNode root)
    {
        Stack<TreeNode> stack= new Stack<>();
        TreeNode cur = root;
        int inorder = Integer.MIN_VALUE;
        boolean isFirst = true;
        while(!stack.isEmpty()|| cur != null)
        {
            while(cur != null)
            {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode node = stack.pop();
            if(isFirst)
            {
                isFirst = false;
            }
            else if(node.val <= inorder)
            {
                return false;
            }
            inorder = node.val;

            cur = node.right;
        }

        return true;
    }


}
