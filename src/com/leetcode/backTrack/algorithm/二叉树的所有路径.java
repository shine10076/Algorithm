package com.leetcode.backTrack.algorithm;

import com.leetcode.tree.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shine10076
 * @date 2019/7/22 21:30
 */
public class 二叉树的所有路径 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null)
        {
            return res;
        }

        dfs(root,new ArrayList<String>(),res);
        return res;
    }

    public void dfs(TreeNode node, List<String> sb, List<String> res)
    {
        if(node == null ) return;
        sb.add(Integer.toString(node.val));
        if(node.left == null && node.right == null)
        {
            StringBuilder temp = new StringBuilder();
            for(int i=0;i<sb.size();i++)
            {
                if(i!=sb.size()-1)
                {
                    temp.append(sb.get(i)+"->");
                }else
                {
                    temp.append(sb.get(i));
                }
            }
            res.add(temp.toString());
        }
        if(node.left != null)
        {
            dfs(node.left,sb,res);
        }
        if(node.right != null)
        {
            dfs(node.right,sb,res);
        }
        sb.remove(sb.size()-1);
        return ;
    }
}
