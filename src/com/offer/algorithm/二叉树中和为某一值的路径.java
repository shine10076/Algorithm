package com.offer.algorithm;

import com.leetcode.tree.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author shine10076
 * @date 2019/8/1 15:01
 */
public class 二叉树中和为某一值的路径 {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return res;
        dfs(root,target,list,res);

        res.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.size()-o1.size();
            }
        });
        return res;

    }

    public void dfs(TreeNode node, int sum, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res)
    {
        if(node == null) return;
        if(node.right == null && node.right == null)
        {
            list.add(node.val);
            if(node.val == sum)  res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
        }

        list.add(node.val);
        if(node.left != null)
        {
            dfs(node.left,sum-node.val,list,res);
        }

        if(node.right != null)
        {
            dfs(node.right,sum-node.val,list,res);
        }

        list.remove(list.size()-1);
    }
}
