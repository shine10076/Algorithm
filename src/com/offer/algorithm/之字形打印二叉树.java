package com.offer.algorithm;

import com.leetcode.tree.algorithm.TreeNode;

import java.util.*;

/**
 * @author shine10076
 * @date 2019/8/19 15:28
 */
public class 之字形打印二叉树 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(pRoot == null) return res;
        queue.offer(pRoot);
        int  flag = -1;
        while (!queue.isEmpty())
        {
            ArrayList<Integer> list = new ArrayList<>();
            Queue<TreeNode> tmp = new LinkedList<>();
            while(!queue.isEmpty())
            {
                TreeNode cur = queue.poll();
                if(cur.left != null) tmp.offer(cur.left);
                if(cur.right != null) tmp.offer(cur.right);
                list.add(cur.val);
            }
            if(flag == 1) Collections.reverse(list);
            flag = flag*(-1);
            res.add(list);
            while (!tmp.isEmpty())
            {
                queue.offer(tmp.poll());
            }
        }

        return res;
    }

}
