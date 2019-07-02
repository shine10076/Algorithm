package com.leetcode.tree.algorithm;

import java.util.Map;

/**
 * @author shine10076
 * @date 2019/4/15 22:15
 */
public class 打家劫舍III {
    /*
     * 对于根节点，如果偷取了根节点，那么势必不可以偷取其左右节点，只能尝试去偷取左右两侧节点的子节点
     * 而如果不偷取根节点，则可以尝试偷取左右两侧的子节点
     *
     * */
//    public int rob(TreeNode root) {
//        if(root == null) return 0;
//        int val1 = root.val;
//        if(root.left != null) val1 += rob(root.left.left)+rob(root.left.right);
//        if(root.right != null) val1 += rob(root.right.left)+rob(root.right.right);
//        int val2 = rob(root.left)+rob(root.right);
//        return Math.max(val1,val2);
//    }

    /*dfs树的所有节点，每个节点返回两个数字，int [] num，num [0]是抢夺此节点时的最大值，num [1]是最大值而不抢夺此值。
            当前节点返回值仅取决于其子节点的值。
    * 0*/

    public int rob(TreeNode root) {
        int[] money = dfs(root);
        return Math.max(money[0], money[1]);
    }

    public int[] dfs(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] res = new int[2];
        res[0] = left[1] + right[1] + root.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}
