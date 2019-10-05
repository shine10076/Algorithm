package com.leetcode.tree.algorithm;

import java.util.*;

/**
 * @author shine10076
 * @date 2019/10/5 16:56
 */
public class 二叉树的锯齿形层次遍历 {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if(root == null ) return  res;

        Queue<TreeNode> queue = new LinkedList<>();
        boolean isReverse = false;
        queue.offer(root);
        while (!queue.isEmpty())
        {
            ArrayList<Integer> list = new ArrayList<>();
            Queue<TreeNode> tmp = new LinkedList<>();
            while (!queue.isEmpty())
            {
                tmp.offer(queue.poll());
            }
            while (!tmp.isEmpty())
            {
                TreeNode node = tmp.poll();
                if(node.left != null )
                {
                    queue.offer(node.left);
                }
                list.add(node.val);
                if(node.right != null)
                {
                    queue.offer(node.right);
                }
            }
            if(isReverse)
            {
                Collections.reverse(list);
            }
            isReverse = !isReverse;
            res.add(list);
        }


        return res;
    }
}
