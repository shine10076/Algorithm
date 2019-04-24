package com.leetcode.tree.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shine10076
 * @date 2019/4/17 16:42
 */
public class 二叉树的层平均值 {
    // TODO: 可以用queue.size 来代替另一个queue，区分每一层的值
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>(10);
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> floor = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            while(!queue.isEmpty()) floor.offer(queue.poll());
            /*每一层的平均值*/
            int count  = 0;
            double sum = 0;
            while(!floor.isEmpty())
            {
                TreeNode node = floor.poll();
                sum  += node.val;
                count++;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            double avg = sum/count;
            list.add(avg);
        }
        return list;
    }
}
